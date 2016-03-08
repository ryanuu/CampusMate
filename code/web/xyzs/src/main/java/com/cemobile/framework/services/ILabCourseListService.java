package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabCourseList;
import com.cemobile.framework.common.page.Page;

public interface ILabCourseListService{
	
	public int insert(LabCourseList labCourseList);
	public int insertSelective(LabCourseList labCourseList);
	
	public int insertBatch(List<LabCourseList> labCourseListList);

	public int deleteByPrimaryKey(java.lang.Long courseListId);

	public LabCourseList selectByPrimaryKey(java.lang.Long courseListId);

	public int updateByPrimaryKey(LabCourseList labCourseList);

	public int updateByPrimaryKeySelective(LabCourseList labCourseList);

	public Page queryByKeyword(LabCourseList labCourseList,Page page);

	public Page queryAllLabCourseList(Page page);
}