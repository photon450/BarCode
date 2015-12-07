package models;

import scala.collection.generic.BitOperations;

import java.util.Date;
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
 * Created by Whale on 12/6/2015.
 */
@Entity
public class Sales {

    public Date Day_sold;
    public BitOperations.Int QTYSold;

}
