package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabDepartment;
import com.cemobile.framework.dao.LabDepartmentMapper;
import com.cemobile.framework.services.ILabDepartmentService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabDepartmentService implements ILabDepartmentService{

	@Autowired
    private LabDepartmentMapper labDepartmentMapper;
	
	@Override
	public int insert(LabDepartment labDepartment){
		return labDepartmentMapper.insert(labDepartment);
	}
	@Override
	public int insertSelective(LabDepartment labDepartment){
		return labDepartmentMapper.insertSelective(labDepartment);
	}
	@Override
	public int insertBatch(List<LabDepartment> labDepartmentList){
		return labDepartmentMapper.insertBatch(labDepartmentList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long departmentId){
		return labDepartmentMapper.deleteByPrimaryKey(departmentId);
	}
	
	@Override
	public LabDepartment selectByPrimaryKey(java.lang.Long departmentId){
		return labDepartmentMapper.selectByPrimaryKey(departmentId);
	}

	@Override
	public int updateByPrimaryKey(LabDepartment labDepartment){
		return labDepartmentMapper.updateByPrimaryKey(labDepartment);
	}
	@Override
	public int updateByPrimaryKeySelective(LabDepartment labDepartment){
			return labDepartmentMapper.updateByPrimaryKeySelective(labDepartment);
	}

	@Override
	public Page queryByKeyword(LabDepartment labDepartment,Page page){
			List<LabDepartment> resultList=labDepartmentMapper.queryByKeyword(labDepartment,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabDepartment(Page page) {
        List<LabDepartment> labDepartmentList=labDepartmentMapper.queryAllLabDepartment(page);
        page.setResult(labDepartmentList);
        return page;
    }
}