package com.cemobile.framework.entity;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月25日上午9:41:18
 * 类说明：app登录实体类
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public class AppUser {
	
	private Long userId;
	private Long collegeId;
	private Long departmentId;
	private Long majorId;
	private Long classId;
	private Long role;
	private String ticket;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long getMajorId() {
		return majorId;
	}
	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	
}
