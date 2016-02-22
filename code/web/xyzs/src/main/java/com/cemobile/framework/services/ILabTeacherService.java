package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabTeacher;
import com.cemobile.framework.common.page.Page;

public interface ILabTeacherService{
	
	public int insert(LabTeacher labTeacher);
	public int insertSelective(LabTeacher labTeacher);
	
	public int insertBatch(List<LabTeacher> labTeacherList);

	public int deleteByPrimaryKey(java.lang.Long teacherId);

	public LabTeacher selectByPrimaryKey(java.lang.Long teacherId);

	public int updateByPrimaryKey(LabTeacher labTeacher);

	public int updateByPrimaryKeySelective(LabTeacher labTeacher);

	public Page queryByKeyword(LabTeacher labTeacher,Page page);

	public Page queryAllLabTeacher(Page page);
}