package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabPosition;
import com.cemobile.framework.dao.LabPositionMapper;
import com.cemobile.framework.services.ILabPositionService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabPositionService implements ILabPositionService{

	@Autowired
    private LabPositionMapper labPositionMapper;
	
	@Override
	public int insert(LabPosition labPosition){
		return labPositionMapper.insert(labPosition);
	}
	@Override
	public int insertSelective(LabPosition labPosition){
		return labPositionMapper.insertSelective(labPosition);
	}
	@Override
	public int insertBatch(List<LabPosition> labPositionList){
		return labPositionMapper.insertBatch(labPositionList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long positionId){
		return labPositionMapper.deleteByPrimaryKey(positionId);
	}
	
	@Override
	public LabPosition selectByPrimaryKey(java.lang.Long positionId){
		return labPositionMapper.selectByPrimaryKey(positionId);
	}

	@Override
	public int updateByPrimaryKey(LabPosition labPosition){
		return labPositionMapper.updateByPrimaryKey(labPosition);
	}
	@Override
	public int updateByPrimaryKeySelective(LabPosition labPosition){
			return labPositionMapper.updateByPrimaryKeySelective(labPosition);
	}

	@Override
	public Page queryByKeyword(LabPosition labPosition,Page page){
			List<LabPosition> resultList=labPositionMapper.queryByKeyword(labPosition,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabPosition(Page page) {
        List<LabPosition> labPositionList=labPositionMapper.queryAllLabPosition(page);
        page.setResult(labPositionList);
        return page;
    }
}