package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabNotice extends BaseEntity{
	
	
	private java.lang.Long noticeId;
	@Length(max=1000)
	private java.lang.String content;
	@Length(max=100)
	private java.lang.String title;
	
	private java.lang.Integer displayDate;
	
	private java.lang.Long teacherId;
	@Length(max=1)
	private java.lang.String source;
	@Length(max=1)
	private java.lang.String classId;
	
	private java.lang.Long departmentId;
	
	private java.lang.Long collegeId;
	
	private java.lang.Integer top;
	
	private java.util.Date creatDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setNoticeId(java.lang.Long value) {
		this.noticeId = value;
	}
	
	public java.lang.Long getNoticeId() {
		return this.noticeId;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setDisplayDate(java.lang.Integer value) {
		this.displayDate = value;
	}
	
	public java.lang.Integer getDisplayDate() {
		return this.displayDate;
	}
	public void setTeacherId(java.lang.Long value) {
		this.teacherId = value;
	}
	
	public java.lang.Long getTeacherId() {
		return this.teacherId;
	}
	public void setSource(java.lang.String value) {
		this.source = value;
	}
	
	public java.lang.String getSource() {
		return this.source;
	}
	public void setClassId(java.lang.String value) {
		this.classId = value;
	}
	
	public java.lang.String getClassId() {
		return this.classId;
	}
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setCollegeId(java.lang.Long value) {
		this.collegeId = value;
	}
	
	public java.lang.Long getCollegeId() {
		return this.collegeId;
	}
	public void setTop(java.lang.Integer value) {
		this.top = value;
	}
	
	public java.lang.Integer getTop() {
		return this.top;
	}
	public void setCreatDate(java.util.Date value) {
		this.creatDate = value;
	}
	
	public java.util.Date getCreatDate() {
		return this.creatDate;
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
			.append("NoticeId:",getNoticeId()+" ")
			.append("Content:",getContent()+" ")
			.append("Title:",getTitle()+" ")
			.append("DisplayDate:",getDisplayDate()+" ")
			.append("TeacherId:",getTeacherId()+" ")
			.append("Source:",getSource()+" ")
			.append("ClassId:",getClassId()+" ")
			.append("DepartmentId:",getDepartmentId()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("Top:",getTop()+" ")
			.append("CreatDate:",getCreatDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getNoticeId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabNotice == false) return false;
		if(this == obj) return true;
		LabNotice other = (LabNotice)obj;
		return new EqualsBuilder().append(getNoticeId(),other.getNoticeId()).isEquals();
	}
}

