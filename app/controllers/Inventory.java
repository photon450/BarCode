package controllers;

import models.Product;
import play.mvc.*;
import play.data.DynamicForm;
import views.html.InvPage;
import play.data.Form;

import static play.mvc.Results.ok;
import views.html.*;
import static play.data.Form.form;
import views.*;

/**
 * Created by Whale on 12/6/2015.
 */
public class Inventory extends Controller {

    public Result getInvPage(){
        return ok( InvPage.render(navibar.retrieveId() ) );
    }
    public Result getAddInvPage(){
        return ok( addInvPage.render(navibar.retrieveId() ) );
    }
    /*public Result getViewInv() {


        return ok(ViewInv.render(navibar.retrieveId(), the_product ) );} */
    public Result addInv(){
        Form<Product> userForm = form(Product.class).bindFromRequest();      //creates a DynamicForm userform we bind from the request
            String SKU = userForm.data().get("SKU");
            String Product_Name = userForm.data().get("Product_Name");
            String Category = userForm.data().get("Category");
            String Condition = userForm.data().get("Condition");
            String Desc = userForm.data().get("Desc");
            Integer Availability = Integer.valueOf(userForm.data().get("Quantity"));

        Product product = Product.createNewProduct(SKU, Product_Name, Category, Condition, Desc, Availability);

        if(product == null) {
            flash("ERROR", "Invalid Inventory entry");
            return redirect(routes.Inventory.getInvPage());
        }

        product.save();

        flash("success", "Added new item" + SKU +" " + Product_Name );
        return  redirect(routes.Inventory.getInvPage());
    }


}
