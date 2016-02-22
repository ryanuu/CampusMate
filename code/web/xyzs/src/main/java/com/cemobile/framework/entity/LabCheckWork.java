package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabCheckWork extends BaseEntity{
	
	
	private java.lang.Long checkId;
	
	private java.lang.Long classId;
	
	private java.lang.Long curriculumId;
	@Length(max=100)
	private java.lang.String curriculumName;
	@Length(max=1)
	private java.lang.String status;
	
	private java.lang.Long studentId;
	
	private java.lang.Integer weekNo;
	
	private java.lang.Integer weekday;
	
	private java.lang.Integer section;
	
	private java.util.Date startDate;
	
	private java.util.Date endDate;
	
	private java.lang.Long termId;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setCheckId(java.lang.Long value) {
		this.checkId = value;
	}
	
	public java.lang.Long getCheckId() {
		return this.checkId;
	}
	public void setClassId(java.lang.Long value) {
		this.classId = value;
	}
	
	public java.lang.Long getClassId() {
		return this.classId;
	}
	public void setCurriculumId(java.lang.Long value) {
		this.curriculumId = value;
	}
	
	public java.lang.Long getCurriculumId() {
		return this.curriculumId;
	}
	public void setCurriculumName(java.lang.String value) {
		this.curriculumName = value;
	}
	
	public java.lang.String getCurriculumName() {
		return this.curriculumName;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setStudentId(java.lang.Long value) {
		this.studentId = value;
	}
	
	public java.lang.Long getStudentId() {
		return this.studentId;
	}
	public void setWeekNo(java.lang.Integer value) {
		this.weekNo = value;
	}
	
	public java.lang.Integer getWeekNo() {
		return this.weekNo;
	}
	public void setWeekday(java.lang.Integer value) {
		this.weekday = value;
	}
	
	public java.lang.Integer getWeekday() {
		return this.weekday;
	}
	public void setSection(java.lang.Integer value) {
		this.section = value;
	}
	
	public java.lang.Integer getSection() {
		return this.section;
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
	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
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
			.append("CheckId:",getCheckId()+" ")
			.append("ClassId:",getClassId()+" ")
			.append("CurriculumId:",getCurriculumId()+" ")
			.append("CurriculumName:",getCurriculumName()+" ")
			.append("Status:",getStatus()+" ")
			.append("StudentId:",getStudentId()+" ")
			.append("WeekNo:",getWeekNo()+" ")
			.append("Weekday:",getWeekday()+" ")
			.append("Section:",getSection()+" ")
			.append("StartDate:",getStartDate()+" ")
			.append("EndDate:",getEndDate()+" ")
			.append("TermId:",getTermId()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getCheckId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabCheckWork == false) return false;
		if(this == obj) return true;
		LabCheckWork other = (LabCheckWork)obj;
		return new EqualsBuilder().append(getCheckId(),other.getCheckId()).isEquals();
	}
}

