package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTeacher;

public interface LabTeacherMapper{

	int insert(LabTeacher labTeacher);

	int insertSelective(LabTeacher labTeacher);

	int insertBatch(List<LabTeacher> labTeacherList);

	int deleteByPrimaryKey(java.lang.Long teacherId);

	LabTeacher selectByPrimaryKey(java.lang.Long teacherId);

	int updateByPrimaryKey(LabTeacher labTeacher);

	int updateByPrimaryKeySelective(LabTeacher labTeacher);
	
	List<LabTeacher> queryByKeyword(LabTeacher labTeacher,Page page);

	List<LabTeacher> queryByKeyword(LabTeacher labTeacher);

	List<LabTeacher> queryAllLabTeacher(Page page);
}
