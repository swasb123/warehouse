package controllers;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.html.products.*;

import java.util.List;

public class Products extends Controller {
	
	public static Result list(){
		List<Product> products = Product.findall();
		return ok(list.render(products));
	}
	
	private static final Form<Product> productForm = Form.form(Product.class);
	
	public static Result newProduct(){
		return ok(details.render(productForm));
	}
	
	public static Result details(String ean){
		return TODO;
	}
	
	public static Result save(){
		return TODO;
	}
}

