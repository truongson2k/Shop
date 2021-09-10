package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface IProductService {

	public ProductsDto GetProductsById(long id);
	public List<ProductsDto> GetProductsByIdCategory(long id);
}
