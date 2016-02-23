package com.cemobile.framework.entity;

import java.util.Date;

public class PlaytimeTime extends LabTime {

	private static final long serialVersionUID = 1L;
	
	private String termName;//学期名
	private String collegeName;//学院名称
	
	private Date startDate;

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
}
