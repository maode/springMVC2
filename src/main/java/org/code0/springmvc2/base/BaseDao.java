package org.code0.springmvc2.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**  
 * @Title: BaseDao.java
 * @Package org.code0.springmvc2.base.dao
 * @Description: BaseDao.java
 * @author Code0   
 * @date 2017年12月11日 下午9:28:45 
 */
public abstract class BaseDao<PK extends Serializable,T> extends HibernateDaoSupport {

	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		this.persistentClass=(Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	protected Session getSession(){
		//return sessionFactory.getCurrentSession();
		return super.currentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T getByKey(PK key){
		return (T)getSession().get(persistentClass, key);
	}
	
	public void saveOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
	}
	
	@SuppressWarnings("unchecked")
	public PK save(T entity){
		return (PK) getSession().save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public T merge(T entity){
		return (T)getSession().merge(entity);
	}
	
	public void persist(T entity){
		getSession().persist(entity);
	}
	
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	
}
