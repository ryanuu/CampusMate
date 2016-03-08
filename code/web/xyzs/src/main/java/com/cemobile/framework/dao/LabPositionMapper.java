package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabPosition;

public interface LabPositionMapper{

	int insert(LabPosition labPosition);

	int insertSelective(LabPosition labPosition);

	int insertBatch(List<LabPosition> labPositionList);

	int deleteByPrimaryKey(java.lang.Long positionId);

	LabPosition selectByPrimaryKey(java.lang.Long positionId);

	int updateByPrimaryKey(LabPosition labPosition);

	int updateByPrimaryKeySelective(LabPosition labPosition);
	
	List<LabPosition> queryByKeyword(LabPosition labPosition,Page page);

	List<LabPosition> queryByKeyword(LabPosition labPosition);

	List<LabPosition> queryAllLabPosition(Page page);
}
