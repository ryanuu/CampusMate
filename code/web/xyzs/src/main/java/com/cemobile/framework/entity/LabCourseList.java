package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@SuppressWarnings("serial")
public class LabCourseList extends BaseEntity{
	
	
	private java.lang.Long courseListId;
	
	private java.lang.Long curriculumId;
	@NotNull 
	private java.lang.Integer weekday;
	@NotNull 
	private java.lang.Integer section;
	@NotNull 
	private java.lang.Long classId;
	@NotNull 
	private java.lang.Long termId;
	
	private java.lang.Long positionId;
	@NotNull 
	private java.lang.Integer courseType;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setCourseListId(java.lang.Long value) {
		this.courseListId = value;
	}
	
	public java.lang.Long getCourseListId() {
		return this.courseListId;
	}
	public void setCurriculumId(java.lang.Long value) {
		this.curriculumId = value;
	}
	
	public java.lang.Long getCurriculumId() {
		return this.curriculumId;
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
	public void setClassId(java.lang.Long value) {
		this.classId = value;
	}
	
	public java.lang.Long getClassId() {
		return this.classId;
	}
	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
	}
	public void setPositionId(java.lang.Long value) {
		this.positionId = value;
	}
	
	public java.lang.Long getPositionId() {
		return this.positionId;
	}
	public void setCourseType(java.lang.Integer value) {
		this.courseType = value;
	}
	
	public java.lang.Integer getCourseType() {
		return this.courseType;
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
			.append("CourseListId:",getCourseListId()+" ")
			.append("CurriculumId:",getCurriculumId()+" ")
			.append("Weekday:",getWeekday()+" ")
			.append("Section:",getSection()+" ")
			.append("ClassId:",getClassId()+" ")
			.append("TermId:",getTermId()+" ")
			.append("PositionId:",getPositionId()+" ")
			.append("CourseType:",getCourseType()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getCourseListId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabCourseList == false) return false;
		if(this == obj) return true;
		LabCourseList other = (LabCourseList)obj;
		return new EqualsBuilder().append(getCourseListId(),other.getCourseListId()).isEquals();
	}
}

