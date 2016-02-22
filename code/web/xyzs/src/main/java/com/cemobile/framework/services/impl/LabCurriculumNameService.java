package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabCurriculumName;
import com.cemobile.framework.dao.LabCurriculumNameMapper;
import com.cemobile.framework.services.ILabCurriculumNameService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabCurriculumNameService implements ILabCurriculumNameService{

	@Autowired
    private LabCurriculumNameMapper labCurriculumNameMapper;
	
	@Override
	public int insert(LabCurriculumName labCurriculumName){
		return labCurriculumNameMapper.insert(labCurriculumName);
	}
	@Override
	public int insertSelective(LabCurriculumName labCurriculumName){
		return labCurriculumNameMapper.insertSelective(labCurriculumName);
	}
	@Override
	public int insertBatch(List<LabCurriculumName> labCurriculumNameList){
		return labCurriculumNameMapper.insertBatch(labCurriculumNameList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long curriculumId){
		return labCurriculumNameMapper.deleteByPrimaryKey(curriculumId);
	}
	
	@Override
	public LabCurriculumName selectByPrimaryKey(java.lang.Long curriculumId){
		return labCurriculumNameMapper.selectByPrimaryKey(curriculumId);
	}

	@Override
	public int updateByPrimaryKey(LabCurriculumName labCurriculumName){
		return labCurriculumNameMapper.updateByPrimaryKey(labCurriculumName);
	}
	@Override
	public int updateByPrimaryKeySelective(LabCurriculumName labCurriculumName){
			return labCurriculumNameMapper.updateByPrimaryKeySelective(labCurriculumName);
	}

	@Override
	public Page queryByKeyword(LabCurriculumName labCurriculumName,Page page){
			List<LabCurriculumName> resultList=labCurriculumNameMapper.queryByKeyword(labCurriculumName,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabCurriculumName(Page page) {
        List<LabCurriculumName> labCurriculumNameList=labCurriculumNameMapper.queryAllLabCurriculumName(page);
        page.setResult(labCurriculumNameList);
        return page;
    }
}