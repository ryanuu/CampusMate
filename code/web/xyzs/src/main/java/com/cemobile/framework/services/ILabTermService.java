package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabTerm;
import com.cemobile.framework.common.page.Page;

public interface ILabTermService{
	
	public int insert(LabTerm labTerm);
	public int insertSelective(LabTerm labTerm);
	
	public int insertBatch(List<LabTerm> labTermList);

	public int deleteByPrimaryKey(java.lang.Long termId);

	public LabTerm selectByPrimaryKey(java.lang.Long termId);

	public int updateByPrimaryKey(LabTerm labTerm);

	public int updateByPrimaryKeySelective(LabTerm labTerm);

	public Page queryByKeyword(LabTerm labTerm,Page page);

	public Page queryAllLabTerm(Page page);
}