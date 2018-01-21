package org.code0.springmvc2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.code0.springmvc2.base.BaseModel;
import org.hibernate.validator.constraints.NotEmpty;


/**  
 * @Title: Subject.java
 * @Package org.code0.springmvc2.model
 * @Description: Subject.java
 * @author Code0   
 * @date 2018年1月18日 下午7:30:56 
 */
@Entity
public class Subject extends BaseModel implements Serializable {

	
	private static final long serialVersionUID = -5935548626860715866L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty
	@Size(min=3, max=30)
	private String name;
	/** @return id */
	public Long getId() {
		return id;
	}
	/** @param id 要设置的 id */
	public void setId(Long id) {
		this.id = id;
	}
	/** @return name */
	public String getName() {
		return name;
	}
	/** @param name 要设置的 name */
	public void setName(String name) {
		this.name = name;
	}
}
