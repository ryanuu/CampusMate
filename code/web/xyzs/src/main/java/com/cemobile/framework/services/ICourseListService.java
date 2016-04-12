package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.CourseList;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年4月11日上午10:34:28
 * 类说明：课程表模块-服务层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface ICourseListService {
	/*查询课程表*/
	public List<CourseList> selectByPrimaryKey(CourseList courseList);
}
