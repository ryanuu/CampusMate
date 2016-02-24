package com.cemobile.framework.entity;

public class Classes extends LabClass {

	private static final long serialVersionUID = 1L;
	
	private String subjectName;
	private String headmasterName;//班主任(名字)
	private String instructorName;//辅导员(名字)
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	
}
