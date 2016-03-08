package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabModifyCourse;

public interface LabModifyCourseMapper{

	int insert(LabModifyCourse labModifyCourse);

	int insertSelective(LabModifyCourse labModifyCourse);

	int insertBatch(List<LabModifyCourse> labModifyCourseList);

	int deleteByPrimaryKey(java.lang.Long modifyId);

	LabModifyCourse selectByPrimaryKey(java.lang.Long modifyId);

	int updateByPrimaryKey(LabModifyCourse labModifyCourse);

	int updateByPrimaryKeySelective(LabModifyCourse labModifyCourse);
	
	List<LabModifyCourse> queryByKeyword(LabModifyCourse labModifyCourse,Page page);

	List<LabModifyCourse> queryByKeyword(LabModifyCourse labModifyCourse);

	List<LabModifyCourse> queryAllLabModifyCourse(Page page);
}
