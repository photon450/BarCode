package controllers;

import play.mvc.*;
import views.html.InvPage;

import static play.mvc.Results.ok;
import views.html.*;

/**
 * Created by Whale on 12/6/2015.
 */
public class Inventory extends Controller {

    public Result getInvPage(){
        return ok( InvPage.render(navibar.retrieveId() ) );
    }


}
