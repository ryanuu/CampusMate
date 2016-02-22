package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabCurriculumName;
import com.cemobile.framework.common.page.Page;

public interface ILabCurriculumNameService{
	
	public int insert(LabCurriculumName labCurriculumName);
	public int insertSelective(LabCurriculumName labCurriculumName);
	
	public int insertBatch(List<LabCurriculumName> labCurriculumNameList);

	public int deleteByPrimaryKey(java.lang.Long curriculumId);

	public LabCurriculumName selectByPrimaryKey(java.lang.Long curriculumId);

	public int updateByPrimaryKey(LabCurriculumName labCurriculumName);

	public int updateByPrimaryKeySelective(LabCurriculumName labCurriculumName);

	public Page queryByKeyword(LabCurriculumName labCurriculumName,Page page);

	public Page queryAllLabCurriculumName(Page page);
}