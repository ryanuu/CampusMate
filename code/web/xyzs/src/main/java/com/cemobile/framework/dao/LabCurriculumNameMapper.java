package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabCurriculumName;

public interface LabCurriculumNameMapper{

	int insert(LabCurriculumName labCurriculumName);

	int insertSelective(LabCurriculumName labCurriculumName);

	int insertBatch(List<LabCurriculumName> labCurriculumNameList);

	int deleteByPrimaryKey(java.lang.Long curriculumId);

	LabCurriculumName selectByPrimaryKey(java.lang.Long curriculumId);

	int updateByPrimaryKey(LabCurriculumName labCurriculumName);

	int updateByPrimaryKeySelective(LabCurriculumName labCurriculumName);
	
	List<LabCurriculumName> queryByKeyword(LabCurriculumName labCurriculumName,Page page);

	List<LabCurriculumName> queryByKeyword(LabCurriculumName labCurriculumName);

	List<LabCurriculumName> queryAllLabCurriculumName(Page page);
}
