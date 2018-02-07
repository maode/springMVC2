package org.code0.springmvc2.util;


import java.util.Date;
import java.util.List;


/**  
 * @Title: DataGrid.java
 * @Package org.code0.springmvc2.base
 * @Description: 前端列表页面的数据模型【根据项目实情编写此类，此处匹配easyUI】
 * @author Code0   
 * @date 2018年1月16日 下午4:26:10 
 */
public class DataGrid implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 7032624410802802344L;
	private Long total;// 总记录数
	private List rows;// 每行记录
	private List footer;
	private Date now = new Date();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

}
