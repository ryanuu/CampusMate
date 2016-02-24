package com.cemobile.framework.web.controller;

import java.util.Date;

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
import com.cemobile.framework.entity.LabTime;
import com.cemobile.framework.entity.PlaytimeTime;
import com.cemobile.framework.entity.TeacherUser;
import com.cemobile.framework.entity.Term;
import com.cemobile.framework.services.ILabTeacherService;
import com.cemobile.framework.services.ILabTermService;
import com.cemobile.framework.services.ILabTimeService;
import com.cemobile.framework.services.ITermService;
import com.cemobile.framework.services.ITimeService;
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
    private static Logger log = Logger.getLogger(TimeController.class);
    @Autowired
    private AjaxDataComponent ajaxDataComponent;
    @Autowired
    private ITermService termService;
    @Autowired
    private ILabTeacherService labTeacherService;
    @Autowired
    private ILabTermService labTermService;
    @Autowired
    private ILabTimeService labTimeService;
    @Autowired
    private ITimeService timeService;
    
    
    /*************************************************学期时间***************************************************************/
    
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
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
    	
		LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(user.getTeacherId());
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
     * 方法说明：时间设置模块-新增学期页面
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termAddView", method = RequestMethod.GET)
    public String termAdd(Model model,HttpSession session) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
        return View.Time.TERMADD;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日上午9:51:29
     * 方法说明：时间设置模块-新增学期数据
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termAdd", method = RequestMethod.POST)
    public @ResponseBody AjaxData termAdd(@Valid LabTerm labTerm,
                   BindingResult result, Page page,HttpSession session) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("新增学期数据!");
	        TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
	        labTerm.setCollegeId(user.getCollegeId());
	        labTermService.insert(labTerm);
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日上午9:53:23
     * 方法说明：时间设置模块-编辑学期页面
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termUpdateView", method = RequestMethod.GET)
    public String termUpdate(Model model,HttpSession session,Long id) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
		Term term=termService.selectByKeyword(id);
		model.addAttribute("term", term);
        return View.Time.UPDATTERM;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日上午9:51:29
     * 方法说明：时间设置模块-编辑学期
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termUpdate", method = RequestMethod.POST)
    public @ResponseBody AjaxData termUpdate(@Valid LabTerm labTerm,
                   BindingResult result, Page page,HttpSession session) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("编辑学期数据!");
	        labTermService.updateByPrimaryKeySelective(labTerm);
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日下午1:29:21
     * 方法说明：时间设置模块-删除学期数据（伪删除）
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termDel", method = RequestMethod.POST)
    public @ResponseBody AjaxData termDel(@Valid String id,HttpSession session) {

    	try {
	        log.info("删除学期数据!");
	        LabTerm labTerm=new LabTerm();
	        labTerm.setTermId(Long.valueOf(id));
	        labTerm.setDel(1);
	        //伪删除
	        int a=labTermService.updateByPrimaryKeySelective(labTerm);
	        
			return ajaxDataComponent.createSuccess(a);
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日下午2:17:10
     * 方法说明：时间设置模块-学期详情
     * 参数：@param model
     * 参数：@param session
     * 参数：@param id
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/termSearch", method = RequestMethod.GET)
    public String termSearch(Model model,HttpSession session,Long id) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
		Term term=termService.selectByKeyword(id);
		model.addAttribute("term", term);
        return View.Time.SEARCHTERM;
    }
    
    /*************************************************课间时间***************************************************************/
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日上午9:07:35
     * 方法说明：时间设置模块-课间列表页
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeView", method = RequestMethod.GET)
    public String timeList(Model model,HttpSession session,Long termId) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
    	
		LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(user.getTeacherId());
		
		model.addAttribute("termId", termId);
		
        return View.Time.TIMELIST;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日上午9:09:59
     * 方法说明：时间设置模块-课间列表数据
     * 参数：@param demo
     * 参数：@param result
     * 参数：@param page
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeList", method = RequestMethod.POST)
    public @ResponseBody AjaxData querytime(@Valid PlaytimeTime playtimeTime,
                   BindingResult result, Page page) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {

	        log.info("课间列表数据!");
	        timeService.queryByKeyword(playtimeTime, page);
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
     * 创建时间：2016年2月23日 16:31:27
     * 方法说明：时间设置模块-新增课间页面
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeAddView", method = RequestMethod.GET)
    public String timeAdd(Model model,HttpSession session,Long termId) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
		model.addAttribute("termId", termId);
        return View.Time.TIMEADD;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日 16:31:17
     * 方法说明：时间设置模块-新增课间数据
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeAdd", method = RequestMethod.POST)
    public @ResponseBody AjaxData timeAdd(@Valid PlaytimeTime labTime,
                   BindingResult result, Page page,HttpSession session) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("新增课间数据!");
	        TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
	        labTime.setCollegeId(user.getCollegeId());
	        
	        //判断是否已存在节课，如果存在就不允许重复添加
	        PlaytimeTime playTime=new PlaytimeTime();
	        playTime.setSection(labTime.getSection());
	        playTime.setCollegeId(labTime.getCollegeId());
	        playTime.setTermId(labTime.getTermId());
	        page=timeService.queryByKeyword(playTime, page);
	        int count=page.getResult().size();
	        if(count>0){
	        	return ajaxDataComponent.createError("该节课已存在！");
	        }
	        else{
	        	labTimeService.insert(labTime);
				return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
	        }
	        
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日 16:31:05
     * 方法说明：时间设置模块-编辑课间页面
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeUpdateView", method = RequestMethod.GET)
    public String timeUpdate(Model model,HttpSession session,Long id) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
		PlaytimeTime time=timeService.selectByKeyword(id);
		model.addAttribute("time", time);
        return View.Time.UPDATTIME;
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日 16:30:52
     * 方法说明：时间设置模块-编辑课间
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeUpdate", method = RequestMethod.POST)
    public @ResponseBody AjaxData timeUpdate(@Valid LabTime labTime,
                   BindingResult result, Page page,HttpSession session) {
    	if (result.getErrorCount() > 0) {
			return ajaxDataComponent.createError(result);
		}
    	try {
	        log.info("编辑课间数据!");
	        labTimeService.updateByPrimaryKeySelective(labTime);
			return ajaxDataComponent.createSuccess(page.getResult(),page.getTotal());
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日 16:30:42
     * 方法说明：时间设置模块-删除课间数据（伪删除）
     * 参数：@param labTerm
     * 参数：@param result
     * 参数：@param page
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeDel", method = RequestMethod.POST)
    public @ResponseBody AjaxData timeDel(@Valid String id,HttpSession session) {

    	try {
	        log.info("删除课间数据!");
	        LabTime labTime=new LabTime();
	        labTime.setId(Long.valueOf(id));
	        labTime.setDel(1);
	        //伪删除
	        int a=labTimeService.updateByPrimaryKeySelective(labTime);
	        
			return ajaxDataComponent.createSuccess(a);
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1600");
		}
    }
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月23日 16:30:20
     * 方法说明：时间设置模块-课间详情
     * 参数：@param model
     * 参数：@param session
     * 参数：@param id
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/timeSearch", method = RequestMethod.GET)
    public String timeSearch(Model model,HttpSession session,Long id) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getTeacherId();
		PlaytimeTime time=timeService.selectByKeyword(id);
		model.addAttribute("time", time);
        return View.Time.SEARCHTIME;
    }
}
