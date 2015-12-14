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
    public Result  updateInvPage(Long Id) {

        Product the_product;

        the_product = Product.find.byId((Id));

        return ok( UpdateInv.render(navibar.retrieveId(), the_product));
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

        flash("success", "Added new item " +"SKU:"+  SKU +" " + Product_Name );
        return  redirect(routes.Inventory.getInvPage());
    }

    public Result uppInv(Long Id ) {
        Form<Product> userForm = form(Product.class).bindFromRequest();      //creates a DynamicForm userform we bind from the request
        String SKU = userForm.data().get("SKU");
        String Product_Name = userForm.data().get("Product_Name");
        String Category = userForm.data().get("Category");
        String Condition = userForm.data().get("Condition");
        String Desc = userForm.data().get("Desc");
        // Integer Availability = Integer.valueOf(userForm.data().get("Quantity")); Removed feuture
       // Product product2 = new Product();
        Product  product;
        product =  Product.find.where().eq("Id", Id).findUnique();

        if(product.Id == 0) {
            flash("error", "Item not found");
            return redirect(routes.Inventory.getInvPage());
        }

        if(!SKU.isEmpty()){
        product.SKU = SKU;}

        if(Product_Name != null){
        product.Product_Name = Product_Name; }

        if(!Category.isEmpty()){
        product.Category = Category;}

        if(!Condition.isEmpty()){
        product.Condition = Condition;}

        if(!Desc.isEmpty()){
        product.ProductDesc = Desc;}
        /* if(Availability != null )
        product.Availability = Availability; */
        String Ids =  String.valueOf(Id);

        if(Ids == null){
            flash("error", "Item not found");
            return redirect(routes.Inventory.getInvPage());}

       product.save();    // (String.valueOf(product.Id));


        flash("success", "Updated Inventory: " + product.Product_Name + "this is its sku:" + product.SKU);
        return redirect(routes.Inventory.getInvPage());
    }

}
