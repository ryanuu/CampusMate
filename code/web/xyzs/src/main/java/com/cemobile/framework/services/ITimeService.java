package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTime;
import com.cemobile.framework.entity.PlaytimeTime;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月23日下午2:44:25
 * 类说明：时间表服务层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface ITimeService {
	
	public Page queryByKeyword(PlaytimeTime time,Page page);

	public Page queryAllTerm(Page page);
	
	public PlaytimeTime selectByKeyword(Long id);
	
	//app查询本学期上下课时间
	public List<LabTime> queryByKeywordTime(LabTime labTime);
}
