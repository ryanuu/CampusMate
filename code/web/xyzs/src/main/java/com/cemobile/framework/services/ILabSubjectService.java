package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabSubject;
import com.cemobile.framework.common.page.Page;

public interface ILabSubjectService{
	
	public int insert(LabSubject labSubject);
	public int insertSelective(LabSubject labSubject);
	
	public int insertBatch(List<LabSubject> labSubjectList);

	public int deleteByPrimaryKey(java.lang.Long subjectId);

	public LabSubject selectByPrimaryKey(java.lang.Long subjectId);

	public int updateByPrimaryKey(LabSubject labSubject);

	public int updateByPrimaryKeySelective(LabSubject labSubject);

	public Page queryByKeyword(LabSubject labSubject,Page page);

	public Page queryAllLabSubject(Page page);
}