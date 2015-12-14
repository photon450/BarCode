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

        return ok(views.html.UserPage.render(user_name));
    }
}


