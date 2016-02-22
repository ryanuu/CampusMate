package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabClass;
import com.cemobile.framework.common.page.Page;

public interface ILabClassService{
	
	public int insert(LabClass labClass);
	public int insertSelective(LabClass labClass);
	
	public int insertBatch(List<LabClass> labClassList);

	public int deleteByPrimaryKey(java.lang.Long classId);

	public LabClass selectByPrimaryKey(java.lang.Long classId);

	public int updateByPrimaryKey(LabClass labClass);

	public int updateByPrimaryKeySelective(LabClass labClass);

	public Page queryByKeyword(LabClass labClass,Page page);

	public Page queryAllLabClass(Page page);
}