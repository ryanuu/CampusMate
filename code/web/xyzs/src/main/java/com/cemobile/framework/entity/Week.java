package com.cemobile.framework.entity;

import java.util.Date;

public class Week {
	
	private Long weekNo;//第几周
	private Long tremId;//学期ID
	private String tremName;//学期名字
	private Date startDate;//周开始时间
	private Date endDate;//周结束时间
	
	
	public Long getWeekNo() {
		return weekNo;
	}
	public void setWeekNo(Long weekNo) {
		this.weekNo = weekNo;
	}
	public Long getTremId() {
		return tremId;
	}
	public void setTremId(Long tremId) {
		this.tremId = tremId;
	}
	public String getTremName() {
		return tremName;
	}
	public void setTremName(String tremName) {
		this.tremName = tremName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
