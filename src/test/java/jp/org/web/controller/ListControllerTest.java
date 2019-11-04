package jp.org.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import jp.org.web.form.LessonListForm;
import jp.org.web.repository.LessonListRepository;

public class ListControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ListControllerTest.class);
	
	@InjectMocks
	private ListController listController;
	
	@Mock
	private LessonListRepository lessonRepository;

	List<LessonListForm> lessonListFormList;
	
	@Mock
	private Model model;

	@Before
	public void setUp() {
		//おまじない
        initMocks(this);
        
        this.setupLessonList();
	}
	
	private void setupLessonList() {
        //lessonListテーブルの準備
        LessonListForm listForm1 = new LessonListForm();
        listForm1.setUserId("001");
        listForm1.setUserFirstName("taro");
        listForm1.setUserLastName("Yamada");
        listForm1.setLesson1st("Java");
        listForm1.setLesson2nd("Go");

        LessonListForm listForm2 = new LessonListForm();
        listForm2.setUserId("002");
        listForm2.setUserFirstName("jiro");
        listForm2.setUserLastName("Yamada");
        listForm2.setLesson1st("PHP");
        listForm2.setLesson2nd("Angular");

        lessonListFormList = new ArrayList<>();
        lessonListFormList.add(listForm1);
        lessonListFormList.add(listForm2);
	}

	@Test
	public void testHome() {
		logger.info("Start testHome");
		
		when(lessonRepository.getLessonListMap()).thenReturn(lessonListFormList);
		
		assertThat(listController.home(model), is("/01_list/list"));
		
		logger.info("End testHome");
	}

	@Test
	public void testDoLogout() {
		logger.info("Start testDoLogout");
		
		assertThat(listController.doLogout(model), is("redirect:/login"));
		
		logger.info("End testDoLogout");
	}

	@Test
	public void testDoAddRow() {
		logger.info("Start testDoAddRow");
		
		assertThat(listController.doAddRow(model), is("redirect:/02_update/update/addRow"));
		
		logger.info("End testDoAddRow");
	}

}
