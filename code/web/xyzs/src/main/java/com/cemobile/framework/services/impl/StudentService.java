package com.cemobile.framework.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.dao.StudentMapper;
import com.cemobile.framework.entity.Student;
import com.cemobile.framework.services.IStudentService;

@Service
@Transactional
public class StudentService implements IStudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public Student selectByPrimaryKey(String username) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(username);
	}

}
