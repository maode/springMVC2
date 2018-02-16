package org.code0.springmvc2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.code0.springmvc2.base.BaseController;
import org.code0.springmvc2.base.ExecuteResult;
import org.code0.springmvc2.base.Result;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.code0.springmvc2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**  
 * @Title: StudentController.java
 * @Package org.code0.springmvc2.controller
 * @Description: StudentController<br/>
 * hibernate-validator实现表单验证
 * @author Code0   
 * @date 2017年9月13日 下午6:02:09 
 */
@Controller
@RequestMapping("/student")//设置父路径，如：模块名。（此处该类中所有方法都响应基于`/student`父路径下的请求）
public class StudentController extends BaseController {

	@Autowired
	IStudentService service;

	/**
	 * 学生列表页面
	 * @param model
	 * @return
	 */
	@GetMapping({"","/list"})
	public String list(ModelMap model){
		List<Student> students=this.service.searchAll();
		model.addAttribute("students", students);
		return "student/list";
	}
	
	/**
	 * 跳转到新增页面【约定优于配置，默认匹配文件/WEB-INF/views/student/add.jsp】
	 * @param model
	 * @return
	 */
	@GetMapping("/add")
	public void add(ModelMap model) {
		model.addAttribute("student", new Student());
	}

	/**
	 * 新增学生
	 * @param student
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping()
	public String addStudent(@Valid Student student, BindingResult verify, ModelMap model){

		if(verify.hasErrors()) {
			return "student/add";
		}
		student.convertToSubjects();
		ExecuteResult er=service.add(student);
		if(er.isSuccess()){
			return "redirect:/student/list";
		}else{
			if(er.hasFieldError()){
				for(Object fe:er.getFieldErrors().values()){
					verify.addError((FieldError)fe);
				}
			}
			if(er.hasErrorMessage()){
				model.addAttribute(ERROR_MSG, er.getErrorMessages());
			}
			return "student/add";
		}
	}

	/**
	 * 查看学生详细信息
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public String viewStudent(@PathVariable Long id,ModelMap model){
		Student student=this.service.findByID(id);
		model.addAttribute("student", student);
		return "student/view";
	}
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	@DeleteMapping
	@ResponseBody
	public Result delStudent(@RequestParam Long id){
		this.service.deleteByID(id);
		return Result.ok();
		//return JSON.toJSONString(Result.ok());
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id,ModelMap model){

		Student s=this.service.findByID(id);
		//s.convertToSubjectStr();
		model.addAttribute("student", s);
		return "student/edit";
	}
	
	/**
	 * 修改学生信息
	 * @param student
	 * @param result
	 * @param model
	 * @return
	 */
	@PutMapping
	public String updateStudent(@Valid Student student,BindingResult result,ModelMap model){
		this.service.update(student);
		return "redirect:/student";
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
