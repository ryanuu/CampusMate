package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabMotionTrail;
import com.cemobile.framework.dao.LabMotionTrailMapper;
import com.cemobile.framework.services.ILabMotionTrailService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabMotionTrailService implements ILabMotionTrailService{

	@Autowired
    private LabMotionTrailMapper labMotionTrailMapper;
	
	@Override
	public int insert(LabMotionTrail labMotionTrail){
		return labMotionTrailMapper.insert(labMotionTrail);
	}
	@Override
	public int insertSelective(LabMotionTrail labMotionTrail){
		return labMotionTrailMapper.insertSelective(labMotionTrail);
	}
	@Override
	public int insertBatch(List<LabMotionTrail> labMotionTrailList){
		return labMotionTrailMapper.insertBatch(labMotionTrailList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long trailD){
		return labMotionTrailMapper.deleteByPrimaryKey(trailD);
	}
	
	@Override
	public LabMotionTrail selectByPrimaryKey(java.lang.Long trailD){
		return labMotionTrailMapper.selectByPrimaryKey(trailD);
	}

	@Override
	public int updateByPrimaryKey(LabMotionTrail labMotionTrail){
		return labMotionTrailMapper.updateByPrimaryKey(labMotionTrail);
	}
	@Override
	public int updateByPrimaryKeySelective(LabMotionTrail labMotionTrail){
			return labMotionTrailMapper.updateByPrimaryKeySelective(labMotionTrail);
	}

	@Override
	public Page queryByKeyword(LabMotionTrail labMotionTrail,Page page){
			List<LabMotionTrail> resultList=labMotionTrailMapper.queryByKeyword(labMotionTrail,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabMotionTrail(Page page) {
        List<LabMotionTrail> labMotionTrailList=labMotionTrailMapper.queryAllLabMotionTrail(page);
        page.setResult(labMotionTrailList);
        return page;
    }
}