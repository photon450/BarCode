package models;

/**
 * Created by Whale on 11/13/2015.
 */
import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.mvc.*;

@Entity
public class Manager extends Account {

    public static Finder<Long, Manager> find = new Finder<Long, Manager>(Manager.class);

    public static Manager createNewManager(String email, String password, String first_name, String last_name, String username, String code) {
        if(password == null || email == null || password.length() < 8 || username == null || code == null) {
            return null;
        }
            // if not null continue process
            // hash and salt the password

            String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

            // proceed to create the user, dont worry inherits from Account.
            Manager manager = new Manager();
            manager.email = email;
            manager.passwordHash = passwordHash;
            manager.first_name = first_name;
            manager.last_name = last_name;
            manager.username = username;
            manager.dateCreated = new java.util.Date();

                return manager;


        }

        public boolean authenticate(String password)
        {
            return BCrypt.checkpw(password, this.passwordHash);
        }

}
