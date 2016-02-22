package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabExam;
import com.cemobile.framework.common.page.Page;

public interface ILabExamService{
	
	public int insert(LabExam labExam);
	public int insertSelective(LabExam labExam);
	
	public int insertBatch(List<LabExam> labExamList);

	public int deleteByPrimaryKey(java.lang.Long examId);

	public LabExam selectByPrimaryKey(java.lang.Long examId);

	public int updateByPrimaryKey(LabExam labExam);

	public int updateByPrimaryKeySelective(LabExam labExam);

	public Page queryByKeyword(LabExam labExam,Page page);

	public Page queryAllLabExam(Page page);
}