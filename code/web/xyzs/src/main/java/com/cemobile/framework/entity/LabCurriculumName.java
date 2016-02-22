package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabCurriculumName extends BaseEntity{
	
	
	private java.lang.Long curriculumId;
	@Length(max=100)
	private java.lang.String curriculumName;
	
	private java.lang.Long teacherId;
	@Length(max=20)
	private java.lang.String teacherName;
	
	private java.lang.Integer startWeek;
	
	private java.lang.Integer endWeek;
	@NotNull 
	private java.lang.Long subjectId;
	@NotNull 
	private java.lang.Long termId;
	
	private java.lang.Integer level;
	
	private java.lang.Integer courseType;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


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
	public void setTeacherId(java.lang.Long value) {
		this.teacherId = value;
	}
	
	public java.lang.Long getTeacherId() {
		return this.teacherId;
	}
	public void setTeacherName(java.lang.String value) {
		this.teacherName = value;
	}
	
	public java.lang.String getTeacherName() {
		return this.teacherName;
	}
	public void setStartWeek(java.lang.Integer value) {
		this.startWeek = value;
	}
	
	public java.lang.Integer getStartWeek() {
		return this.startWeek;
	}
	public void setEndWeek(java.lang.Integer value) {
		this.endWeek = value;
	}
	
	public java.lang.Integer getEndWeek() {
		return this.endWeek;
	}
	public void setSubjectId(java.lang.Long value) {
		this.subjectId = value;
	}
	
	public java.lang.Long getSubjectId() {
		return this.subjectId;
	}
	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
	}
	public void setLevel(java.lang.Integer value) {
		this.level = value;
	}
	
	public java.lang.Integer getLevel() {
		return this.level;
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
			.append("CurriculumId:",getCurriculumId()+" ")
			.append("CurriculumName:",getCurriculumName()+" ")
			.append("TeacherId:",getTeacherId()+" ")
			.append("TeacherName:",getTeacherName()+" ")
			.append("StartWeek:",getStartWeek()+" ")
			.append("EndWeek:",getEndWeek()+" ")
			.append("SubjectId:",getSubjectId()+" ")
			.append("TermId:",getTermId()+" ")
			.append("Level:",getLevel()+" ")
			.append("CourseType:",getCourseType()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getCurriculumId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabCurriculumName == false) return false;
		if(this == obj) return true;
		LabCurriculumName other = (LabCurriculumName)obj;
		return new EqualsBuilder().append(getCurriculumId(),other.getCurriculumId()).isEquals();
	}
}

