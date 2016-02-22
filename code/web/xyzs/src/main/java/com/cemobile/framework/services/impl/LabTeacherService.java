package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabTeacher;
import com.cemobile.framework.dao.LabTeacherMapper;
import com.cemobile.framework.services.ILabTeacherService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabTeacherService implements ILabTeacherService{

	@Autowired
    private LabTeacherMapper labTeacherMapper;
	
	@Override
	public int insert(LabTeacher labTeacher){
		return labTeacherMapper.insert(labTeacher);
	}
	@Override
	public int insertSelective(LabTeacher labTeacher){
		return labTeacherMapper.insertSelective(labTeacher);
	}
	@Override
	public int insertBatch(List<LabTeacher> labTeacherList){
		return labTeacherMapper.insertBatch(labTeacherList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long teacherId){
		return labTeacherMapper.deleteByPrimaryKey(teacherId);
	}
	
	@Override
	public LabTeacher selectByPrimaryKey(java.lang.Long teacherId){
		return labTeacherMapper.selectByPrimaryKey(teacherId);
	}

	@Override
	public int updateByPrimaryKey(LabTeacher labTeacher){
		return labTeacherMapper.updateByPrimaryKey(labTeacher);
	}
	@Override
	public int updateByPrimaryKeySelective(LabTeacher labTeacher){
			return labTeacherMapper.updateByPrimaryKeySelective(labTeacher);
	}

	@Override
	public Page queryByKeyword(LabTeacher labTeacher,Page page){
			List<LabTeacher> resultList=labTeacherMapper.queryByKeyword(labTeacher,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabTeacher(Page page) {
        List<LabTeacher> labTeacherList=labTeacherMapper.queryAllLabTeacher(page);
        page.setResult(labTeacherList);
        return page;
    }
}