package com.cemobile.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.demo.dao.DemoMapper;
import com.cemobile.demo.entities.Demo;
import com.cemobile.demo.services.IDemoService;
import com.cemobile.framework.common.page.Page;
@Service
@Transactional
public class DemoServiceImpl implements IDemoService{
	@Autowired
	private DemoMapper idemoMapper;
	@Override
	public Page queryDemo(Demo demo, Page page) {
		List<Demo> resultList = idemoMapper.queryByKeyword(demo, page);
		page.setResult(resultList);
		return page;
	}
	@Override
	public int submitDemo(Demo demo) {
		return idemoMapper.insert(demo);
	}
	@Override
	public int updateDemo(Demo demo) {
		return idemoMapper.updateByPrimaryKey(demo);
	}
	@Override
	public int deleteDemo(Long id) {
		return idemoMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Demo selectByPrimaryKey(Long id) {
		return idemoMapper.selectByPrimaryKey(id);
	}
	
}
