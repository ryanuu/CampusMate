package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabTerm;
import com.cemobile.framework.dao.LabTermMapper;
import com.cemobile.framework.services.ILabTermService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabTermService implements ILabTermService{

	@Autowired
    private LabTermMapper labTermMapper;
	
	@Override
	public int insert(LabTerm labTerm){
		return labTermMapper.insert(labTerm);
	}
	@Override
	public int insertSelective(LabTerm labTerm){
		return labTermMapper.insertSelective(labTerm);
	}
	@Override
	public int insertBatch(List<LabTerm> labTermList){
		return labTermMapper.insertBatch(labTermList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long termId){
		return labTermMapper.deleteByPrimaryKey(termId);
	}
	
	@Override
	public LabTerm selectByPrimaryKey(java.lang.Long termId){
		return labTermMapper.selectByPrimaryKey(termId);
	}

	@Override
	public int updateByPrimaryKey(LabTerm labTerm){
		return labTermMapper.updateByPrimaryKey(labTerm);
	}
	@Override
	public int updateByPrimaryKeySelective(LabTerm labTerm){
			return labTermMapper.updateByPrimaryKeySelective(labTerm);
	}

	@Override
	public Page queryByKeyword(LabTerm labTerm,Page page){
			List<LabTerm> resultList=labTermMapper.queryByKeyword(labTerm,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabTerm(Page page) {
        List<LabTerm> labTermList=labTermMapper.queryAllLabTerm(page);
        page.setResult(labTermList);
        return page;
    }
}