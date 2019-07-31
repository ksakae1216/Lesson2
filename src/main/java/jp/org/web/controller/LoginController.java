package jp.org.web.controller;

import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.org.web.dao.LoginDao;
import jp.org.web.entity.LoginEntity;
import jp.org.web.form.LoginForm;
import jp.org.web.sql.LoginMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
//	@Autowired
//	private LoginMapper loginMapper;
	
	@Autowired
	private LoginDao loginDao;
	
	@ModelAttribute
	public LoginForm setLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Login screen display");
		
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(LoginForm loginForm) {
		logger.info("Login - doLogin start");
		logger.info("loginId  -> " + loginForm.getLoginId());
		logger.info("password -> " + loginForm.getPassword());
		
		String ret = "login";

		// check table samurai_login
//		String loginResult = loginMapper.getUserMap(loginForm.getLoginId(), loginForm.getPassword());
		String loginResult = "abc";

		// login and password is blank when login fail
		if(loginResult != null) {
			ret = "home";
		} else {
			logger.info("Login NG, Back loin page");
			loginForm.setLoginId("");
			loginForm.setPassword("");
		}

		logger.info("Login - doLogin stop");
		
//		loginDao.getLoginData();
		List<LoginEntity> list = loginDao.findAll();
		System.out.println(list.toString());
		
		return ret;
	}

}