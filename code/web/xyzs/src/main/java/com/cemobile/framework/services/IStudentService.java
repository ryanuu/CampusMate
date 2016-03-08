package com.cemobile.framework.services;

import com.cemobile.framework.entity.Student;

public interface IStudentService {
	
	//通过用户名查询用户信息
	public Student selectByPrimaryKey(String username);
}
