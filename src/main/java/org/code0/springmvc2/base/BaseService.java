package org.code0.springmvc2.base;

import java.io.Serializable;
import java.util.List;

import org.code0.springmvc2.util.DataGrid;


/**  
 * @Title: BaseService.java
 * @Package org.code0.springmvc2.base
 * @Description: service公共接口<br/>
 * 读取相关操作方法：返回 实体类，列表类型，或其他自定义数据类型<br/>
 * 写改相关操作方法：返回ExecuteResult（用来方便存放操作执行是否成功，及有可能产生的错误信息）
 * @author Code0   
 * @date 2018年1月6日 下午3:02:06 
 */
public interface BaseService<ID extends Serializable, T> {
	/**
	 * 新增对象
	 * @param entity
	 */
	public ExecuteResult add(T entity);
	/**
	 * 物理删除对象
	 * @param entity
	 */
	public ExecuteResult deleteByID(ID id);
	/**
	 * 逻辑删除对象
	 * @param entity
	 */
	public ExecuteResult ineffectiveByID(ID id);
	/**
	 * 根据ids批量逻辑删除对象
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public ExecuteResult ineffectiveByIds(ID... ids);
	/**
	 * 修改对象
	 * @param entity
	 */
	public ExecuteResult update(T entity);
	/**
	 * 根据id获取对象
	 * @param entity
	 * @return
	 */
	public T findByID(ID id);
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