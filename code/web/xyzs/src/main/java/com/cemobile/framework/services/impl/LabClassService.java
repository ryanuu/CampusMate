package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabClass;
import com.cemobile.framework.dao.LabClassMapper;
import com.cemobile.framework.services.ILabClassService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabClassService implements ILabClassService{

	@Autowired
    private LabClassMapper labClassMapper;
	
	@Override
	public int insert(LabClass labClass){
		return labClassMapper.insert(labClass);
	}
	@Override
	public int insertSelective(LabClass labClass){
		return labClassMapper.insertSelective(labClass);
	}
	@Override
	public int insertBatch(List<LabClass> labClassList){
		return labClassMapper.insertBatch(labClassList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long classId){
		return labClassMapper.deleteByPrimaryKey(classId);
	}
	
	@Override
	public LabClass selectByPrimaryKey(java.lang.Long classId){
		return labClassMapper.selectByPrimaryKey(classId);
	}

	@Override
	public int updateByPrimaryKey(LabClass labClass){
		return labClassMapper.updateByPrimaryKey(labClass);
	}
	@Override
	public int updateByPrimaryKeySelective(LabClass labClass){
			return labClassMapper.updateByPrimaryKeySelective(labClass);
	}

	@Override
	public Page queryByKeyword(LabClass labClass,Page page){
			List<LabClass> resultList=labClassMapper.queryByKeyword(labClass,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabClass(Page page) {
        List<LabClass> labClassList=labClassMapper.queryAllLabClass(page);
        page.setResult(labClassList);
        return page;
    }
}