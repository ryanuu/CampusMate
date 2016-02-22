package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;


@SuppressWarnings("serial")
public class LabPosition extends BaseEntity{
	
	
	private java.lang.Long positionId;
	@Length(max=100)
	private java.lang.String place;
	@Length(max=20)
	private java.lang.String number;
	
	private java.lang.Integer positionType;
	
	private java.util.Date createDate;
	
	private java.util.Date editDate;
	
	private java.lang.Integer del;


	public void setPositionId(java.lang.Long value) {
		this.positionId = value;
	}
	
	public java.lang.Long getPositionId() {
		return this.positionId;
	}
	public void setPlace(java.lang.String value) {
		this.place = value;
	}
	
	public java.lang.String getPlace() {
		return this.place;
	}
	public void setNumber(java.lang.String value) {
		this.number = value;
	}
	
	public java.lang.String getNumber() {
		return this.number;
	}
	public void setPositionType(java.lang.Integer value) {
		this.positionType = value;
	}
	
	public java.lang.Integer getPositionType() {
		return this.positionType;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PositionId:",getPositionId()+" ")
			.append("Place:",getPlace()+" ")
			.append("Number:",getNumber()+" ")
			.append("PositionType:",getPositionType()+" ")
			.append("CreateDate:",getCreateDate()+" ")
			.append("EditDate:",getEditDate()+" ")
			.append("Del:",getDel()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getPositionId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof LabPosition == false) return false;
		if(this == obj) return true;
		LabPosition other = (LabPosition)obj;
		return new EqualsBuilder().append(getPositionId(),other.getPositionId()).isEquals();
	}
}

