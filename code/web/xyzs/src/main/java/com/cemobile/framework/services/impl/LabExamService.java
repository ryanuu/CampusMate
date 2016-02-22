package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabExam;
import com.cemobile.framework.dao.LabExamMapper;
import com.cemobile.framework.services.ILabExamService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabExamService implements ILabExamService{

	@Autowired
    private LabExamMapper labExamMapper;
	
	@Override
	public int insert(LabExam labExam){
		return labExamMapper.insert(labExam);
	}
	@Override
	public int insertSelective(LabExam labExam){
		return labExamMapper.insertSelective(labExam);
	}
	@Override
	public int insertBatch(List<LabExam> labExamList){
		return labExamMapper.insertBatch(labExamList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long examId){
		return labExamMapper.deleteByPrimaryKey(examId);
	}
	
	@Override
	public LabExam selectByPrimaryKey(java.lang.Long examId){
		return labExamMapper.selectByPrimaryKey(examId);
	}

	@Override
	public int updateByPrimaryKey(LabExam labExam){
		return labExamMapper.updateByPrimaryKey(labExam);
	}
	@Override
	public int updateByPrimaryKeySelective(LabExam labExam){
			return labExamMapper.updateByPrimaryKeySelective(labExam);
	}

	@Override
	public Page queryByKeyword(LabExam labExam,Page page){
			List<LabExam> resultList=labExamMapper.queryByKeyword(labExam,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabExam(Page page) {
        List<LabExam> labExamList=labExamMapper.queryAllLabExam(page);
        page.setResult(labExamList);
        return page;
    }
}