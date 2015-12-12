package controllers;

import models.User;
import play.mvc.Controller;
import models.Manager;

/**
 * Created by senoid on 11/21/2015.
 */
public class navibar extends Controller {

    public static String retrieveId() {
        String the_id = session().get("user_id"), user_name;
        String m_id = session().get("Man_id"), name;
        //Check if not null later
        Long query = null;

        if (the_id != null) {
            query = Long.valueOf(the_id).longValue();
              //beacuse using the_id which is users
                User the_user = User.find.byId(query);
                user_name = the_user.username;
                return user_name;
            } else if (m_id != null) {
                query = Long.valueOf(m_id).longValue();  //switch to managers
                Manager the_man = Manager.find.byId(query);
                return user_name = the_man.username;

            } else user_name = null;


        return user_name;
    }
}
  /*  public static String retrieveId() {
        String the_id = session().get("user_id"), user_name;
        //Check if not null later
        Long query = null;
        if (the_id != null) {
            query = Long.valueOf(the_id).longValue();
            User the_user = User.find.byId(query);
            user_name = the_user.username;

        } else {
            user_name = null;


            if (the_id != null) {

                the_id = session().get("Man_id");
                //Check if not null later
                query = null;

                query = Long.valueOf(the_id).longValue();
                Manager the_user = Manager.find.byId(query);
                user_name = the_user.username;

            } else {
                user_name = null;

            }
            return user_name;


        }
        return user_name;
    }
    public static String retrieveId(String code) {
        String word = null;

        if (code == null) {

            String the_id = session().get("Man_id"), user_name;
            //Check if not null later
            Long query = null;
            if (the_id != null) {


                query = Long.valueOf(the_id).longValue();
                User the_user = User.find.byId(query);
                user_name = the_user.username;

            } else {
                user_name = null;

            }
            return user_name;
        }
        return word;

    }

} */