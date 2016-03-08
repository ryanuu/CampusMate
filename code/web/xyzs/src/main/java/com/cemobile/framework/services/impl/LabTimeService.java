package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabTime;
import com.cemobile.framework.dao.LabTimeMapper;
import com.cemobile.framework.services.ILabTimeService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabTimeService implements ILabTimeService{

	@Autowired
    private LabTimeMapper labTimeMapper;
	
	@Override
	public int insert(LabTime labTime){
		return labTimeMapper.insert(labTime);
	}
	@Override
	public int insertSelective(LabTime labTime){
		return labTimeMapper.insertSelective(labTime);
	}
	@Override
	public int insertBatch(List<LabTime> labTimeList){
		return labTimeMapper.insertBatch(labTimeList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long id){
		return labTimeMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public LabTime selectByPrimaryKey(java.lang.Long id){
		return labTimeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(LabTime labTime){
		return labTimeMapper.updateByPrimaryKey(labTime);
	}
	@Override
	public int updateByPrimaryKeySelective(LabTime labTime){
			return labTimeMapper.updateByPrimaryKeySelective(labTime);
	}

	@Override
	public Page queryByKeyword(LabTime labTime,Page page){
			List<LabTime> resultList=labTimeMapper.queryByKeyword(labTime,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabTime(Page page) {
        List<LabTime> labTimeList=labTimeMapper.queryAllLabTime(page);
        page.setResult(labTimeList);
        return page;
    }
}