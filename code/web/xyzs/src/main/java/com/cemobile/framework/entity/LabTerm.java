package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabTerm extends BaseEntity{
	
	
	private java.lang.Long termId;
	@Length(max=30)
	private java.lang.String termName;
	
	private java.util.Date startDate;
	
	private java.util.Date endDate;
	
	private java.lang.Long collegeId;
	
	private java.util.Date createDate;
	
	private java.util.Date editeDate;
	
	private java.lang.Integer del;


	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
	}
	public void setTermName(java.lang.String value) {
		this.termName = value;
	}
	
	public java.lang.String getTermName() {
		return this.termName;
	}
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public java.util.Date getEndDate() {
		return this.endDate;
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
	public void setEditeDate(java.util.Date value) {
		this.editeDate = value;
	}
	
	public java.util.Date getEditeDate() {
		return this.editeDate;
	}
	public void setDel(java.lang.Integer value) {
		this.del = value;
	}
	
	public java.lang.Integer getDel() {
		return this.del;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TermId:",getTermId()+" ")
			.append("TermName:",getTermName()+" ")
			.append("StartDate:",getStartDate()+" ")
			.append("EndDate:",getEndDate()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditeDate:",getEditeDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getTermId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabTerm == false) return false;
		if(this == obj) return true;
		LabTerm other = (LabTerm)obj;
		return new EqualsBuilder().append(getTermId(),other.getTermId()).isEquals();
	}
}

