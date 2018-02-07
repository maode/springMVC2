package org.code0.springmvc2.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

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
	
	public T getByKey(PK key){
		return this.getHibernateTemplate().get(persistentClass, key);
		//return (T)getSession().get(persistentClass, key);
	}
	
	public void saveOrUpdate(T entity){
		this.getHibernateTemplate().saveOrUpdate(entity);
		//getSession().saveOrUpdate(entity);
	}
	
	@SuppressWarnings("unchecked")
	public PK save(T entity){
		return (PK)this.getHibernateTemplate().save(entity);
		//return (PK) getSession().save(entity);
	}
	
	public T merge(T entity){
		return this.getHibernateTemplate().merge(entity);
		//return (T)getSession().merge(entity);
	}
	
	public void persist(T entity){
		this.getHibernateTemplate().persist(entity);
		//getSession().persist(entity);
	}
	
	public void delete(T entity){
		this.getHibernateTemplate().delete(entity);
		//getSession().delete(entity);
	}
	/**
	 * 查询符合参数实体中所有非空属性条件的有效数据(忽略主键和关联属性)
	 * @param object
	 * @return
	 */
	public List<T> searchList(T entity){
		return this.getHibernateTemplate().findByExample(entity);
	}
	
	/**
	 * 查询表中所有的有效数据List
	 * @param entity
	 * @return
	 */
	public List<T> searchAll(){
		return this.getHibernateTemplate().loadAll(persistentClass);
	}
	
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	
}
