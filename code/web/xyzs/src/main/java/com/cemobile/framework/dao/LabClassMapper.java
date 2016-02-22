package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabClass;

public interface LabClassMapper{

	int insert(LabClass labClass);

	int insertSelective(LabClass labClass);

	int insertBatch(List<LabClass> labClassList);

	int deleteByPrimaryKey(java.lang.Long classId);

	LabClass selectByPrimaryKey(java.lang.Long classId);

	int updateByPrimaryKey(LabClass labClass);

	int updateByPrimaryKeySelective(LabClass labClass);
	
	List<LabClass> queryByKeyword(LabClass labClass,Page page);

	List<LabClass> queryByKeyword(LabClass labClass);

	List<LabClass> queryAllLabClass(Page page);
}
