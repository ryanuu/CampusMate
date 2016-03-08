package com.cemobile.framework.entity;

public class OrgsTree {

	public String id;//id：节点ID，对加载远程数据很重要。
	public String text;//text：显示节点文本。
	public String state;//state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	public boolean checked;//checked：表示该节点是否被选中。
	public Object children;//children: 一个节点数组声明了若干节点。
	
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
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Object getChildren() {
		return children;
	}
	public void setChildren(Object children) {
		this.children = children;
	}
	
	
}
