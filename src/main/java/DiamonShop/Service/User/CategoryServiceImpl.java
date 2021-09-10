package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
   private  ProductsDao productDao;
	

	@Override
	public List<ProductsDto> GetAllProductsById(int id) {
		return productDao.GetAllProductsByID(id);
	}


	@Override
	public List<ProductsDto> GetDataProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductsDto> GetDataProductPaginate(int id,int start, int totalPage) {
		return productDao.GetDataProductsPaginate(id,start, totalPage) ;
		 
	}



	

}
