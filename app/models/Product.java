package models;


import com.avaje.ebean.Model;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
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
    public List<Product> products = new ArrayList<Product>();

   // Long ProductID;


    public String ProductDesc;
   public  String Category;
    public Integer Availability;


    public static Product createNewProduct(String SKU, String Product_Name, String Category,String Condition, String Desc,Integer Availability )
    {
       if( SKU == null  )
           return null;

        Product product = new Product();
        product.SKU = SKU;
        product.Product_Name = Product_Name;
        product.Category = Category;
        product.Condition = Condition;
        product.ProductDesc = Desc;
        product.Availability = Availability;
        return product;


    }

  //  public Product update(String SKU, String Product_Name, String Category,String Condition, String Desc,Integer Availability)


}
