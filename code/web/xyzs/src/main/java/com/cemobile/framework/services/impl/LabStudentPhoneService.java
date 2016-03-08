package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabStudentPhone;
import com.cemobile.framework.dao.LabStudentPhoneMapper;
import com.cemobile.framework.services.ILabStudentPhoneService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabStudentPhoneService implements ILabStudentPhoneService{

	@Autowired
    private LabStudentPhoneMapper labStudentPhoneMapper;
	
	@Override
	public int insert(LabStudentPhone labStudentPhone){
		return labStudentPhoneMapper.insert(labStudentPhone);
	}
	@Override
	public int insertSelective(LabStudentPhone labStudentPhone){
		return labStudentPhoneMapper.insertSelective(labStudentPhone);
	}
	@Override
	public int insertBatch(List<LabStudentPhone> labStudentPhoneList){
		return labStudentPhoneMapper.insertBatch(labStudentPhoneList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long macId){
		return labStudentPhoneMapper.deleteByPrimaryKey(macId);
	}
	
	@Override
	public LabStudentPhone selectByPrimaryKey(java.lang.Long macId){
		return labStudentPhoneMapper.selectByPrimaryKey(macId);
	}

	@Override
	public int updateByPrimaryKey(LabStudentPhone labStudentPhone){
		return labStudentPhoneMapper.updateByPrimaryKey(labStudentPhone);
	}
	@Override
	public int updateByPrimaryKeySelective(LabStudentPhone labStudentPhone){
			return labStudentPhoneMapper.updateByPrimaryKeySelective(labStudentPhone);
	}

	@Override
	public Page queryByKeyword(LabStudentPhone labStudentPhone,Page page){
			List<LabStudentPhone> resultList=labStudentPhoneMapper.queryByKeyword(labStudentPhone,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabStudentPhone(Page page) {
        List<LabStudentPhone> labStudentPhoneList=labStudentPhoneMapper.queryAllLabStudentPhone(page);
        page.setResult(labStudentPhoneList);
        return page;
    }
}