package org.code0.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.code0.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**  
 * @Title: StudentController.java
 * @Package org.code0.demo.controller
 * @Description: StudentController<br/>
 * hibernate-validator实现表单验证
 * @author Code0   
 * @date 2017年9月13日 下午6:02:09 
 */
@Controller
@RequestMapping("/student")//该类中所有方法处理基于`/student`父路径下的请求
public class StudentController {


	/*
	 * This method will serve as default GET handler.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "demo/enroll";
	}

	/*
	 * This method will be called on form submission, handling POST request
	 * It also validates the user input
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model){

		if(result.hasErrors()) {
		        return "demo/enroll";
		}

		model.addAttribute("success", "Dear "+ student.getFirstName()+" , your Registration completed successfully");
		return "demo/success";
	}

	/*
	 * Method used to populate the Section list in view.
	 * Note that here you can call external systems to provide real data.
	 */
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
 		return sections;
	}

	/*
	 * Method used to populate the country list in view.
	 * Note that here you can call external systems to provide real data.
	 */
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("USA");
		countries.add("CHINA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
 		return countries;
	}

	/*
	 * Method used to populate the subjects list in view.
	 * Note that here you can call external systems to provide real data.
	 */
	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {

		List<String> subjects = new ArrayList<String>();
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("Life Science");
		subjects.add("Political Science");
		subjects.add("Computer Science");
		subjects.add("Mathmatics");
 		return subjects;
	}

}
