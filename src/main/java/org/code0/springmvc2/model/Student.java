package org.code0.springmvc2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.code0.springmvc2.base.BaseModel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/**  
 * @Title: Person.java
 * @Package org.code0.springmvc2.model
 * @Description: Student.java
 * @author Code0   
 * @date 2017年9月11日 下午4:29:41 
 */
@Entity
@Getter
@Setter
public class Student extends BaseModel implements Serializable{
	
	
	private static final long serialVersionUID = 576810437616552545L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Column(nullable=false,unique=true)
	private String num;
	
	@Size(min=1, max=30)
	private String firstName;

	@Size(min=1, max=30)
	private String lastName;

	@NotEmpty
	private String sex;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past @NotNull
	private Date dob;

	@Email @NotEmpty
	private String email;

	@NotEmpty
	private String grade;

	@NotEmpty
	private String country;

	private boolean firstAttempt;

	@ManyToMany
	private List<Subject> subjects = new ArrayList<Subject>();
	
	@NotEmpty
	@Transient
	private Set<Long> subjectSet=new HashSet<Long>();


	
	/**
	 * 将subjectSet的值复制到subjects用来保存到数据库
	 */
	public void convertToSubjects(){
		if(this.subjectSet!=null&&this.subjectSet.size()>0){
			for(Long id:this.subjectSet){
				Subject e=new Subject();
				e.setId(id);
				this.subjects.add(e);
			}
		}
	}

	/**
	 * 将subjects的值复制到subjectSet用来回显到页面
	 */
	public void convertToSubjectSet(){
		if(this.subjects!=null&&this.subjects.size()>0){
			for(Subject sj:this.subjects){
				this.getSubjectSet().add(sj.getId());
			}
		}
	}
}
