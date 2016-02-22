package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabNotice;

public interface LabNoticeMapper{

	int insert(LabNotice labNotice);

	int insertSelective(LabNotice labNotice);

	int insertBatch(List<LabNotice> labNoticeList);

	int deleteByPrimaryKey(java.lang.Long noticeId);

	LabNotice selectByPrimaryKey(java.lang.Long noticeId);

	int updateByPrimaryKey(LabNotice labNotice);

	int updateByPrimaryKeySelective(LabNotice labNotice);
	
	List<LabNotice> queryByKeyword(LabNotice labNotice,Page page);

	List<LabNotice> queryByKeyword(LabNotice labNotice);

	List<LabNotice> queryAllLabNotice(Page page);
}
