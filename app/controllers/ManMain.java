package controllers;



import models.ManAuth;
import models.Manager;
import play.mvc.Security;
import play.mvc.*;

import static play.mvc.Http.Context.Implicit.session;
import static play.mvc.Results.ok;

/**
 * Created by Whale on 12/6/2015.
 */

@Security.Authenticated(ManAuth.class)
public class ManMain {


    public Result getManMain() {

        String the_id = session().get("Man_id"), user_name;
        Long query = Long.valueOf(the_id);
        query = Long.valueOf(the_id).longValue();
        Manager the_user = Manager.find.byId(query);
        user_name = the_user.username;
        // List<Inventory> tool_List = Inventory.find.all();   THE ITEMS THING DO WONT GO HERE...

        return ok(views.html.ManMain.render( user_name));
    }



}
