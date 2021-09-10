package DiamonShop.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl AccountService = new AccountServiceImpl();

	@RequestMapping(value = "dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(@ModelAttribute("user") Users user) {
		int count = AccountService.AddAccount(user);
		if (count > 0) {
			_mvShare.addObject("status", "Đăng ký thành công!");
		} else {
			_mvShare.addObject("status", "Đăng ký thất bại!");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") Users user) {
    
		boolean check = AccountService.CheckAccount(user);
		 if(check) {
			
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
			
	      }
	      else {
	    	  _mvShare.addObject("statusLogin","Đăng nhập thất bại!");
	      }
  	_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
}
