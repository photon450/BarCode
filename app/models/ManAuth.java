package models;

/**
 * Created by Whale on 12/6/2015.
 */

import controllers.routes;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.*;
import play.libs.F;




    public class ManAuth extends Security.Authenticator {


        // When return is null, Authentication failed
        @Override
        public String getUsername(final Http.Context ctx) {
            String userIdStr = ctx.session().get("Man_id");
            if(userIdStr == null) return null;

            Manager manager = Manager.find.byId(Long.parseLong(userIdStr));
            return (manager != null ? manager.id.toString() : null);
        }

        @Override
        public Result onUnauthorized(final Http.Context ctx) {
            ctx.flash().put("error",
                    "Only Managerial Access Accepted");
            return redirect(routes.Application.index());
        }
    }

