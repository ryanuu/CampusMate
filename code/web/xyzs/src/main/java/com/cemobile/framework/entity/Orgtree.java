package com.cemobile.framework.entity;


public class Orgtree {
	private String id;
	private String text;
	private String state;
	private String disButton; //树结构删除操作按钮展示标识(1:展示；2：不展示)
	private String parentId;
	private Object children;
	private String level;//级别（学院、学系、专业、班级）
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDisButton() {
		return disButton;
	}
	public void setDisButton(String disButton) {
		this.disButton = disButton;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Object getChildren() {
		return children;
	}
	public void setChildren(Object children) {
		this.children = children;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}

