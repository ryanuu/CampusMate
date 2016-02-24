package com.cemobile.framework.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Org{
	
	private java.lang.Long collegeId; //学院ID
	@NotEmpty @Length(max=30)
	private java.lang.String collegeName;
	@Length(max=10)
	private java.lang.String collergeShortName;
	@Length(max=500)
	private java.lang.String collegeProfile;
	
	private java.lang.Long departmentId;//学系ID
	@NotEmpty @Length(max=30)
	private java.lang.String departmentName;
	@Length(max=10)
	private java.lang.String departmentShortName;
	@Length(max=500)
	private java.lang.String departmentProfile;
	
	private java.lang.Long subjectId;//专业ID
	@NotEmpty @Length(max=30)
	private java.lang.String subjectName;
	@Length(max=10)
	private java.lang.String subjectShortName;
	@Length(max=500)
	private java.lang.String subjectProfile;
	
	private java.lang.Long classId;//班级ID
	@NotEmpty @Length(max=50)
	private java.lang.String className;
	private java.lang.Long headmaster;//班主任(teacherId)
	private java.lang.Long instructor;//辅导员(teacherId)
	@NotNull 
	private java.lang.Integer grade;//级（入学年份）
	private String headmasterName;//班主任(名字)
	private String instructorName;//辅导员(名字)
	
	private String level;//级别（学院、学系、专业、班级）
	
	public java.lang.Long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(java.lang.Long collegeId) {
		this.collegeId = collegeId;
	}
	public java.lang.String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(java.lang.String collegeName) {
		this.collegeName = collegeName;
	}
	public java.lang.String getCollergeShortName() {
		return collergeShortName;
	}
	public void setCollergeShortName(java.lang.String collergeShortName) {
		this.collergeShortName = collergeShortName;
	}
	public java.lang.String getCollegeProfile() {
		return collegeProfile;
	}
	public void setCollegeProfile(java.lang.String collegeProfile) {
		this.collegeProfile = collegeProfile;
	}
	public java.lang.Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(java.lang.Long departmentId) {
		this.departmentId = departmentId;
	}
	public java.lang.String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(java.lang.String departmentName) {
		this.departmentName = departmentName;
	}
	public java.lang.String getDepartmentShortName() {
		return departmentShortName;
	}
	public void setDepartmentShortName(java.lang.String departmentShortName) {
		this.departmentShortName = departmentShortName;
	}
	public java.lang.String getDepartmentProfile() {
		return departmentProfile;
	}
	public void setDepartmentProfile(java.lang.String departmentProfile) {
		this.departmentProfile = departmentProfile;
	}
	public java.lang.Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(java.lang.Long subjectId) {
		this.subjectId = subjectId;
	}
	public java.lang.String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(java.lang.String subjectName) {
		this.subjectName = subjectName;
	}
	public java.lang.String getSubjectShortName() {
		return subjectShortName;
	}
	public void setSubjectShortName(java.lang.String subjectShortName) {
		this.subjectShortName = subjectShortName;
	}
	public java.lang.String getSubjectProfile() {
		return subjectProfile;
	}
	public void setSubjectProfile(java.lang.String subjectProfile) {
		this.subjectProfile = subjectProfile;
	}
	public java.lang.Long getClassId() {
		return classId;
	}
	public void setClassId(java.lang.Long classId) {
		this.classId = classId;
	}
	public java.lang.Long getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(java.lang.Long headmaster) {
		this.headmaster = headmaster;
	}
	public java.lang.Long getInstructor() {
		return instructor;
	}
	public void setInstructor(java.lang.Long instructor) {
		this.instructor = instructor;
	}
	public java.lang.Integer getGrade() {
		return grade;
	}
	public void setGrade(java.lang.Integer grade) {
		this.grade = grade;
	}
	public String getHeadmasterName() {
		return headmasterName;
	}
	public void setHeadmasterName(String headmasterName) {
		this.headmasterName = headmasterName;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public java.lang.String getClassName() {
		return className;
	}
	public void setClassName(java.lang.String className) {
		this.className = className;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
