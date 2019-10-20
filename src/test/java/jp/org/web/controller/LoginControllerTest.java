package jp.org.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import jp.org.web.form.LoginForm;
import jp.org.web.repository.LoginRepository;
import jp.org.web.message.LoginMessage;


public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;
	
	@Mock
	private LoginRepository loginRepository;
	
	private Locale locale;
	
	private Model model;
	
	private LoginForm loginForm;
	
	@Mock
	private BindingResult result;
	
	@Before
    public void setUp() {
		//おまじない
        initMocks(this);
        
        loginForm = new LoginForm();
        loginForm.setLoginId("testId");
        loginForm.setPassword("testPassword");
    }
	
	@Test
	public void testHome() {
		assertThat(loginController.home(locale, model, loginForm), is("login"));
	}

	@Test
	public void testSuccessLogin() {
		when(loginRepository.getUserMap("testId", "testPassword")).thenReturn("testId");
		
		assertThat(loginController.doLogin(loginForm, result), is("redirect:/01_list/list"));
	}

	@Test
	public void testloginIdBlank() {
		loginForm.setLoginId("");
		when(result.hasErrors()).thenReturn(true);
		
		assertThat(loginController.doLogin(loginForm, result), is("login"));
		assertThat(loginForm.getLoginId(), is(""));
		assertThat(loginForm.getPassword(), is("testPassword"));
		assertThat(loginForm.getErrorMessage(), is(LoginMessage.loginIdBlank));
	}

	@Test
	public void testpasswordBlank() {
		loginForm.setPassword("");
		when(result.hasErrors()).thenReturn(true);
		
		assertThat(loginController.doLogin(loginForm, result), is("login"));
		assertThat(loginForm.getLoginId(), is("testId"));
		assertThat(loginForm.getPassword(), is(""));
		assertThat(loginForm.getErrorMessage(), is(LoginMessage.passwordBlank));
	}


	@Test
	public void testFailLogin() {
		when(loginRepository.getUserMap("testId", "failPassword")).thenReturn(null);
		
		assertThat(loginController.doLogin(loginForm, result), is("login"));
		assertThat(loginForm.getLoginId(), is(""));
		assertThat(loginForm.getPassword(), is(""));
		assertThat(loginForm.getErrorMessage(), is(LoginMessage.idPassUnmach));
	}
	

}
