package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTime;

public interface LabTimeMapper{

	int insert(LabTime labTime);

	int insertSelective(LabTime labTime);

	int insertBatch(List<LabTime> labTimeList);

	int deleteByPrimaryKey(java.lang.Long id);

	LabTime selectByPrimaryKey(java.lang.Long id);

	int updateByPrimaryKey(LabTime labTime);

	int updateByPrimaryKeySelective(LabTime labTime);
	
	List<LabTime> queryByKeyword(LabTime labTime,Page page);

	List<LabTime> queryByKeyword(LabTime labTime);

	List<LabTime> queryAllLabTime(Page page);
}
