package org.code0.springmvc2.service.impl;

import java.util.List;

import org.code0.springmvc2.base.DataGrid;
import org.code0.springmvc2.base.ExecuteResult;
import org.code0.springmvc2.dao.StudentDao;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.code0.springmvc2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**  
 * @Title: StudentService.java
 * @Package org.code0.springmvc2.service
 * @Description: StudentService.java
 * @author Code0   
 * @date 2018年1月6日 上午10:58:04 
 */
@Service
@Transactional
public class StudentService implements IStudentService<Student> {
	@Autowired
	private StudentDao dao;
	
	@Override
	public List<Subject> findAllSubjects(){
		return dao.findAllSubjects();
	}
	@Override
	public ExecuteResult<Student> add(Student entity) {
		// TODO Auto-generated method stub
		Student st=dao.findUniqueBy("num", entity.getNum());
		if(st==null){
			//写个工厂类 生成result 设置result 最终返回至controller
			dao.save(entity);
			//Long.valueOf(entity.getCountry());
		}
		return null;
	}

	@Override
	public ExecuteResult<Student> delete(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecuteResult<Student> ineffective(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecuteResult<Student> ineffectiveByIds(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student get(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecuteResult<Student> update(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecuteResult<Student> saveOrUpdate(Student entity) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findUniqueBy(String columnName, Object columnValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
