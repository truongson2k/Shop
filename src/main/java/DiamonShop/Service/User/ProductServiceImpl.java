package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
    ProductsDao productDao = new ProductsDao();
	public ProductsDto GetProductsById(long id) {
		List<ProductsDto> listProducts = productDao.GetAllProductsByID(id);
		return listProducts.get(0);
	}
	@Override
	public List<ProductsDto> GetProductsByIdCategory(long id) {
		return productDao.GetAllProductsByID(id);
	}

}
