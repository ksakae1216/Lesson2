package jp.org.web.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.org.web.form.LanguageForm;
import jp.org.web.form.LessonListForm;
import jp.org.web.repository.LanguageRepository;
import jp.org.web.repository.LessonListRepository;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateController.class);
	
	@Autowired
	private LessonListRepository lessonListRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
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
	public String home(Locale locale, Model model, @PathVariable String id) {
		logger.info("Update screen display");
		logger.info("userId -> " + id);

		LessonListForm lessonDataForm = lessonListRepository.getLessonListOne(id);
		model.addAttribute("lessonListForm", lessonDataForm);
		
		List<LanguageForm> languageForm = languageRepository.getlanguage();
		model.addAttribute("languageForm", languageForm);
		
		return "/02_update/update";
	}

	@RequestMapping(value = "/02_update/update/addRow", method = RequestMethod.GET)
	public String initNewRow(Locale locale, Model model) {
		logger.info("Update screen display new row");

		String newUserId = String.format("%03d", this.getAddRowNo());
		LessonListForm lessonDataForm = new LessonListForm();
		lessonDataForm.setUserId(newUserId);
		model.addAttribute("lessonListForm", lessonDataForm);
		
		List<LanguageForm> languageForm = languageRepository.getlanguage();
		model.addAttribute("languageForm", languageForm);
		
		return "/02_update/update";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/02_update/update/{id}", method = RequestMethod.POST)
	public String updateData(@PathVariable String id, Model model, LessonListForm lessonListForm) {
		logger.info("update data");
		
		if(lessonListForm.isDeleteFlg()) {
			lessonListRepository.delete(id);
		} else {
			lessonListRepository.update(lessonListForm.getUserFirstName(), lessonListForm.getUserLastName(), lessonListForm.getLesson1st(), lessonListForm.getLesson2nd(), id);
		}

		List<LanguageForm> languageForm = languageRepository.getlanguage();
		model.addAttribute("languageForm", languageForm);

		return "redirect:/01_list/list";
	}

	private int getAddRowNo() {
		List<LessonListForm> list = lessonListRepository.getLessonListMap();
		int newRowId = 1;
		for(LessonListForm lessonForm: list) {
			int userIdInt = Integer.parseInt(lessonForm.getUserId());
			if(userIdInt != newRowId) {
				return newRowId;
			}
			newRowId++;
		}
		
		return newRowId;
	}

}