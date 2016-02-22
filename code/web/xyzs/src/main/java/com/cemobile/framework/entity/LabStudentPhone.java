package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabStudentPhone extends BaseEntity{
	
	
	private java.lang.Long macId;
	@NotNull 
	private java.lang.Long studentId;
	@Length(max=1)
	private java.lang.String mac;
	
	private java.util.Date creatDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setMacId(java.lang.Long value) {
		this.macId = value;
	}
	
	public java.lang.Long getMacId() {
		return this.macId;
	}
	public void setStudentId(java.lang.Long value) {
		this.studentId = value;
	}
	
	public java.lang.Long getStudentId() {
		return this.studentId;
	}
	public void setMac(java.lang.String value) {
		this.mac = value;
	}
	
	public java.lang.String getMac() {
		return this.mac;
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
			.append("MacId:",getMacId()+" ")
			.append("StudentId:",getStudentId()+" ")
			.append("Mac:",getMac()+" ")
			.append("CreatDate:",getCreatDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getMacId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabStudentPhone == false) return false;
		if(this == obj) return true;
		LabStudentPhone other = (LabStudentPhone)obj;
		return new EqualsBuilder().append(getMacId(),other.getMacId()).isEquals();
	}
}

