package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginateDto;

@Service
public interface IPaginatesService {
	
   public PaginateDto GetInfoPaginates(int totalData,int limit, int currentPage);
}
