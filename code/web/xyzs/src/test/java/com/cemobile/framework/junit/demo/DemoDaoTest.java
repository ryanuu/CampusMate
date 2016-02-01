package com.cemobile.framework.junit.demo;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cemobile.demo.dao.DemoMapper;
import com.cemobile.demo.entities.Demo;
import com.cemobile.framework.junit.base.BaseDaoTestCase;
import com.cemobile.framework.junit.base.BaseServicesTestCase;

public class DemoDaoTest extends BaseDaoTestCase {
	@Autowired
	private DemoMapper demoMapper;
	@Test
	public void insert(){
		Demo demo=new Demo();
		demo.setName("czp");
		demo.setType(1L);
		
		int i= demoMapper.insert(demo);
		System.out.println("影响的行数:"+i);
	}
	@Test
	public void query(){
		Demo demo=new Demo();
		List<Demo> demos= demoMapper.queryByKeyword(demo);
		for(Demo d:demos){
			System.out.println("id:"+d.getId()+",name:"+d.getName()+",type:"+d.getType());
			int i= demoMapper.deleteByPrimaryKey(d.getId());
			if(i>0)
			System.err.println("删除ID为："+d.getId());// 删除
		}
	}
}
