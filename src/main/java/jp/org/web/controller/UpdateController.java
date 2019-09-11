package jp.org.web.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.org.web.form.LessonListForm;
import jp.org.web.repository.LessonListRepository;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateController.class);
	
	@Autowired
	private LessonListRepository lessonListRepository;
	
	@ModelAttribute
	public LessonListForm setLessonListForm() {
		LessonListForm lessonListForm = new LessonListForm();
		return lessonListForm;
	}
	
	@ModelAttribute
	public LessonListForm getLessonListForm(LessonListForm lessonListForm) {
		return lessonListForm;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/02_update/update/{id}", method = RequestMethod.GET)
	public String displayData(@PathVariable String id, Model model) {
		logger.info("Update screen display id:" + id);
		
		
		LessonListForm lessonListForm = lessonListRepository.getLessonListOne(id);
		model.addAttribute("lessonListForm", lessonListForm);
		
		return "/02_update/update";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/02_update/update/{id}", method = RequestMethod.POST)
	public String updateData(@PathVariable String id, Model model, LessonListForm lessonListForm) throws UnsupportedEncodingException {
		logger.info("Update screen display id:" + id);
		
		logger.info("val -> " + lessonListForm.getUserFirstName());
		
		return "/02_update/update";
	}


}