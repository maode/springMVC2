package org.code0.springmvc2.service;

import java.util.List;

import org.code0.springmvc2.base.BaseService;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;



/**  
 * @Title: IStudentService.java
 * @Package org.code0.springmvc2.service
 * @Description: IStudentService.java
 * @author Code0   
 * @date 2018年1月18日 下午9:49:20 
 */
public interface IStudentService extends BaseService<Long, Student> {

	List<Subject> findAllSubjects();
}
