package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabCollege;
import com.cemobile.framework.common.page.Page;

public interface ILabCollegeService{
	
	public int insert(LabCollege labCollege);
	public int insertSelective(LabCollege labCollege);
	
	public int insertBatch(List<LabCollege> labCollegeList);

	public int deleteByPrimaryKey(java.lang.Long collegeId);

	public LabCollege selectByPrimaryKey(java.lang.Long collegeId);

	public int updateByPrimaryKey(LabCollege labCollege);

	public int updateByPrimaryKeySelective(LabCollege labCollege);

	public Page queryByKeyword(LabCollege labCollege,Page page);

	public Page queryAllLabCollege(Page page);
}