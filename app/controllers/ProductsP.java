package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.ViewInv;
import views.html.productPage;
import views.*;

import java.util.List;


/**
 * Created by Whale on 12/7/2015.
 */
public class ProductsP extends Controller {
    public Result displayProduct(Long id) {

        Product the_product;

        the_product = Product.find.byId(id);
        return ok(productPage.render(navibar.retrieveId(), the_product));
    }

    public Result getViewInv() {
        List<Product> the_product = Product.find.all();

        return ok(views.html.ViewInv.render( navibar.retrieveId(), the_product));

    }
     /*   Product product = null; //= Product.find.byId(Long.parseLong(Product.SKU));  //= Product.find.byId(Long.parseLong(Product.SKU));
        //if(!product.products.isEmpty())
        the_product = product.products;

        else the_product = null;
         if( !the_product.isEmpty() )
        {   product = the_product;
            return ok(ViewInv.render(navibar.retrieveId(),  the_product));}
        //else
           // the_product = null;
        return ok(ViewInv.render(navibar.retrieveId(), the_product));
    } */
}
