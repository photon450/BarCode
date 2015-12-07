package controllers;

/**
 * Created by senoid on 11/7/2015.
 */


import models.User;
import models.UserAuth;
import play.mvc.*;

import static play.data.Form.form;

@Security.Authenticated(UserAuth.class)
public class UserPage extends Controller {
    public Result getUserPage() {

        String the_id = session().get("user_id"), user_name;
        Long query = Long.valueOf(the_id);
        query = Long.valueOf(the_id).longValue();
        User the_user = User.find.byId(query);
        user_name = the_user.username;
       // List<Inventory> tool_List = Inventory.find.all();   THE ITEMS THING DO WONT GO HERE...

        return ok(views.html.UserPage.render( user_name));
    }

/*    @Security.Authenticated(UserAuth.class)
    public Result addTool() {
        //Add in some null checkers later
        Form<Inventory> userForm     = form(Inventory.class).bindFromRequest();        remove?
        String Tool_Name        = userForm.data().get("Tool_Name");
        String Tool_Description = userForm.data().get("Tool_Description");
        String Condition        = userForm.data().get("Condition");

        Inventory tool = Inventory.createNewTool(Tool_Name, Tool_Description, Condition);

        String usrIdStr = session().get("user_id");
        Long query = Long.valueOf(usrIdStr).longValue();

        User user = User.find.where().eq("id", query).findUnique();

        if(tool == null)
        {
            flash("FATALERROR");
            return redirect(routes.Application.index());
        }
        else{
            tool.user = user;
            tool.save();
            user.addTool(tool);

        }
        return getUserPage();
    }
    */
}
