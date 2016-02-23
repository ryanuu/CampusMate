package com.cemobile.framework.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dao.TermMapper;
import com.cemobile.framework.entity.Term;
import com.cemobile.framework.services.ITermService;

@Service
@Transactional
public class TermService implements ITermService {
	
	@Autowired
	private TermMapper termMapper;
	
	@Override
	public Page queryByKeyword(Term term,Page page){
			List<Term> resultList=termMapper.queryByKeyword(term,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllTerm(Page page) {
        List<Term> labTermList=termMapper.queryAllTerm(page);
        page.setResult(labTermList);
        return page;
    }
	
	@Override
	public Term selectByKeyword(Long id) {
		// TODO Auto-generated method stub
		return termMapper.selectByPrimaryKey(id);
	}


}
