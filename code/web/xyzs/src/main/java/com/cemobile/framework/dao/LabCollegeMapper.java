package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabCollege;

public interface LabCollegeMapper{

	int insert(LabCollege labCollege);

	int insertSelective(LabCollege labCollege);

	int insertBatch(List<LabCollege> labCollegeList);

	int deleteByPrimaryKey(java.lang.Long collegeId);

	LabCollege selectByPrimaryKey(java.lang.Long collegeId);

	int updateByPrimaryKey(LabCollege labCollege);

	int updateByPrimaryKeySelective(LabCollege labCollege);
	
	List<LabCollege> queryByKeyword(LabCollege labCollege,Page page);

	List<LabCollege> queryByKeyword(LabCollege labCollege);

	List<LabCollege> queryAllLabCollege(Page page);
}
