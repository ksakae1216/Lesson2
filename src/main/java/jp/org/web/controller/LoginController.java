package jp.org.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.org.web.form.LoginForm;
import jp.org.web.repository.LoginRepository;


/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginRepository loginRepository;
	
	@ModelAttribute
	public LoginForm setLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model, LoginForm loginForm) {
		logger.info("Login screen display");
		
		loginForm.setLoginId("abc");
		
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(LoginForm loginForm) {
		logger.info("Login - doLogin start");
		logger.info("loginId  -> " + loginForm.getLoginId());
		logger.info("password -> " + loginForm.getPassword());
		
		String ret = "login";
		
		// DBに接続
		String loginResult = loginRepository.getUserMap(loginForm.getLoginId(), loginForm.getPassword());
		
		if(loginResult != null) {
			logger.info("Login OK, Next Page is home");
			ret = "home";
		} else {
			logger.info("Login NG, Back loin page");
			loginForm.setLoginId("失敗");
			loginForm.setPassword("");
		}

		logger.info("Login - doLogin stop");

		return ret;
	}

}