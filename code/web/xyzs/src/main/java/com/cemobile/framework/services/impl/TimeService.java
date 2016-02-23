package com.cemobile.framework.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dao.TimeMapper;
import com.cemobile.framework.entity.PlaytimeTime;
import com.cemobile.framework.services.ITimeService;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月23日下午3:03:37
 * 类说明：时间表服务层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
@Service
@Transactional
public class TimeService implements ITimeService {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Override
	public Page queryByKeyword(PlaytimeTime time, Page page) {
		// TODO Auto-generated method stub
		List<PlaytimeTime> resultList=timeMapper.queryByKeyword(time,page);
		page.setResult(resultList);
		return page;
	}

	@Override
	public Page queryAllTerm(Page page) {
		// TODO Auto-generated method stub
		List<PlaytimeTime> labTimeList=timeMapper.queryAllTerm(page);
        page.setResult(labTimeList);
        return page;
	}

	@Override
	public PlaytimeTime selectByKeyword(Long id) {
		// TODO Auto-generated method stub
		return timeMapper.selectByPrimaryKey(id);
	}

}
