package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabBluetoothDev extends BaseEntity{
	
	
	private java.lang.Long devId;
	
	private java.lang.Long devNumber;
	@Length(max=200)
	private java.lang.String manufactor;
	
	private java.lang.Integer status;
	
	private java.lang.Long positionId;
	@Length(max=35)
	private java.lang.String uuid;
	
	private java.lang.Long major;
	
	private java.lang.Long minor;
	@Length(max=50)
	private java.lang.String devType;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;
	@Length(max=1)
	private java.lang.String devSn;
	@Length(max=20)
	private java.lang.String devMac;
	
	private java.lang.Integer measuredPower;
	@Length(max=30)
	private java.lang.String name;


	public void setDevId(java.lang.Long value) {
		this.devId = value;
	}
	
	public java.lang.Long getDevId() {
		return this.devId;
	}
	public void setDevNumber(java.lang.Long value) {
		this.devNumber = value;
	}
	
	public java.lang.Long getDevNumber() {
		return this.devNumber;
	}
	public void setManufactor(java.lang.String value) {
		this.manufactor = value;
	}
	
	public java.lang.String getManufactor() {
		return this.manufactor;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setPositionId(java.lang.Long value) {
		this.positionId = value;
	}
	
	public java.lang.Long getPositionId() {
		return this.positionId;
	}
	public void setUuid(java.lang.String value) {
		this.uuid = value;
	}
	
	public java.lang.String getUuid() {
		return this.uuid;
	}
	public void setMajor(java.lang.Long value) {
		this.major = value;
	}
	
	public java.lang.Long getMajor() {
		return this.major;
	}
	public void setMinor(java.lang.Long value) {
		this.minor = value;
	}
	
	public java.lang.Long getMinor() {
		return this.minor;
	}
	public void setDevType(java.lang.String value) {
		this.devType = value;
	}
	
	public java.lang.String getDevType() {
		return this.devType;
	}
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
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
	public void setDevSn(java.lang.String value) {
		this.devSn = value;
	}
	
	public java.lang.String getDevSn() {
		return this.devSn;
	}
	public void setDevMac(java.lang.String value) {
		this.devMac = value;
	}
	
	public java.lang.String getDevMac() {
		return this.devMac;
	}
	public void setMeasuredPower(java.lang.Integer value) {
		this.measuredPower = value;
	}
	
	public java.lang.Integer getMeasuredPower() {
		return this.measuredPower;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DevId:",getDevId()+" ")
			.append("DevNumber:",getDevNumber()+" ")
			.append("Manufactor:",getManufactor()+" ")
			.append("Status:",getStatus()+" ")
			.append("PositionId:",getPositionId()+" ")
			.append("Uuid:",getUuid()+" ")
			.append("Major:",getMajor()+" ")
			.append("Minor:",getMinor()+" ")
			.append("DevType:",getDevType()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.append("DevSn:",getDevSn()+" ")
			.append("DevMac:",getDevMac()+" ")
			.append("MeasuredPower:",getMeasuredPower()+" ")
			.append("Name:",getName()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getDevId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabBluetoothDev == false) return false;
		if(this == obj) return true;
		LabBluetoothDev other = (LabBluetoothDev)obj;
		return new EqualsBuilder().append(getDevId(),other.getDevId()).isEquals();
	}
}

