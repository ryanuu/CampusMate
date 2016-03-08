package com.cemobile.framework.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
public class Demo {
	
	
	private Long id;
	@Length(max=200)
	//@Pattern(regexp = "^\\d{1}$",message="只能为一位的数值")
	private java.lang.String name;
	
	private Long type;
	@Length(max=3000)
	private java.lang.String description;


	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setType(Long value) {
		this.type = value;
	}
	
	public Long getType() {
		return this.type;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id:",getId()+" ")
			.append("Name:",getName()+" ")
			.append("Type:",getType()+" ")
			.append("Description:",getDescription()+" ")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Demo == false) return false;
		if(this == obj) return true;
		return new EqualsBuilder().isEquals();
	}
}

