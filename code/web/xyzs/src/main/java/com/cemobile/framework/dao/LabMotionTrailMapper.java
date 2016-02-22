package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabMotionTrail;

public interface LabMotionTrailMapper{

	int insert(LabMotionTrail labMotionTrail);

	int insertSelective(LabMotionTrail labMotionTrail);

	int insertBatch(List<LabMotionTrail> labMotionTrailList);

	int deleteByPrimaryKey(java.lang.Long trailD);

	LabMotionTrail selectByPrimaryKey(java.lang.Long trailD);

	int updateByPrimaryKey(LabMotionTrail labMotionTrail);

	int updateByPrimaryKeySelective(LabMotionTrail labMotionTrail);
	
	List<LabMotionTrail> queryByKeyword(LabMotionTrail labMotionTrail,Page page);

	List<LabMotionTrail> queryByKeyword(LabMotionTrail labMotionTrail);

	List<LabMotionTrail> queryAllLabMotionTrail(Page page);
}
