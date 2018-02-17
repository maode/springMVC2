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
	
	/**
	 * 根据(identifier主键对应的属性)获取一个持久化对象
	 * @param key
	 * @return
	 */
	public T getByKey(PK key){
		return this.getHibernateTemplate().get(persistentClass, key);
		//return (T)getSession().get(persistentClass, key);
	}
	
	/**
	 * 根据实例状态，选择保存或者更新
	 * <p/>
	 * saveOrUpdate(po)做下面的事: <br/>
	 *如果该po对象已经在本session中持久化了，在本session中执行saveOrUpdate不做任何事 
	 *如果savaOrUpdate(新po)与另一个与本session关联的po对象拥有相同的持久化标识(identifier)，则抛出org.hibernate.NonUniqueObjectException。 
	 *saveOrUpdate如果对象没有持久化标识(identifier)属性，对其调用save() ，否则update() 这个对象。
	 * @param entity
	 */
	public void saveOrUpdate(T entity){
		this.getHibernateTemplate().saveOrUpdate(entity);
		//getSession().saveOrUpdate(entity);
	}
	
	/**
	 * 把一个新的对象保存
	 * <P/>
	 * 把一个瞬态的实例持久化标识符，及时的产生它要返回标识符(identifier主键对应的属性)，所以它会立即执行Sql insert
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PK save(T entity){
		return (PK)this.getHibernateTemplate().save(entity);
		//return (PK) getSession().save(entity);
	}
	
	/**
	 * 把一个脱管状态的对象或自由态对象更新到数据库
	 * @param entity
	 */
	public void update(T entity){
		this.getHibernateTemplate().update(entity);
	}
	/**
	 * 将传入的detached(分离的)状态的对象的属性复制到持久化对象中，并返回该持久化对象。传入对象依然保持detached状态。
	 * <p/>
	 * merge:将传入的detached(分离的)状态的对象的属性复制到持久化对象中，并返回该持久化对象，
	 * 如果该session中没有关联的持久化对象，加载一个，
	 * 如果传入对象未保存，保存一个副本并作为持久对象返回，传入对象依然保持detached状态。
	 * @param entity
	 * @return
	 */
	public T merge(T entity){
		return this.getHibernateTemplate().merge(entity);
		//return (T)getSession().merge(entity);
	}
	/**
	 * 把一个新的对象保存
	 * <P/>
	 * 把一个瞬态的实例持久化，但是并"不保证"标识符(identifier主键对应的属性)被立刻填入到持久化实例中，标识符的填入可能被推迟到flush的时候。
	 * 不一定会立即执行Sql insert
	 * @param entity
	 * @return
	 */
	public void persist(T entity){
		this.getHibernateTemplate().persist(entity);
		//getSession().persist(entity);
	}
	
	/**
	 * 删除该对象对应的数据库记录。
	 * <p/>
	 * 该对象变为瞬时对象，不再与数据库的记录关联。
	 * @param entity
	 */
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
