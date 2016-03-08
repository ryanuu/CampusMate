package com.cemobile.framework.entity;

public class Subject extends LabSubject {

	private static final long serialVersionUID = 1L;
	
	private String departmentName;//学系名称

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}
