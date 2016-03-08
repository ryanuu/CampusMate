package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabNotice;
import com.cemobile.framework.dao.LabNoticeMapper;
import com.cemobile.framework.services.ILabNoticeService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabNoticeService implements ILabNoticeService{

	@Autowired
    private LabNoticeMapper labNoticeMapper;
	
	@Override
	public int insert(LabNotice labNotice){
		return labNoticeMapper.insert(labNotice);
	}
	@Override
	public int insertSelective(LabNotice labNotice){
		return labNoticeMapper.insertSelective(labNotice);
	}
	@Override
	public int insertBatch(List<LabNotice> labNoticeList){
		return labNoticeMapper.insertBatch(labNoticeList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long noticeId){
		return labNoticeMapper.deleteByPrimaryKey(noticeId);
	}
	
	@Override
	public LabNotice selectByPrimaryKey(java.lang.Long noticeId){
		return labNoticeMapper.selectByPrimaryKey(noticeId);
	}

	@Override
	public int updateByPrimaryKey(LabNotice labNotice){
		return labNoticeMapper.updateByPrimaryKey(labNotice);
	}
	@Override
	public int updateByPrimaryKeySelective(LabNotice labNotice){
			return labNoticeMapper.updateByPrimaryKeySelective(labNotice);
	}

	@Override
	public Page queryByKeyword(LabNotice labNotice,Page page){
			List<LabNotice> resultList=labNoticeMapper.queryByKeyword(labNotice,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabNotice(Page page) {
        List<LabNotice> labNoticeList=labNoticeMapper.queryAllLabNotice(page);
        page.setResult(labNoticeList);
        return page;
    }
}