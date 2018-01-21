package org.code0.springmvc2.dao;

import java.util.List;

import org.code0.springmvc2.base.BaseDao;
import org.code0.springmvc2.model.Student;
import org.code0.springmvc2.model.Subject;
import org.springframework.stereotype.Repository;


/**  
 * @Title: StudentDao.java
 * @Package org.code0.springmvc2.dao
 * @Description: StudentDao.java
 * @author Code0   
 * @date 2017年12月11日 下午11:32:44 
 */
@Repository
public class StudentDao extends BaseDao<Long, Student> {

	@SuppressWarnings("unchecked")
	public List<Subject> findAllSubjects() {
		return this.getSession().createCriteria(Subject.class).list();
	}
	
	/**
	 * @param propertyName 实体类属性名
	 * @param propertyValue 实体类属性值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Student findUniqueBy(String propertyName,Object propertyValue){
		List<Student> sts=(List<Student>) this.getHibernateTemplate().find("from Student where ? = ?",propertyName, propertyValue);
		if(sts!=null&&sts.size()>0){
			return sts.get(0);
		}
		return null;
	}

}
