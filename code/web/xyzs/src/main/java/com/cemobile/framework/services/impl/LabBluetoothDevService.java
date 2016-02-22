package com.cemobile.framework.services.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cemobile.framework.entity.LabBluetoothDev;
import com.cemobile.framework.dao.LabBluetoothDevMapper;
import com.cemobile.framework.services.ILabBluetoothDevService;
import com.cemobile.framework.common.page.Page;

@Service
@Transactional
public class LabBluetoothDevService implements ILabBluetoothDevService{

	@Autowired
    private LabBluetoothDevMapper labBluetoothDevMapper;
	
	@Override
	public int insert(LabBluetoothDev labBluetoothDev){
		return labBluetoothDevMapper.insert(labBluetoothDev);
	}
	@Override
	public int insertSelective(LabBluetoothDev labBluetoothDev){
		return labBluetoothDevMapper.insertSelective(labBluetoothDev);
	}
	@Override
	public int insertBatch(List<LabBluetoothDev> labBluetoothDevList){
		return labBluetoothDevMapper.insertBatch(labBluetoothDevList);
	}

	@Override
	public int deleteByPrimaryKey(java.lang.Long devId){
		return labBluetoothDevMapper.deleteByPrimaryKey(devId);
	}
	
	@Override
	public LabBluetoothDev selectByPrimaryKey(java.lang.Long devId){
		return labBluetoothDevMapper.selectByPrimaryKey(devId);
	}

	@Override
	public int updateByPrimaryKey(LabBluetoothDev labBluetoothDev){
		return labBluetoothDevMapper.updateByPrimaryKey(labBluetoothDev);
	}
	@Override
	public int updateByPrimaryKeySelective(LabBluetoothDev labBluetoothDev){
			return labBluetoothDevMapper.updateByPrimaryKeySelective(labBluetoothDev);
	}

	@Override
	public Page queryByKeyword(LabBluetoothDev labBluetoothDev,Page page){
			List<LabBluetoothDev> resultList=labBluetoothDevMapper.queryByKeyword(labBluetoothDev,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllLabBluetoothDev(Page page) {
        List<LabBluetoothDev> labBluetoothDevList=labBluetoothDevMapper.queryAllLabBluetoothDev(page);
        page.setResult(labBluetoothDevList);
        return page;
    }
}