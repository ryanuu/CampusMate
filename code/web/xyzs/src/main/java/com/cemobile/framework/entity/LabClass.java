package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
public class LabClass extends BaseEntity{
	
	
	private java.lang.Long classId;
	@NotEmpty @Length(max=50)
	private java.lang.String className;
	@NotNull 
	private java.lang.Long collegeId;
	@NotNull 
	private java.lang.Long departmentId;
	@NotNull 
	private java.lang.Long subjectId;
	
	private java.lang.Long headmaster;
	
	private java.lang.Long instructor;
	@NotNull 
	private java.lang.Integer grade;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setClassId(java.lang.Long value) {
		this.classId = value;
	}
	
	public java.lang.Long getClassId() {
		return this.classId;
	}
	public void setCollegeId(java.lang.Long value) {
		this.collegeId = value;
	}
	
	public java.lang.Long getCollegeId() {
		return this.collegeId;
	}
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setSubjectId(java.lang.Long value) {
		this.subjectId = value;
	}
	
	public java.lang.Long getSubjectId() {
		return this.subjectId;
	}
	public void setHeadmaster(java.lang.Long value) {
		this.headmaster = value;
	}
	
	public java.lang.Long getHeadmaster() {
		return this.headmaster;
	}
	public void setInstructor(java.lang.Long value) {
		this.instructor = value;
	}
	
	public java.lang.Long getInstructor() {
		return this.instructor;
	}
	public void setGrade(java.lang.Integer value) {
		this.grade = value;
	}
	
	public java.lang.Integer getGrade() {
		return this.grade;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setEditDate(java.util.Date value) {
		this.editDate = value;
	}
	
	public java.util.Date getEditDate() {
		return this.editDate;
	}
	public void setDel(java.lang.Integer value) {
		this.del = value;
	}
	
	public java.lang.Integer getDel() {
		return this.del;
	}
	public java.lang.String getClassName() {
		return className;
	}

	public void setClassName(java.lang.String className) {
		this.className = className;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ClassId:",getClassId()+" ")
			.append("CalssName:",getClassName()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("DepartmentId:",getDepartmentId()+" ")
			.append("SubjectId:",getSubjectId()+" ")
			.append("Headmaster:",getHeadmaster()+" ")
			.append("Instructor:",getInstructor()+" ")
			.append("Grade:",getGrade()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getClassId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabClass == false) return false;
		if(this == obj) return true;
		LabClass other = (LabClass)obj;
		return new EqualsBuilder().append(getClassId(),other.getClassId()).isEquals();
	}
}

