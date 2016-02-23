package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTerm;
import com.cemobile.framework.entity.Term;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月22日上午9:58:08
 * 类说明：学期表Dao层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface TermMapper {

	Term selectByPrimaryKey(java.lang.Long termId);
	
	List<Term> queryByKeyword(Term term,Page page);

	List<Term> queryByKeyword(Term term);

	List<Term> queryAllTerm(Page page);
	
}
