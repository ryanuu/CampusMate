package com.cemobile.framework.dao;

import java.util.List;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabBluetoothDev;

public interface LabBluetoothDevMapper{

	int insert(LabBluetoothDev labBluetoothDev);

	int insertSelective(LabBluetoothDev labBluetoothDev);

	int insertBatch(List<LabBluetoothDev> labBluetoothDevList);

	int deleteByPrimaryKey(java.lang.Long devId);

	LabBluetoothDev selectByPrimaryKey(java.lang.Long devId);

	int updateByPrimaryKey(LabBluetoothDev labBluetoothDev);

	int updateByPrimaryKeySelective(LabBluetoothDev labBluetoothDev);
	
	List<LabBluetoothDev> queryByKeyword(LabBluetoothDev labBluetoothDev,Page page);

	List<LabBluetoothDev> queryByKeyword(LabBluetoothDev labBluetoothDev);

	List<LabBluetoothDev> queryAllLabBluetoothDev(Page page);
}
