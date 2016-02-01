package com.cemobile.framework.junit.demo;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cemobile.demo.entities.Demo;
import com.cemobile.demo.services.IDemoService;
import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.junit.base.BaseServicesTestCase;

public class DemoServicesTest extends BaseServicesTestCase{
    @Autowired
    private IDemoService iDemoService;
	@Test
	public void insert(){
		Demo demo=new Demo();
		demo.setName("czp");
		demo.setType(1L);
		int i=iDemoService.submitDemo(demo);
		System.out.println("影响的行数:"+i);
	}
	@Test
	public void query() {
		Demo demo = new Demo();
		Page page = new Page();
		iDemoService.queryDemo(demo, page);

		page.getTotal();
		System.out.println("total:" + page.getTotal());

		List<Demo> demos = page.getResult();
		for(Demo d:demos){
			System.out.println("id:"+d.getId()+",name:"+d.getName()+",type:"+d.getType());
			int i= iDemoService.deleteDemo(d.getId());
			if(i>0)
			System.err.println("删除ID为："+d.getId());// 删除
		}
	}
}
