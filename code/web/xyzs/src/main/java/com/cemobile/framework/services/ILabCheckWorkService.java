package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabCheckWork;
import com.cemobile.framework.common.page.Page;

public interface ILabCheckWorkService{
	
	public int insert(LabCheckWork labCheckWork);
	public int insertSelective(LabCheckWork labCheckWork);
	
	public int insertBatch(List<LabCheckWork> labCheckWorkList);

	public int deleteByPrimaryKey(java.lang.Long checkId);

	public LabCheckWork selectByPrimaryKey(java.lang.Long checkId);

	public int updateByPrimaryKey(LabCheckWork labCheckWork);

	public int updateByPrimaryKeySelective(LabCheckWork labCheckWork);

	public Page queryByKeyword(LabCheckWork labCheckWork,Page page);

	public Page queryAllLabCheckWork(Page page);
}