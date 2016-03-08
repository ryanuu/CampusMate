package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabSubject;
import com.cemobile.framework.dao.LabSubjectMapper;
import com.cemobile.framework.services.ILabSubjectService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabSubjectService implements ILabSubjectService{

	@Autowired
    private LabSubjectMapper labSubjectMapper;
	
	@Override
	public int insert(LabSubject labSubject){
		return labSubjectMapper.insert(labSubject);
	}
	@Override
	public int insertSelective(LabSubject labSubject){
		return labSubjectMapper.insertSelective(labSubject);
	}
	@Override
	public int insertBatch(List<LabSubject> labSubjectList){
		return labSubjectMapper.insertBatch(labSubjectList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long subjectId){
		return labSubjectMapper.deleteByPrimaryKey(subjectId);
	}
	
	@Override
	public LabSubject selectByPrimaryKey(java.lang.Long subjectId){
		return labSubjectMapper.selectByPrimaryKey(subjectId);
	}

	@Override
	public int updateByPrimaryKey(LabSubject labSubject){
		return labSubjectMapper.updateByPrimaryKey(labSubject);
	}
	@Override
	public int updateByPrimaryKeySelective(LabSubject labSubject){
			return labSubjectMapper.updateByPrimaryKeySelective(labSubject);
	}

	@Override
	public Page queryByKeyword(LabSubject labSubject,Page page){
			List<LabSubject> resultList=labSubjectMapper.queryByKeyword(labSubject,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabSubject(Page page) {
        List<LabSubject> labSubjectList=labSubjectMapper.queryAllLabSubject(page);
        page.setResult(labSubjectList);
        return page;
    }
}