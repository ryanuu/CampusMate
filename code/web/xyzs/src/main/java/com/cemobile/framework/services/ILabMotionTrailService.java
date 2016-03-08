package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabMotionTrail;
import com.cemobile.framework.common.page.Page;

public interface ILabMotionTrailService{
	
	public int insert(LabMotionTrail labMotionTrail);
	public int insertSelective(LabMotionTrail labMotionTrail);
	
	public int insertBatch(List<LabMotionTrail> labMotionTrailList);

	public int deleteByPrimaryKey(java.lang.Long trailD);

	public LabMotionTrail selectByPrimaryKey(java.lang.Long trailD);

	public int updateByPrimaryKey(LabMotionTrail labMotionTrail);

	public int updateByPrimaryKeySelective(LabMotionTrail labMotionTrail);

	public Page queryByKeyword(LabMotionTrail labMotionTrail,Page page);

	public Page queryAllLabMotionTrail(Page page);
}