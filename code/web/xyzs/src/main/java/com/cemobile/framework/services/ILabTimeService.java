package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabTime;
import com.cemobile.framework.common.page.Page;

public interface ILabTimeService{
	
	public int insert(LabTime labTime);
	public int insertSelective(LabTime labTime);
	
	public int insertBatch(List<LabTime> labTimeList);

	public int deleteByPrimaryKey(java.lang.Long id);

	public LabTime selectByPrimaryKey(java.lang.Long id);

	public int updateByPrimaryKey(LabTime labTime);

	public int updateByPrimaryKeySelective(LabTime labTime);

	public Page queryByKeyword(LabTime labTime,Page page);

	public Page queryAllLabTime(Page page);
}