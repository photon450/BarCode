package models;

import scala.collection.generic.BitOperations;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import play.data.format.Formats;
import play.data.validation.Constraints;
/**
 * Created by Whale on 12/2/2015.
 */
@Entity
public class Product extends Inventory {


    public static Finder<Long, Product> find = new Finder<Long, Product>(Product.class);

    Long ProductID;

    String ProductName;
    String ProductDesc;
    String Category;
    BitOperations.Int Availability;


}
