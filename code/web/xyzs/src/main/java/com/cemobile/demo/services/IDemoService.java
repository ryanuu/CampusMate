package com.cemobile.demo.services;

import com.cemobile.demo.entities.Demo;
import com.cemobile.framework.common.page.Page;

public interface IDemoService {
	/*条件查询demo*/
	public Page queryDemo(Demo demo,Page page);
	/*新增demo数据*/
	public int submitDemo(Demo demo);
	/*修改demo数据*/
	public int updateDemo(Demo demo);
	/*删除demo数据*/
	public int deleteDemo(Long id);
	/*根据id，查询demo数据*/
	public Demo selectByPrimaryKey(Long id);
}
