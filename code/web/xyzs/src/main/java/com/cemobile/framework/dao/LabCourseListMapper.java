package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabCourseList;

public interface LabCourseListMapper{

	int insert(LabCourseList labCourseList);

	int insertSelective(LabCourseList labCourseList);

	int insertBatch(List<LabCourseList> labCourseListList);

	int deleteByPrimaryKey(java.lang.Long courseListId);

	LabCourseList selectByPrimaryKey(java.lang.Long courseListId);

	int updateByPrimaryKey(LabCourseList labCourseList);

	int updateByPrimaryKeySelective(LabCourseList labCourseList);
	
	List<LabCourseList> queryByKeyword(LabCourseList labCourseList,Page page);

	List<LabCourseList> queryByKeyword(LabCourseList labCourseList);

	List<LabCourseList> queryAllLabCourseList(Page page);
}
