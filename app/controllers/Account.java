package controllers;

/**
 * Created by Whale on 11/15/2015.
 */

//add id of manager or user to pass to userauth


import models.ManAuth;
import models.User;
import models.UserAuth;
import play.data.DynamicForm;
import play.mvc.*;

import views.html.*;

import play.data.Form;

import static play.data.Form.form;
import play.mvc.Security.Authenticated;

public class Account extends Controller {

    public Result getLoginPage() {
        return ok(Login.render(navibar.retrieveId()));
    }
    @Security.Authenticated(ManAuth.class)
    public Result getRegPage() { return ok(Registration.render(navibar.retrieveId()));}

// we define adduser here.
public Result addUser() {
    Form<User> userForm = form(User.class).bindFromRequest();      //creates a DynamicForm userform we bind from the request
    String email = userForm.data().get("email");
    String password = userForm.data().get("password");
    String first_name = userForm.data().get("first_name");
    String last_name = userForm.data().get("last_name");
    String username = userForm.data().get("username");

    //returns a user
    User user = User.createNewUser(email, password, first_name, last_name, username);
    User userf = User.find.where().eq("email", email).findUnique();
    if( userf != null){
        flash("error", "User already Exists" );
        return redirect(routes.Application.index());
    }

    if(user == null){
        flash("error", "invalid user");
        return redirect(routes.Account.getRegPage());   // so if didnt put an email warn em witha flash message and redirect back to login page
    }
    user.save();

    flash("success", "You added Employee,  " + user.email);    // added to session
    //session("user_id", user.id.toString());
    return redirect(routes.ManagerAcc.getManMain()); // leaves at their Main user page
}

    public Result logout() {
        session().remove("user_id");
         session().remove("Man_id");
        return ok(Home.render(navibar.retrieveId()));
    }

    public Result login() {
        DynamicForm userForm = form().bindFromRequest();
        String email = userForm.data().get("email");
        String password = userForm.data().get("password");
        User user = User.find.where().eq("email", email).findUnique();

        if(user != null && user.authenticate(password)) {
            session("user_id", user.id.toString());
            flash("success", "Welcome back " + user.username);
        } else {
            flash("error", "Invalid login. Check your username and password.");
        }

        return redirect(routes.Application.index());

    }


}