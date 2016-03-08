package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabExam;

public interface LabExamMapper{

	int insert(LabExam labExam);

	int insertSelective(LabExam labExam);

	int insertBatch(List<LabExam> labExamList);

	int deleteByPrimaryKey(java.lang.Long examId);

	LabExam selectByPrimaryKey(java.lang.Long examId);

	int updateByPrimaryKey(LabExam labExam);

	int updateByPrimaryKeySelective(LabExam labExam);
	
	List<LabExam> queryByKeyword(LabExam labExam,Page page);

	List<LabExam> queryByKeyword(LabExam labExam);

	List<LabExam> queryAllLabExam(Page page);
}
