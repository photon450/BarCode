package models;


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * Created by Whale on 11/13/2015.
 */
@MappedSuperclass
public class Inventory extends Model {

    @Id
     public long SKU;

     public String Product_Name;

     public String  Tool_Description;

    public String Conditions;

    
    public static Finder<Long, Inventory> find = new Finder<Long, Inventory>(Inventory.class);


   // public static Inventory createNewInventory( Inventory SKU )







}