package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.PlaytimeTime;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月23日下午3:04:04
 * 类说明：时间表Dao层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface TimeMapper {

	PlaytimeTime selectByPrimaryKey(java.lang.Long id);
	
	List<PlaytimeTime> queryByKeyword(PlaytimeTime time,Page page);

	List<PlaytimeTime> queryByKeyword(PlaytimeTime time);

	List<PlaytimeTime> queryAllTerm(Page page);
	
}
