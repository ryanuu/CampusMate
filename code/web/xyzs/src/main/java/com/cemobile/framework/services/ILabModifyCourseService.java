package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabModifyCourse;
import com.cemobile.framework.common.page.Page;

public interface ILabModifyCourseService{
	
	public int insert(LabModifyCourse labModifyCourse);
	public int insertSelective(LabModifyCourse labModifyCourse);
	
	public int insertBatch(List<LabModifyCourse> labModifyCourseList);

	public int deleteByPrimaryKey(java.lang.Long modifyId);

	public LabModifyCourse selectByPrimaryKey(java.lang.Long modifyId);

	public int updateByPrimaryKey(LabModifyCourse labModifyCourse);

	public int updateByPrimaryKeySelective(LabModifyCourse labModifyCourse);

	public Page queryByKeyword(LabModifyCourse labModifyCourse,Page page);

	public Page queryAllLabModifyCourse(Page page);
}