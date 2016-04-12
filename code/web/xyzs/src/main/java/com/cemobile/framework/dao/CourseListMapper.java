package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.entity.CourseList;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年4月8日下午3:19:33
 * 类说明：课程表模块-Dao层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface CourseListMapper {
	//查询课程表
	List<CourseList> queryByKeywordCourseList(CourseList courseList);
}
