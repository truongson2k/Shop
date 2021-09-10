package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginateDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired 
	private PaginateServiceImpl paginateService;
	
	int totalProductsPage = 9 ;
	
    @RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Category(@PathVariable String id) {
    	_mvShare.setViewName("user/products/caterogy");
    	
    	
		
		int totalData = categoryService.GetAllProductsById(Integer.parseInt(id)).size();
		PaginateDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory",id);
		_mvShare.addObject("paginateInfo",paginateInfo);
		_mvShare.addObject("productsPaginate",categoryService.GetDataProductPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		
		return _mvShare;
	}
    
    @RequestMapping(value = "/san-pham/{id}/{currentPage}")
   	public ModelAndView Category(@PathVariable String id, @PathVariable String currentPage) {
       	_mvShare.setViewName("user/products/caterogy");
      
   		int totalData = categoryService.GetAllProductsById(Integer.parseInt(id)).size();
   		PaginateDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
   		_mvShare.addObject("idCategory",id);
   		_mvShare.addObject("paginateInfo",paginateInfo);
   		_mvShare.addObject("productsPaginate",categoryService.GetDataProductPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductsPage));
   		
   		return _mvShare;
   	}
}
