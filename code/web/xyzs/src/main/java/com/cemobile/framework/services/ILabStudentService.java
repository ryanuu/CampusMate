package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabStudent;
import com.cemobile.framework.common.page.Page;

public interface ILabStudentService{
	
	public int insert(LabStudent labStudent);
	public int insertSelective(LabStudent labStudent);
	
	public int insertBatch(List<LabStudent> labStudentList);

	public int deleteByPrimaryKey(java.lang.Long studentId);

	public LabStudent selectByPrimaryKey(java.lang.Long studentId);

	public int updateByPrimaryKey(LabStudent labStudent);

	public int updateByPrimaryKeySelective(LabStudent labStudent);

	public Page queryByKeyword(LabStudent labStudent,Page page);

	public Page queryAllLabStudent(Page page);
}