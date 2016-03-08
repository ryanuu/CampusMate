package com.cemobile.framework.entity;

public class Department extends LabDepartment {

	private static final long serialVersionUID = 1L;
	
	private String collegeName;//学院名称

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
