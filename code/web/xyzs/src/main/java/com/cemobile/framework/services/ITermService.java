package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTerm;
import com.cemobile.framework.entity.Term;
import com.cemobile.framework.entity.Week;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月22日上午9:47:51
 * 类说明：学期表服务层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface ITermService {
	public Page queryByKeyword(Term term,Page page);

	public Page queryAllTerm(Page page);
	
	public Term selectByKeyword(Long id);
	
	//通过学院ID查询整个学期的周
	public List<Week> selectWeek(Long collegeId);
}
