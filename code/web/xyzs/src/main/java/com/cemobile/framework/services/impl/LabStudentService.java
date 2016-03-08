package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabStudent;
import com.cemobile.framework.dao.LabStudentMapper;
import com.cemobile.framework.services.ILabStudentService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabStudentService implements ILabStudentService{

	@Autowired
    private LabStudentMapper labStudentMapper;
	
	@Override
	public int insert(LabStudent labStudent){
		return labStudentMapper.insert(labStudent);
	}
	@Override
	public int insertSelective(LabStudent labStudent){
		return labStudentMapper.insertSelective(labStudent);
	}
	@Override
	public int insertBatch(List<LabStudent> labStudentList){
		return labStudentMapper.insertBatch(labStudentList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long studentId){
		return labStudentMapper.deleteByPrimaryKey(studentId);
	}
	
	@Override
	public LabStudent selectByPrimaryKey(java.lang.Long studentId){
		return labStudentMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public int updateByPrimaryKey(LabStudent labStudent){
		return labStudentMapper.updateByPrimaryKey(labStudent);
	}
	@Override
	public int updateByPrimaryKeySelective(LabStudent labStudent){
			return labStudentMapper.updateByPrimaryKeySelective(labStudent);
	}

	@Override
	public Page queryByKeyword(LabStudent labStudent,Page page){
			List<LabStudent> resultList=labStudentMapper.queryByKeyword(labStudent,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabStudent(Page page) {
        List<LabStudent> labStudentList=labStudentMapper.queryAllLabStudent(page);
        page.setResult(labStudentList);
        return page;
    }
}