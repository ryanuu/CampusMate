package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabExam extends BaseEntity{
	
	
	private java.lang.Long examId;
	
	private java.lang.Long curriculumId;
	@Length(max=100)
	private java.lang.String curriculumName;
	
	private String startTime;
	
	private String endTime;
	
	private java.lang.Integer weeke;
	@NotNull 
	private java.lang.Long subjectId;
	
	private java.lang.Integer level;
	
	private java.lang.Long termId;
	
	private java.lang.Long teacherId;
	@Length(max=20)
	private java.lang.String teacherName;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setExamId(java.lang.Long value) {
		this.examId = value;
	}
	
	public java.lang.Long getExamId() {
		return this.examId;
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
	public void setStartTime(String value) {
		this.startTime = value;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	public void setEndTime(String value) {
		this.endTime = value;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	public void setWeeke(java.lang.Integer value) {
		this.weeke = value;
	}
	
	public java.lang.Integer getWeeke() {
		return this.weeke;
	}
	public void setSubjectId(java.lang.Long value) {
		this.subjectId = value;
	}
	
	public java.lang.Long getSubjectId() {
		return this.subjectId;
	}
	public void setLevel(java.lang.Integer value) {
		this.level = value;
	}
	
	public java.lang.Integer getLevel() {
		return this.level;
	}
	public void setTermId(java.lang.Long value) {
		this.termId = value;
	}
	
	public java.lang.Long getTermId() {
		return this.termId;
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
			.append("ExamId:",getExamId()+" ")
			.append("CurriculumId:",getCurriculumId()+" ")
			.append("CurriculumName:",getCurriculumName()+" ")
			.append("StartTime:",getStartTime()+" ")
			.append("EndTime:",getEndTime()+" ")
			.append("Weeke:",getWeeke()+" ")
			.append("SubjectId:",getSubjectId()+" ")
			.append("Level:",getLevel()+" ")
			.append("TermId:",getTermId()+" ")
			.append("TeacherId:",getTeacherId()+" ")
			.append("TeacherName:",getTeacherName()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getExamId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabExam == false) return false;
		if(this == obj) return true;
		LabExam other = (LabExam)obj;
		return new EqualsBuilder().append(getExamId(),other.getExamId()).isEquals();
	}
}

