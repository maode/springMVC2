package org.code0.springmvc2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.apache.commons.lang3.StringUtils;
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
	private String subjectStr;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isFirstAttempt() {
		return firstAttempt;
	}

	public void setFirstAttempt(boolean firstAttempt) {
		this.firstAttempt = firstAttempt;
	}

	/** @return id */
	public Long getId() {
		return id;
	}
	
	/** @param id 要设置的 id */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** @return num */
	public String getNum() {
		return num;
	}
	
	/** @param num 要设置的 num */
	public void setNum(String num) {
		this.num = num;
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return super.toString();
	}

	/** @return subjectStr */
	public String getSubjectStr() {
		return subjectStr;
	}

	/** @param subjectStr 要设置的 subjectStr */
	public void setSubjectStr(String subjectStr) {
		this.subjectStr = subjectStr;
	}
	
	public void convertToSubjects(){
		if(StringUtils.isNotBlank(subjectStr)){
			String[] sa=subjectStr.split(",");
			for(String s:sa){
				Subject e=new Subject();
				e.setId(Long.valueOf(s));
				this.subjects.add(e);
			}
		}
	}

	public void convertToSubjectStr(){
		if(this.subjects!=null&&this.subjects.size()>0){
			StringBuilder sb=new StringBuilder();
			for(Subject sj:this.subjects){
				sb.append(sj.getId()).append(",");
			}
			this.subjectStr=sb.toString();
		}
	}
}
