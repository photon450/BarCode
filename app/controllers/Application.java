package controllers;


import play.mvc.*;

import views.html.*;


public class Application extends Controller {

    public Result index(String code) {
        return ok(Home.render(navibar.retrieveId(code)));
    }

    public Result index() {
        return ok(Home.render(navibar.retrieveId()));
    }


}
