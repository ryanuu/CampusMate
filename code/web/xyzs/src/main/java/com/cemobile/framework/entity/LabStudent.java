package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabStudent extends BaseEntity{
	
	
	private java.lang.Long studentId;
	@NotNull 
	private java.lang.Long studentNumber;
	@Length(max=1)
	private java.lang.String studentName;
	@Length(max=50)
	private java.lang.String nickname;
	
	private java.lang.Boolean sex;
	
	private java.lang.Integer age;
	@Length(max=20)
	private java.lang.String nation;
	
	private java.lang.Long phone;
	@Length(max=18)
	private java.lang.String idCard;
	
	private java.lang.Long type;
	@Email @Length(max=1)
	private java.lang.String email;
	
	private java.lang.Long classId;
	@Length(max=1)
	private java.lang.String headImage;
	@Length(max=500)
	private java.lang.String note;
	@Length(max=1)
	private java.lang.String password;
	
	private java.util.Date creatDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;
	
	private java.lang.Long useriId;


	public void setStudentId(java.lang.Long value) {
		this.studentId = value;
	}
	
	public java.lang.Long getStudentId() {
		return this.studentId;
	}
	public void setStudentNumber(java.lang.Long value) {
		this.studentNumber = value;
	}
	
	public java.lang.Long getStudentNumber() {
		return this.studentNumber;
	}
	public void setStudentName(java.lang.String value) {
		this.studentName = value;
	}
	
	public java.lang.String getStudentName() {
		return this.studentName;
	}
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	public void setSex(java.lang.Boolean value) {
		this.sex = value;
	}
	
	public java.lang.Boolean getSex() {
		return this.sex;
	}
	public void setAge(java.lang.Integer value) {
		this.age = value;
	}
	
	public java.lang.Integer getAge() {
		return this.age;
	}
	public void setNation(java.lang.String value) {
		this.nation = value;
	}
	
	public java.lang.String getNation() {
		return this.nation;
	}
	public void setPhone(java.lang.Long value) {
		this.phone = value;
	}
	
	public java.lang.Long getPhone() {
		return this.phone;
	}
	public void setIdCard(java.lang.String value) {
		this.idCard = value;
	}
	
	public java.lang.String getIdCard() {
		return this.idCard;
	}
	public void setType(java.lang.Long value) {
		this.type = value;
	}
	
	public java.lang.Long getType() {
		return this.type;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setClassId(java.lang.Long value) {
		this.classId = value;
	}
	
	public java.lang.Long getClassId() {
		return this.classId;
	}
	public void setHeadImage(java.lang.String value) {
		this.headImage = value;
	}
	
	public java.lang.String getHeadImage() {
		return this.headImage;
	}
	public void setNote(java.lang.String value) {
		this.note = value;
	}
	
	public java.lang.String getNote() {
		return this.note;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
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
	public void setUseriId(java.lang.Long value) {
		this.useriId = value;
	}
	
	public java.lang.Long getUseriId() {
		return this.useriId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StudentId:",getStudentId()+" ")
			.append("StudentNumber:",getStudentNumber()+" ")
			.append("StudentName:",getStudentName()+" ")
			.append("Nickname:",getNickname()+" ")
			.append("Sex:",getSex()+" ")
			.append("Age:",getAge()+" ")
			.append("Nation:",getNation()+" ")
			.append("Phone:",getPhone()+" ")
			.append("IdCard:",getIdCard()+" ")
			.append("Type:",getType()+" ")
			.append("Email:",getEmail()+" ")
			.append("ClassId:",getClassId()+" ")
			.append("HeadImage:",getHeadImage()+" ")
			.append("Note:",getNote()+" ")
			.append("Password:",getPassword()+" ")
			.append("CreatDate:",getCreatDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.append("UseriId:",getUseriId()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getStudentId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabStudent == false) return false;
		if(this == obj) return true;
		LabStudent other = (LabStudent)obj;
		return new EqualsBuilder().append(getStudentId(),other.getStudentId()).isEquals();
	}
}

