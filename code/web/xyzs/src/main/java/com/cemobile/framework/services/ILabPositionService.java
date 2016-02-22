package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabPosition;
import com.cemobile.framework.common.page.Page;

public interface ILabPositionService{
	
	public int insert(LabPosition labPosition);
	public int insertSelective(LabPosition labPosition);
	
	public int insertBatch(List<LabPosition> labPositionList);

	public int deleteByPrimaryKey(java.lang.Long positionId);

	public LabPosition selectByPrimaryKey(java.lang.Long positionId);

	public int updateByPrimaryKey(LabPosition labPosition);

	public int updateByPrimaryKeySelective(LabPosition labPosition);

	public Page queryByKeyword(LabPosition labPosition,Page page);

	public Page queryAllLabPosition(Page page);
}