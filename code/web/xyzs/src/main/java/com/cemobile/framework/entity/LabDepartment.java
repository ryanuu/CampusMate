package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
public class LabDepartment extends BaseEntity{
	
	
	private java.lang.Long departmentId;
	@NotEmpty @Length(max=30)
	private java.lang.String departmentName;
	@Length(max=10)
	private java.lang.String shortName;
	@Length(max=500)
	private java.lang.String departmentProfile;
	@NotNull 
	private java.lang.Long collegeId;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentName(java.lang.String value) {
		this.departmentName = value;
	}
	
	public java.lang.String getDepartmentName() {
		return this.departmentName;
	}
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	public void setDepartmentProfile(java.lang.String value) {
		this.departmentProfile = value;
	}
	
	public java.lang.String getDepartmentProfile() {
		return this.departmentProfile;
	}
	public void setCollegeId(java.lang.Long value) {
		this.collegeId = value;
	}
	
	public java.lang.Long getCollegeId() {
		return this.collegeId;
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
			.append("DepartmentId:",getDepartmentId()+" ")
			.append("DepartmentName:",getDepartmentName()+" ")
			.append("ShortName:",getShortName()+" ")
			.append("DepartmentProfile:",getDepartmentProfile()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getDepartmentId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabDepartment == false) return false;
		if(this == obj) return true;
		LabDepartment other = (LabDepartment)obj;
		return new EqualsBuilder().append(getDepartmentId(),other.getDepartmentId()).isEquals();
	}
}

