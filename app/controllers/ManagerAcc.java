package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import models.Manager;
import views.html.*;

import static play.data.Form.form;
import play.data.Form;
import views.html.ManMain;

import java.util.Objects;

/**
 * Created by Whale on 12/5/2015.
 */
public class ManagerAcc extends Controller {


    public Result getManPage() {
        return ok(ManRegPage.render(navibar.retrieveId()));
    }

    public Result getManMain(){
        return ok(ManMain.render(navibar.retrieveId()) );
    }
    public Result getMLogin() {return  ok(MLogin.render(navibar.retrieveId()));  }



        public Result addMan(){
            Form<Manager> userForm = form(Manager.class).bindFromRequest();      //creates a DynamicForm userform we bind from the request
            String email = userForm.data().get("email");
            String password = userForm.data().get("password");
            String first_name = userForm.data().get("first_name");
            String last_name = userForm.data().get("last_name");
            String username = userForm.data().get("username");
            String code = userForm.data().get("code");


              //creates new manager object to save to DB
            Manager manager = Manager.createNewManager(email, password, first_name, last_name, username,code);
            Manager Fmanager = Manager.find.where().eq("email", email).findUnique();

            String SecretCode = "YesIam";
            if(!code.equals(SecretCode)) {
                 flash("error", "invalid code!");
                return redirect(routes.ManagerAcc.getManPage());
            }

            if( Fmanager != null){
                flash("error", "Admin already Exists" );
                return redirect(routes.Application.index());
            }

            manager.save();



            flash("success", "Welcome new user " + manager.email);    // now added to session
            session("Man_id", manager.id.toString());  //ad user_id too
            return redirect(routes.ManagerAcc.getManMain());


        }


    public Result logout() {
        session().remove("Man_id");
        return ok(Home.render(navibar.retrieveId()));
    }



    public Result login() {
        DynamicForm userForm = form().bindFromRequest();
        String email = userForm.data().get("email");
        String password = userForm.data().get("password");
        String code = userForm.data().get("code");
        Manager manager = Manager.find.where().eq("email", email).findUnique();


            if(manager != null && manager.authenticate(password) /* && code == "YesIam" */) {
            session("Man_id", manager.id.toString());
            flash("success", "Welcome back " + manager.username);
                redirect(routes.ManagerAcc.getManMain());
        } else {
            flash("error", "Invalid login. Check your credentials.");
            return redirect(routes.home.getHome());
        }

        return redirect(routes.ManagerAcc.getManMain());

    }


}
