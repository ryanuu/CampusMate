package com.cemobile.framework.entity;


import java.sql.Time;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@SuppressWarnings("serial")
public class LabTime extends BaseEntity{
	
	
	private java.lang.Long id;
	
	private java.lang.Integer section;
	
	private java.lang.Long termId;
	
	private Time startDate;
	
	private Time endDate;
	
	private java.lang.Long collegeId;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setSection(java.lang.Integer value) {
		this.section = value;
	}
	
	public java.lang.Integer getSection() {
		return this.section;
	}
	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
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
			.append("Id:",getId()+" ")
			.append("Section:",getSection()+" ")
			.append("TermId:",getTermId()+" ")
			.append("StartDate:",getStartDate()+" ")
			.append("EndDate:",getEndDate()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabTime == false) return false;
		if(this == obj) return true;
		LabTime other = (LabTime)obj;
		return new EqualsBuilder().append(getId(),other.getId()).isEquals();
	}

	public Time getStartDate() {
		return startDate;
	}

	public void setStartDate(Time startDate) {
		this.startDate = startDate;
	}

	public Time getEndDate() {
		return endDate;
	}

	public void setEndDate(Time endDate) {
		this.endDate = endDate;
	}
}

