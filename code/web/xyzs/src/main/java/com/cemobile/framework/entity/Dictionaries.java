package com.cemobile.framework.entity;

import java.util.Date;


@SuppressWarnings("serial")
public class Dictionaries extends BaseEntity{
	private int type;//类型:1.学周，2.节课
	private Long number;//第几周、节（1,2,3,4......） 
	private Long tremId;//学期Id
	private Date startDate;//周开始时间
	private Date endDate;//周结束时间
	private String startTime;//节开始时间
	private String endTime;//节结束时间
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getTremId() {
		return tremId;
	}
	public void setTremId(Long tremId) {
		this.tremId = tremId;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
