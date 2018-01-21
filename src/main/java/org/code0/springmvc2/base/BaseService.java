package org.code0.springmvc2.base;

import java.util.List;


/**  
 * @Title: BaseService.java
 * @Package org.code0.springmvc2.base
 * @Description: service公共接口
 * @author Code0   
 * @date 2018年1月6日 下午3:02:06 
 */
public interface BaseService<T> {
	/**
	 * 新增对象
	 * @param entity
	 */
	public ExecuteResult<T> add(T entity);
	/**
	 * 物理删除对象
	 * @param entity
	 */
	public ExecuteResult<T> delete(T entity);
	/**
	 * 逻辑删除对象
	 * @param entity
	 */
	public ExecuteResult<T> ineffective(T entity);
	/**
	 * 根据ids批量逻辑删除对象
	 * @param entity
	 */
	public ExecuteResult<T> ineffectiveByIds(T entity);
	/**
	 * 根据id获取对象
	 * @param entity
	 * @return
	 */
	public T get(T entity);
	/**
	 * 修改对象
	 * @param entity
	 */
	public ExecuteResult<T> update(T entity);
	/**
	 * 增加或修改对象
	 * @param entity
	 */
	public ExecuteResult<T> saveOrUpdate(T entity);
	/**
	 * 查询符合参数实体中所有非空属性条件以及分页条件的有效数据DataGrid
	 * @param entity
	 * @return
	 */
	public DataGrid searchDataGrid(T entity);
	/**
	 * 查询符合参数实体中所有非空属性条件的有效数据List
	 * @param entity
	 * @return
	 */
	public List<T> searchList(T entity);
	/**
	 * 查询表中所有的有效数据List
	 * @param entity
	 * @return
	 */
	public List<T> searchAll();
	
	/**
	 * 按属性查找唯一对象, 匹配方式为相等.<br/>
	 * @param columnName	表的字段名
	 * @param columnValue	表的字段值
	 * @return
	 */
	public T findUniqueBy(String columnName,Object columnValue);

}