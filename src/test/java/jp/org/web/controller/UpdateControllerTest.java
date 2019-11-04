package jp.org.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import jp.org.web.form.LessonListForm;
import jp.org.web.form.LoginForm;
import jp.org.web.repository.LanguageRepository;
import jp.org.web.repository.LessonListRepository;
import jp.org.web.util.PrepareLessonList;

public class UpdateControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(UpdateControllerTest.class);
	
	@InjectMocks
	private UpdateController updateController;
	
	@Mock
	private LessonListRepository lessonListRepository;
	
	@Mock
	private LanguageRepository languageRepository;

	private Locale locale;
	
	@Mock
	private Model model;
	
	private List<LessonListForm> lessonFormList;
	
	@Before
    public void setUp() {
		//おまじない
        initMocks(this);
        
        lessonFormList = PrepareLessonList.setupLessonList();
    }

	@Test
	public void testHome() {
		logger.info("Start testHome");
		
		String userId = "001";
		
		Optional<LessonListForm> getLessonListForm = PrepareLessonList.getListFromId(lessonFormList, userId);
		
		if(!getLessonListForm.isPresent()) {
			fail(userId + " is not found in lesson list.");
		}
		
		when(lessonListRepository.getLessonListOne(userId)).thenReturn(getLessonListForm.get());
		when(languageRepository.getlanguage()).thenReturn(new ArrayList());

		assertThat(updateController.home(locale, model, userId), is("/02_update/update"));
		
		logger.info("End testHome");
	}

	@Test
	public void testInitNewRow() {
		logger.info("Start testInitNewRow");
		
		fail("Not yet implemented");
		
		logger.info("End testInitNewRow");
	}

	@Test
	public void testGetInformation() {
		logger.info("Start testGetInformation");
		
		fail("Not yet implemented");
		
		logger.info("End testGetInformation");
	}

	@Test
	public void testUpdateData() {
		logger.info("Start testUpdateData");
		
		fail("Not yet implemented");
		
		logger.info("End testUpdateData");
	}

}
