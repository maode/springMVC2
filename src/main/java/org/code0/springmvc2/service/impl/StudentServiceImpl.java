package org.code0.springmvc2.service.impl;

import java.util.List;

import org.code0.springmvc2.base.ExecuteResult;
import org.code0.springmvc2.dao.StudentDao;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.code0.springmvc2.service.IStudentService;
import org.code0.springmvc2.util.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;


/**  
 * @Title: StudentService.java
 * @Package org.code0.springmvc2.service
 * @Description: StudentService.java
 * @author Code0   
 * @date 2018年1月6日 上午10:58:04 
 */
@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentDao dao;
	@Autowired
	MessageSource messageSource;
	
	@Override
	public List<Subject> findAllSubjects(){
		return dao.findAllSubjects();
	}
	@Override
	public ExecuteResult add(Student entity) {
		ExecuteResult result= ExecuteResult.getExecuteResult();
		Student st=dao.findUniqueBy("num", entity.getNum());
		if(st==null){
			dao.save(entity);
		}else{
			String dfMsg=messageSource.getMessage("unique.student.num",new String[]{entity.getNum()}, LocaleContextHolder.getLocale());
			FieldError fe=new FieldError("student", "num", dfMsg);
			result.addFieldError("num", fe);
		}
		return result;
	}

	@Override
	public ExecuteResult deleteByID(Long id) {
		// TODO Auto-generated method stub
		Student s=this.dao.getByKey(id);
		this.dao.delete(s);
		return ExecuteResult.getExecuteResult();
	}

	@Override
	public ExecuteResult ineffectiveByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecuteResult ineffectiveByIds(Long... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findByID(Long id) {
		return this.dao.getByKey(id);
	}

	@Override
	public ExecuteResult update(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGrid searchDataGrid(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> searchList(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> searchAll() {
		return this.dao.searchAll();
	}

	@Override
	public Student findUniqueBy(String columnName, Object columnValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
