package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabCheckWork;
import com.cemobile.framework.dao.LabCheckWorkMapper;
import com.cemobile.framework.services.ILabCheckWorkService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabCheckWorkService implements ILabCheckWorkService{

	@Autowired
    private LabCheckWorkMapper labCheckWorkMapper;
	
	@Override
	public int insert(LabCheckWork labCheckWork){
		return labCheckWorkMapper.insert(labCheckWork);
	}
	@Override
	public int insertSelective(LabCheckWork labCheckWork){
		return labCheckWorkMapper.insertSelective(labCheckWork);
	}
	@Override
	public int insertBatch(List<LabCheckWork> labCheckWorkList){
		return labCheckWorkMapper.insertBatch(labCheckWorkList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long checkId){
		return labCheckWorkMapper.deleteByPrimaryKey(checkId);
	}
	
	@Override
	public LabCheckWork selectByPrimaryKey(java.lang.Long checkId){
		return labCheckWorkMapper.selectByPrimaryKey(checkId);
	}

	@Override
	public int updateByPrimaryKey(LabCheckWork labCheckWork){
		return labCheckWorkMapper.updateByPrimaryKey(labCheckWork);
	}
	@Override
	public int updateByPrimaryKeySelective(LabCheckWork labCheckWork){
			return labCheckWorkMapper.updateByPrimaryKeySelective(labCheckWork);
	}

	@Override
	public Page queryByKeyword(LabCheckWork labCheckWork,Page page){
			List<LabCheckWork> resultList=labCheckWorkMapper.queryByKeyword(labCheckWork,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabCheckWork(Page page) {
        List<LabCheckWork> labCheckWorkList=labCheckWorkMapper.queryAllLabCheckWork(page);
        page.setResult(labCheckWorkList);
        return page;
    }
}