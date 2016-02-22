package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabSubject;

public interface LabSubjectMapper{

	int insert(LabSubject labSubject);

	int insertSelective(LabSubject labSubject);

	int insertBatch(List<LabSubject> labSubjectList);

	int deleteByPrimaryKey(java.lang.Long subjectId);

	LabSubject selectByPrimaryKey(java.lang.Long subjectId);

	int updateByPrimaryKey(LabSubject labSubject);

	int updateByPrimaryKeySelective(LabSubject labSubject);
	
	List<LabSubject> queryByKeyword(LabSubject labSubject,Page page);

	List<LabSubject> queryByKeyword(LabSubject labSubject);

	List<LabSubject> queryAllLabSubject(Page page);
}
