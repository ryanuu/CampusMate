package com.cemobile.framework.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.dao.TeacherUserMapper;
import com.cemobile.framework.entity.Teacher;
import com.cemobile.framework.entity.TeacherUser;
import com.cemobile.framework.services.ITeacherService;

@Service
@Transactional
public class TeacherService implements ITeacherService {

	@Autowired
	private TeacherUserMapper teacherUserMapper;
	
	@Override
	public TeacherUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return teacherUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public Teacher selectByPrimaryName(String username) {
		// TODO Auto-generated method stub
		return teacherUserMapper.selectByPrimaryName(username);
	}

}
