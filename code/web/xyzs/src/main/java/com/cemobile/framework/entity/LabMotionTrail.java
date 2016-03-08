package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@SuppressWarnings("serial")
public class LabMotionTrail extends BaseEntity{
	
	
	private java.lang.Long trailD;
	
	private java.lang.Long studentId;
	
	private java.lang.Long positionId;
	
	private java.lang.Long residenceTim;
	
	private java.util.Date startTime;
	
	private java.util.Date leaveTime;
	
	private java.util.Date createDate;


	public void setTrailD(java.lang.Long value) {
		this.trailD = value;
	}
	
	public java.lang.Long getTrailD() {
		return this.trailD;
	}
	public void setStudentId(java.lang.Long value) {
		this.studentId = value;
	}
	
	public java.lang.Long getStudentId() {
		return this.studentId;
	}
	public void setPositionId(java.lang.Long value) {
		this.positionId = value;
	}
	
	public java.lang.Long getPositionId() {
		return this.positionId;
	}
	public void setResidenceTim(java.lang.Long value) {
		this.residenceTim = value;
	}
	
	public java.lang.Long getResidenceTim() {
		return this.residenceTim;
	}
	public void setStartTime(java.util.Date value) {
		this.startTime = value;
	}
	
	public java.util.Date getStartTime() {
		return this.startTime;
	}
	public void setLeaveTime(java.util.Date value) {
		this.leaveTime = value;
	}
	
	public java.util.Date getLeaveTime() {
		return this.leaveTime;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TrailD:",getTrailD()+" ")
			.append("StudentId:",getStudentId()+" ")
			.append("PositionId:",getPositionId()+" ")
			.append("ResidenceTim:",getResidenceTim()+" ")
			.append("StartTime:",getStartTime()+" ")
			.append("LeaveTime:",getLeaveTime()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getTrailD()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabMotionTrail == false) return false;
		if(this == obj) return true;
		LabMotionTrail other = (LabMotionTrail)obj;
		return new EqualsBuilder().append(getTrailD(),other.getTrailD()).isEquals();
	}
}

