package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabStudent;

public interface LabStudentMapper{

	int insert(LabStudent labStudent);

	int insertSelective(LabStudent labStudent);

	int insertBatch(List<LabStudent> labStudentList);

	int deleteByPrimaryKey(java.lang.Long studentId);

	LabStudent selectByPrimaryKey(java.lang.Long studentId);

	int updateByPrimaryKey(LabStudent labStudent);

	int updateByPrimaryKeySelective(LabStudent labStudent);
	
	List<LabStudent> queryByKeyword(LabStudent labStudent,Page page);

	List<LabStudent> queryByKeyword(LabStudent labStudent);

	List<LabStudent> queryAllLabStudent(Page page);
}
