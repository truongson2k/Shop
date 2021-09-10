package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
@Service
public interface ICategoryService {
	@Autowired
	public List<ProductsDto> GetAllProductsById(int id);
    public List<ProductsDto> GetDataProductPaginate(int start ,int end);
   List<ProductsDto> GetDataProductPaginate(int id, int start, int totalPage);
}
