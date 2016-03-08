package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabNotice;
import com.cemobile.framework.common.page.Page;

public interface ILabNoticeService{
	
	public int insert(LabNotice labNotice);
	public int insertSelective(LabNotice labNotice);
	
	public int insertBatch(List<LabNotice> labNoticeList);

	public int deleteByPrimaryKey(java.lang.Long noticeId);

	public LabNotice selectByPrimaryKey(java.lang.Long noticeId);

	public int updateByPrimaryKey(LabNotice labNotice);

	public int updateByPrimaryKeySelective(LabNotice labNotice);

	public Page queryByKeyword(LabNotice labNotice,Page page);

	public Page queryAllLabNotice(Page page);
}