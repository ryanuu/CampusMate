package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabCollege;
import com.cemobile.framework.dao.LabCollegeMapper;
import com.cemobile.framework.services.ILabCollegeService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabCollegeService implements ILabCollegeService{

	@Autowired
    private LabCollegeMapper labCollegeMapper;
	
	@Override
	public int insert(LabCollege labCollege){
		return labCollegeMapper.insert(labCollege);
	}
	@Override
	public int insertSelective(LabCollege labCollege){
		return labCollegeMapper.insertSelective(labCollege);
	}
	@Override
	public int insertBatch(List<LabCollege> labCollegeList){
		return labCollegeMapper.insertBatch(labCollegeList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long collegeId){
		return labCollegeMapper.deleteByPrimaryKey(collegeId);
	}
	
	@Override
	public LabCollege selectByPrimaryKey(java.lang.Long collegeId){
		return labCollegeMapper.selectByPrimaryKey(collegeId);
	}

	@Override
	public int updateByPrimaryKey(LabCollege labCollege){
		return labCollegeMapper.updateByPrimaryKey(labCollege);
	}
	@Override
	public int updateByPrimaryKeySelective(LabCollege labCollege){
			return labCollegeMapper.updateByPrimaryKeySelective(labCollege);
	}

	@Override
	public Page queryByKeyword(LabCollege labCollege,Page page){
			List<LabCollege> resultList=labCollegeMapper.queryByKeyword(labCollege,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabCollege(Page page) {
        List<LabCollege> labCollegeList=labCollegeMapper.queryAllLabCollege(page);
        page.setResult(labCollegeList);
        return page;
    }
}