package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabCheckWork;

public interface LabCheckWorkMapper{

	int insert(LabCheckWork labCheckWork);

	int insertSelective(LabCheckWork labCheckWork);

	int insertBatch(List<LabCheckWork> labCheckWorkList);

	int deleteByPrimaryKey(java.lang.Long checkId);

	LabCheckWork selectByPrimaryKey(java.lang.Long checkId);

	int updateByPrimaryKey(LabCheckWork labCheckWork);

	int updateByPrimaryKeySelective(LabCheckWork labCheckWork);
	
	List<LabCheckWork> queryByKeyword(LabCheckWork labCheckWork,Page page);

	List<LabCheckWork> queryByKeyword(LabCheckWork labCheckWork);

	List<LabCheckWork> queryAllLabCheckWork(Page page);
}
