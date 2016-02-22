package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTerm;

public interface LabTermMapper{

	int insert(LabTerm labTerm);

	int insertSelective(LabTerm labTerm);

	int insertBatch(List<LabTerm> labTermList);

	int deleteByPrimaryKey(java.lang.Long termId);

	LabTerm selectByPrimaryKey(java.lang.Long termId);

	int updateByPrimaryKey(LabTerm labTerm);

	int updateByPrimaryKeySelective(LabTerm labTerm);
	
	List<LabTerm> queryByKeyword(LabTerm labTerm,Page page);

	List<LabTerm> queryByKeyword(LabTerm labTerm);

	List<LabTerm> queryAllLabTerm(Page page);
}
