package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabDepartment;
import com.cemobile.framework.common.page.Page;

public interface ILabDepartmentService{
	
	public int insert(LabDepartment labDepartment);
	public int insertSelective(LabDepartment labDepartment);
	
	public int insertBatch(List<LabDepartment> labDepartmentList);

	public int deleteByPrimaryKey(java.lang.Long departmentId);

	public LabDepartment selectByPrimaryKey(java.lang.Long departmentId);

	public int updateByPrimaryKey(LabDepartment labDepartment);

	public int updateByPrimaryKeySelective(LabDepartment labDepartment);

	public Page queryByKeyword(LabDepartment labDepartment,Page page);

	public Page queryAllLabDepartment(Page page);
}