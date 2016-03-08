package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabDepartment;

public interface LabDepartmentMapper{

	int insert(LabDepartment labDepartment);

	int insertSelective(LabDepartment labDepartment);

	int insertBatch(List<LabDepartment> labDepartmentList);

	int deleteByPrimaryKey(java.lang.Long departmentId);

	LabDepartment selectByPrimaryKey(java.lang.Long departmentId);

	int updateByPrimaryKey(LabDepartment labDepartment);

	int updateByPrimaryKeySelective(LabDepartment labDepartment);
	
	List<LabDepartment> queryByKeyword(LabDepartment labDepartment,Page page);

	List<LabDepartment> queryByKeyword(LabDepartment labDepartment);

	List<LabDepartment> queryAllLabDepartment(Page page);
}
