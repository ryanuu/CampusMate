package com.cemobile.framework.dao;

import com.cemobile.framework.entity.Teacher;
import com.cemobile.framework.entity.TeacherUser;

public interface TeacherUserMapper {
	//根据id查询用户信息
	TeacherUser selectByPrimaryKey(Long id);
	
	//根据用户名查询用户信息
	Teacher selectByPrimaryName(String username);
}
