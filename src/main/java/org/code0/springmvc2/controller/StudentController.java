package org.code0.springmvc2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.code0.springmvc2.base.ExecuteResult;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.code0.springmvc2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**  
 * @Title: StudentController.java
 * @Package org.code0.springmvc2.controller
 * @Description: StudentController<br/>
 * hibernate-validator实现表单验证
 * @author Code0   
 * @date 2017年9月13日 下午6:02:09 
 */
@Controller
@RequestMapping("/student")//该类中所有方法处理基于`/student`父路径下的请求
public class StudentController {

	@Autowired
	IStudentService<Student> service;

	/**
	 * 跳转到新增页面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String newStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addStudent";
	}

	/**
	 * 新增学生
	 * @param student
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@Valid Student student, BindingResult varify, ModelMap model){

		if(varify.hasErrors()) {
		        return "addStudent";
		}
		student.convertSubject();
		ExecuteResult<Student> er=service.add(student);
		if(er.isSuccess()){
			return "students";
		}else{
			model.addAttribute("serviceError", er.getErrorMessages());
			return "addStudent";
		}
	}

	/**
	 * 跳转到修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String editStudent(@PathVariable Long id,ModelMap model){
		
		return "editStudent";
	}
	
	/**
	 * 修改学生信息
	 * @param student
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public String updateStudent(@Valid Student student,BindingResult result,ModelMap model){
		
		return "success";
	}
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public String delStudent(@PathVariable Long id){
		
		return "redirect:/students";
	}
	
	/**
	 * 根据num删除学生
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/num/{num}",method=RequestMethod.DELETE)
	public String delStudentByNum(@PathVariable String num){
		
		return "redirect:/students";
	}
	/**
	 * 跳转到学生列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String listStudents(ModelMap model){
		
		return "students";
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
	public List<Subject> initializeSubjects() {
		List<Subject> subjects=service.findAllSubjects();
 		return subjects;
	}

}
