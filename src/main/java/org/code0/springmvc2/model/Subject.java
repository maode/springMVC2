package org.code0.springmvc2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Subject extends BaseModel implements Serializable {

	
	private static final long serialVersionUID = -5935548626860715866L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty
	@Size(min=3, max=30)
	private String name;

}
