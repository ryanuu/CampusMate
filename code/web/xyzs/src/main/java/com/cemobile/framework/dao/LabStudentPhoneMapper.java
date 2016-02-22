package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabStudentPhone;

public interface LabStudentPhoneMapper{

	int insert(LabStudentPhone labStudentPhone);

	int insertSelective(LabStudentPhone labStudentPhone);

	int insertBatch(List<LabStudentPhone> labStudentPhoneList);

	int deleteByPrimaryKey(java.lang.Long macId);

	LabStudentPhone selectByPrimaryKey(java.lang.Long macId);

	int updateByPrimaryKey(LabStudentPhone labStudentPhone);

	int updateByPrimaryKeySelective(LabStudentPhone labStudentPhone);
	
	List<LabStudentPhone> queryByKeyword(LabStudentPhone labStudentPhone,Page page);

	List<LabStudentPhone> queryByKeyword(LabStudentPhone labStudentPhone);

	List<LabStudentPhone> queryAllLabStudentPhone(Page page);
}
