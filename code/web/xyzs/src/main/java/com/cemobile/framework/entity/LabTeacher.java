package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabTeacher extends BaseEntity{
	
	
	private java.lang.Long teacherId;
	@NotNull 
	private java.lang.String teacherNumber;
	@Length(max=20)
	private java.lang.String teacherName;
	@Length(max=50)
	private java.lang.String nickname;
	
	private java.lang.Boolean sex;
	
	private java.lang.Long age;
	@Length(max=20)
	private java.lang.String nation;
	
	private java.lang.Long phone;
	
	private java.lang.Long idCard;
	@Email @Length(max=1)
	private java.lang.String email;
	
	private java.lang.Long professional;
	
	private java.lang.Long collegeId;
	
	private java.lang.Long departmentId;
	@Length(max=1)
	private java.lang.String headImage;
	
	private java.lang.Long role;
	@Length(max=500)
	private java.lang.String note;
	@Length(max=1)
	private java.lang.String password;
	
	private java.util.Date creatDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;
	
	private java.lang.Long userId;


	public void setTeacherId(java.lang.Long value) {
		this.teacherId = value;
	}
	
	public java.lang.Long getTeacherId() {
		return this.teacherId;
	}
	public void setTeacherNumber(java.lang.String value) {
		this.teacherNumber = value;
	}
	
	public java.lang.String getTeacherNumber() {
		return this.teacherNumber;
	}
	public void setTeacherName(java.lang.String value) {
		this.teacherName = value;
	}
	
	public java.lang.String getTeacherName() {
		return this.teacherName;
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
	public void setAge(java.lang.Long value) {
		this.age = value;
	}
	
	public java.lang.Long getAge() {
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
	public void setIdCard(java.lang.Long value) {
		this.idCard = value;
	}
	
	public java.lang.Long getIdCard() {
		return this.idCard;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setProfessional(java.lang.Long value) {
		this.professional = value;
	}
	
	public java.lang.Long getProfessional() {
		return this.professional;
	}
	public void setCollegeId(java.lang.Long value) {
		this.collegeId = value;
	}
	
	public java.lang.Long getCollegeId() {
		return this.collegeId;
	}
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setHeadImage(java.lang.String value) {
		this.headImage = value;
	}
	
	public java.lang.String getHeadImage() {
		return this.headImage;
	}
	public void setRole(java.lang.Long value) {
		this.role = value;
	}
	
	public java.lang.Long getRole() {
		return this.role;
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
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TeacherId:",getTeacherId()+" ")
			.append("TeacherNumber:",getTeacherNumber()+" ")
			.append("TeacherName:",getTeacherName()+" ")
			.append("Nickname:",getNickname()+" ")
			.append("Sex:",getSex()+" ")
			.append("Age:",getAge()+" ")
			.append("Nation:",getNation()+" ")
			.append("Phone:",getPhone()+" ")
			.append("IdCard:",getIdCard()+" ")
			.append("Email:",getEmail()+" ")
			.append("Professional:",getProfessional()+" ")
			.append("CollegeId:",getCollegeId()+" ")
			.append("DepartmentId:",getDepartmentId()+" ")
			.append("HeadImage:",getHeadImage()+" ")
			.append("Role:",getRole()+" ")
			.append("Note:",getNote()+" ")
			.append("Password:",getPassword()+" ")
			.append("CreatDate:",getCreatDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.append("UserId:",getUserId()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getTeacherId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabTeacher == false) return false;
		if(this == obj) return true;
		LabTeacher other = (LabTeacher)obj;
		return new EqualsBuilder().append(getTeacherId(),other.getTeacherId()).isEquals();
	}
}

