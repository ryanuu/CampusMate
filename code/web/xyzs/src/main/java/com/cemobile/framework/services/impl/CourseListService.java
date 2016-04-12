package com.cemobile.framework.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.dao.CourseListMapper;
import com.cemobile.framework.entity.CourseList;
import com.cemobile.framework.services.ICourseListService;

@Service
@Transactional
public class CourseListService implements ICourseListService {
	
	@Autowired
	private CourseListMapper courseListMapper;
	
	/**
	 * 查询课程表
	 */
	@Override
	public List<CourseList> selectByPrimaryKey(CourseList courseList) {
		// TODO Auto-generated method stub
//		List<CourseList> courseLists=courseListMapper.queryByKeywordCourseList(courseList);
		return courseListMapper.queryByKeywordCourseList(courseList);
	}

}
