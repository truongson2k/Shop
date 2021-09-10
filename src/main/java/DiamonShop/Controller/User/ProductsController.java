package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.IProductService;

@Controller
public class ProductsController extends BaseController {
	@Autowired
	private IProductService _productService;
	
     @RequestMapping(value = {"chi-tiet-san-pham/{id}"})
    public  ModelAndView product(@PathVariable long id) {
    	 _mvShare.setViewName("user/products/product");
    	 
    	 _mvShare.addObject("product",_productService.GetProductsById(id));
    	 int idCategory = _productService.GetProductsById(id).getId_category();
    	 _mvShare.addObject("productByIdCategory",_productService.GetProductsByIdCategory(idCategory));
    	return _mvShare;
    }
}
