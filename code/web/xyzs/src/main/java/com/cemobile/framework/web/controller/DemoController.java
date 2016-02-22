package com.cemobile.framework.web.controller;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cemobile.framework.base.common.AjaxData;
import com.cemobile.framework.base.common.AjaxDataComponent;
import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.Demo;
import com.cemobile.framework.services.IDemoService;
import com.cemobile.framework.web.view.View;
/**
 * @Title: DemoController.java
 * @Description: 报表展现DEMO控制层
 */
@Controller
@RequestMapping(value = "demo")
public class DemoController {
    // 逻辑错误日志
    private static Logger log = Logger.getLogger(DemoController.class);
    @Autowired
    private AjaxDataComponent ajaxDataComponent;
    @Autowired
    private IDemoService idemoService;

    /**
     * 跳转列表页面
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String demoList() {
        return View.DEMO.DEMOLIST;
    }

    /**
     * 跳转新增页面
     */
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String addDemo() {
        return View.DEMO.ADDDEMO;
    }

    /**
     * 跳转修改页面
     */
    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public String updateDemo(Long id, Model model) {
        Demo demo = idemoService.selectByPrimaryKey(id);
        model.addAttribute("demo", demo);
        return View.DEMO.UPDATEDEMO;
    }

    /**
     * 跳转查看页面
     */
    @RequestMapping(value = "/toSel", method = RequestMethod.GET)
    public String selectDemo(Long id, Model model) {
        Demo demo = idemoService.selectByPrimaryKey(id);
        model.addAttribute("demo", demo);
        return View.DEMO.DETAILDEMO;
    }
    
    /**
     * 跳转查看页面
     */
    @RequestMapping(value = "/toSearch", method = RequestMethod.GET)
    public String toSearch() {
        return View.DEMO.SEARCHDEMO;
    }
    
    /**
     * 条件查询列表数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxData query(@Valid Demo demo,
                   BindingResult result, Page page) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("i am a demo!");
	        idemoService.queryDemo(demo, page);
	        log.info("构造easyui需要的json数据！");
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }

    /**
     * 新增demo数据
     */
    @RequestMapping(value = "/submitDemo", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxData submitDemo(@Valid Demo demo,
                        BindingResult result, Page page) {
        log.info("新增demo数据!");
        if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
        try {
	        idemoService.submitDemo(demo);
			return ajaxDataComponent.createSuccess();
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1601");
		}
    }

    /**
     * 修改demo数据
     */
    @RequestMapping(value = "/updateDemo", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxData updateDemo(@Valid Demo demo,
                        BindingResult result, Page page) {
        log.info("修改demo数据!");
        if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
        try {
        	idemoService.updateDemo(demo);
			return ajaxDataComponent.createSuccess();
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1602");
		}
    }

    /**
     * 删除demo数据
     */
    @RequestMapping(value = "/deleteDemo", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxData deleteDemo(@Valid String id) {
        log.info("删除demo数据!");
        try {
        	idemoService.deleteDemo(Long.valueOf(id));
			return ajaxDataComponent.createSuccess();
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1603");
		}
    }

    
    
    
}
