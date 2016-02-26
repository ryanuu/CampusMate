package com.cemobile.framework.dao;

import com.cemobile.framework.entity.Student;


public interface StudentMapper {
	
	//通过用户名查询用户信息
	Student selectByPrimaryKey(String username);
}
