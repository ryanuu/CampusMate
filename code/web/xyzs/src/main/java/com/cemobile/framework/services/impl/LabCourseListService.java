package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabCourseList;
import com.cemobile.framework.dao.LabCourseListMapper;
import com.cemobile.framework.services.ILabCourseListService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabCourseListService implements ILabCourseListService{

	@Autowired
    private LabCourseListMapper labCourseListMapper;
	
	@Override
	public int insert(LabCourseList labCourseList){
		return labCourseListMapper.insert(labCourseList);
	}
	@Override
	public int insertSelective(LabCourseList labCourseList){
		return labCourseListMapper.insertSelective(labCourseList);
	}
	@Override
	public int insertBatch(List<LabCourseList> labCourseListList){
		return labCourseListMapper.insertBatch(labCourseListList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long courseListId){
		return labCourseListMapper.deleteByPrimaryKey(courseListId);
	}
	
	@Override
	public LabCourseList selectByPrimaryKey(java.lang.Long courseListId){
		return labCourseListMapper.selectByPrimaryKey(courseListId);
	}

	@Override
	public int updateByPrimaryKey(LabCourseList labCourseList){
		return labCourseListMapper.updateByPrimaryKey(labCourseList);
	}
	@Override
	public int updateByPrimaryKeySelective(LabCourseList labCourseList){
			return labCourseListMapper.updateByPrimaryKeySelective(labCourseList);
	}

	@Override
	public Page queryByKeyword(LabCourseList labCourseList,Page page){
			List<LabCourseList> resultList=labCourseListMapper.queryByKeyword(labCourseList,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabCourseList(Page page) {
        List<LabCourseList> labCourseListList=labCourseListMapper.queryAllLabCourseList(page);
        page.setResult(labCourseListList);
        return page;
    }
}