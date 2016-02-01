package com.cemobile.demo.dao;

import java.util.List;

import com.cemobile.demo.entities.Demo;
import com.cemobile.framework.common.page.Page;

public interface DemoMapper{

	int insert(Demo demo);

	int insertSelective(Demo demo);

	int insertBatch(List<Demo> demoList);

	int deleteByPrimaryKey(Long id);

	Demo selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Demo demo);

	int updateByPrimaryKeySelective(Demo demo);
	
	List<Demo> queryByKeyword(Demo demo,Page page);

	List<Demo> queryByKeyword(Demo demo);

	List<Demo> queryAllDemo(Page page);
}
