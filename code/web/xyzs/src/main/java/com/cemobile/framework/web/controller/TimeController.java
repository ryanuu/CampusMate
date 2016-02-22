package com.cemobile.framework.web.controller;

import javax.servlet.http.HttpSession;
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
import com.cemobile.framework.base.entities.TsysUser;
import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.entity.LabTeacher;
import com.cemobile.framework.entity.LabTerm;
import com.cemobile.framework.entity.Term;
import com.cemobile.framework.services.ILabTeacherService;
import com.cemobile.framework.services.ILabTermService;
import com.cemobile.framework.services.ITermService;
import com.cemobile.framework.web.view.View;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月16日下午3:31:46
 * 类说明：时间设置模块（学期、上下课时间的设置）
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
@Controller
@RequestMapping(value = "admin/timeSeting")
public class TimeController {
	
	// 逻辑错误日志
    private static Logger log = Logger.getLogger(DemoController.class);
    @Autowired
    private AjaxDataComponent ajaxDataComponent;
    @Autowired
    private ITermService termService;
    @Autowired
    private ILabTeacherService labTeacherService;
    @Autowired
    private ILabTermService labTermService;
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日上午9:07:35
     * 方法说明：时间设置模块-学期列表页
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termView", method = RequestMethod.GET)
    public String termList(Model model,HttpSession session) {
    	TsysUser user = (TsysUser)session.getAttribute("TsysUser");
    	Term term=(Term) session.getAttribute("User");
		Long userId = user.getUserId();
		LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(userId);
        return View.Time.TERMLIST;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日上午9:09:59
     * 方法说明：时间设置模块-学期列表数据
     * 参数：@param demo
     * 参数：@param result
     * 参数：@param page
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termList", method = RequestMethod.POST)
    public @ResponseBody AjaxData query(@Valid Term term,
                   BindingResult result, Page page) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("学期列表数据!");
	        termService.queryByKeyword(term, page);
	        log.info("构造easyui需要的json数据！");
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月22日下午1:34:28
     * 方法说明：时间设置模块-添加学期
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termAddView", method = RequestMethod.GET)
    public String termAdd(Model model,HttpSession session) {
    	TsysUser user = (TsysUser)session.getAttribute("TsysUser");
		Long userId = user.getUserId();
		LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(userId);
        return View.Time.TERMADD;
    }
    
    @RequestMapping(value = "/termAdd", method = RequestMethod.POST)
    public @ResponseBody AjaxData termAdd(@Valid LabTerm labTerm,
                   BindingResult result, Page page) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("新增学期数据!");
	        labTermService.insert(labTerm);
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
}
