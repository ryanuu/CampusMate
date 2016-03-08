package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabModifyCourse;
import com.cemobile.framework.dao.LabModifyCourseMapper;
import com.cemobile.framework.services.ILabModifyCourseService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabModifyCourseService implements ILabModifyCourseService{

	@Autowired
    private LabModifyCourseMapper labModifyCourseMapper;
	
	@Override
	public int insert(LabModifyCourse labModifyCourse){
		return labModifyCourseMapper.insert(labModifyCourse);
	}
	@Override
	public int insertSelective(LabModifyCourse labModifyCourse){
		return labModifyCourseMapper.insertSelective(labModifyCourse);
	}
	@Override
	public int insertBatch(List<LabModifyCourse> labModifyCourseList){
		return labModifyCourseMapper.insertBatch(labModifyCourseList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long modifyId){
		return labModifyCourseMapper.deleteByPrimaryKey(modifyId);
	}
	
	@Override
	public LabModifyCourse selectByPrimaryKey(java.lang.Long modifyId){
		return labModifyCourseMapper.selectByPrimaryKey(modifyId);
	}

	@Override
	public int updateByPrimaryKey(LabModifyCourse labModifyCourse){
		return labModifyCourseMapper.updateByPrimaryKey(labModifyCourse);
	}
	@Override
	public int updateByPrimaryKeySelective(LabModifyCourse labModifyCourse){
			return labModifyCourseMapper.updateByPrimaryKeySelective(labModifyCourse);
	}

	@Override
	public Page queryByKeyword(LabModifyCourse labModifyCourse,Page page){
			List<LabModifyCourse> resultList=labModifyCourseMapper.queryByKeyword(labModifyCourse,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabModifyCourse(Page page) {
        List<LabModifyCourse> labModifyCourseList=labModifyCourseMapper.queryAllLabModifyCourse(page);
        page.setResult(labModifyCourseList);
        return page;
    }
}