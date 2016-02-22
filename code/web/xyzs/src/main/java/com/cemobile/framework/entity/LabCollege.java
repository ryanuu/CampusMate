package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
public class LabCollege extends BaseEntity{
	
	
	private java.lang.Long collegeId;
	@NotEmpty @Length(max=30)
	private java.lang.String collegeName;
	@Length(max=10)
	private java.lang.String shortName;
	@Length(max=500)
	private java.lang.String collegeProfile;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setCollegeId(java.lang.Long value) {
		this.collegeId = value;
	}
	
	public java.lang.Long getCollegeId() {
		return this.collegeId;
	}
	public void setCollegeName(java.lang.String value) {
		this.collegeName = value;
	}
	
	public java.lang.String getCollegeName() {
		return this.collegeName;
	}
	public void setShortName(java.lang.String value) {
		this.shortName = value;
	}
	
	public java.lang.String getShortName() {
		return this.shortName;
	}
	public void setCollegeProfile(java.lang.String value) {
		this.collegeProfile = value;
	}
	
	public java.lang.String getCollegeProfile() {
		return this.collegeProfile;
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
			.append("CollegeId:",getCollegeId()+" ")
			.append("CollegeName:",getCollegeName()+" ")
			.append("ShortName:",getShortName()+" ")
			.append("CollegeProfile:",getCollegeProfile()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getCollegeId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabCollege == false) return false;
		if(this == obj) return true;
		LabCollege other = (LabCollege)obj;
		return new EqualsBuilder().append(getCollegeId(),other.getCollegeId()).isEquals();
	}
}

