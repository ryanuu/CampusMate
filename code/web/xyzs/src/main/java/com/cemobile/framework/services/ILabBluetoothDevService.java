package com.cemobile.framework.services;

import java.util.List;

import com.cemobile.framework.entity.LabBluetoothDev;
import com.cemobile.framework.common.page.Page;

public interface ILabBluetoothDevService{
	
	public int insert(LabBluetoothDev labBluetoothDev);
	public int insertSelective(LabBluetoothDev labBluetoothDev);
	
	public int insertBatch(List<LabBluetoothDev> labBluetoothDevList);

	public int deleteByPrimaryKey(java.lang.Long devId);

	public LabBluetoothDev selectByPrimaryKey(java.lang.Long devId);

	public int updateByPrimaryKey(LabBluetoothDev labBluetoothDev);

	public int updateByPrimaryKeySelective(LabBluetoothDev labBluetoothDev);

	public Page queryByKeyword(LabBluetoothDev labBluetoothDev,Page page);

	public Page queryAllLabBluetoothDev(Page page);
}