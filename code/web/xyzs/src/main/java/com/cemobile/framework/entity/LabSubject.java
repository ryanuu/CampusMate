package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
public class LabSubject extends BaseEntity{
	
	
	private java.lang.Long subjectId;
	@NotEmpty @Length(max=30)
	private java.lang.String subjectName;
	@Length(max=10)
	private java.lang.String shortName;
	@Length(max=500)
	private java.lang.String subjectProfile;
	@NotNull 
	private java.lang.Long collegeId;
	@NotNull 
	private java.lang.Long departmentId;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setSubjectId(java.lang.Long value) {
		this.subjectId = value;
	}
	
	public java.lang.Long getSubjectId() {
		return this.subjectId;
	}
	public void setSubjectName(java.lang.String value) {
		this.subjectName = value;
	}
	
	public java.lang.String getSubjectName() {
		return this.subjectName;
	}
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	public void setSubjectProfile(java.lang.String value) {
		this.subjectProfile = value;
	}
	
	public java.lang.String getSubjectProfile() {
		return this.subjectProfile;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SubjectId:",getSubjectId()+" ")
			.append("SubjectName:",getSubjectName()+" ")
			.append("ShortName:",getShortName()+" ")
			.append("SubjectProfile:",getSubjectProfile()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("DepartmentId:",getDepartmentId()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getSubjectId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabSubject == false) return false;
		if(this == obj) return true;
		LabSubject other = (LabSubject)obj;
		return new EqualsBuilder().append(getSubjectId(),other.getSubjectId()).isEquals();
	}
}

