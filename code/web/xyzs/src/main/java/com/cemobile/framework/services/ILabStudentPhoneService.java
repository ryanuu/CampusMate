package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabStudentPhone;
import com.cemobile.framework.common.page.Page;

public interface ILabStudentPhoneService{
	
	public int insert(LabStudentPhone labStudentPhone);
	public int insertSelective(LabStudentPhone labStudentPhone);
	
	public int insertBatch(List<LabStudentPhone> labStudentPhoneList);

	public int deleteByPrimaryKey(java.lang.Long macId);

	public LabStudentPhone selectByPrimaryKey(java.lang.Long macId);

	public int updateByPrimaryKey(LabStudentPhone labStudentPhone);

	public int updateByPrimaryKeySelective(LabStudentPhone labStudentPhone);

	public Page queryByKeyword(LabStudentPhone labStudentPhone,Page page);

	public Page queryAllLabStudentPhone(Page page);
}