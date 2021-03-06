package models;

import controllers.routes;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.*;
import play.libs.F;

/**
 * Created by Whale on 11/16/2015.
 */
public class UserAuth extends Security.Authenticator {

  //  if()
    // When return is null, Authentication failed
    @Override
    public String getUsername(final Http.Context ctx) {
        String userIdStr = ctx.session().get("user_id");
        if(userIdStr == null) return null;

        User user = User.find.byId(Long.parseLong(userIdStr));
        return (user != null ? user.id.toString() : null);
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put("error",
                "Nice try, but you need to log in first!");
        return redirect(routes.Application.index());
    }
}


