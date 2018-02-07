package org.code0.springmvc2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.code0.springmvc2.base.BaseController;
import org.code0.springmvc2.base.ExecuteResult;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.code0.springmvc2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
public class StudentController extends BaseController {

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
	public String addStudent(@Valid Student student, BindingResult verify, ModelMap model){

		if(verify.hasErrors()) {
		        return "addStudent";
		}
		student.convertSubject();
		ExecuteResult er=service.add(student);
		if(er.isSuccess()){
			return "redirect:students1";
		}else{
			if(er.hasFieldError()){
				for(Object fe:er.getFieldErrors().values()){
					verify.addError((FieldError)fe);
				}
			}
			if(er.hasErrorMessage()){
				model.addAttribute(ERROR_MSG, er.getErrorMessages());
			}
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
		//TODO 研究http的那几个标准方法
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
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
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
	@RequestMapping(value="/students1")
	public String listStudents(ModelMap model){
		List<Student> students=this.service.searchAll();
		model.addAttribute("students", students);
		return "students";
	}
	
	/**
	 * 用于在页面中填充“年级”列表数据的方法
	 * @return
	 */
	@ModelAttribute("grades")
	public List<String> initializeGrades() {

		List<String> grades = new ArrayList<String>();
		grades.add("1");
		grades.add("2");
		grades.add("3");
 		return grades;
	}

	/**
	 * 用于在页面中填充“国家”列表数据的方法。
	 * @return
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

	/**
	 * 用于在页面中填充“科目”列表数据的方法。
	 * @return
	 */
	@ModelAttribute("subjects")
	public List<Subject> initializeSubjects() {
		List<Subject> subjects=service.findAllSubjects();
 		return subjects;
	}

}
