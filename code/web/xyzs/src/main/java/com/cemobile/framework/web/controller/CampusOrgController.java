package com.cemobile.framework.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cemobile.framework.base.common.AjaxData;
import com.cemobile.framework.base.common.AjaxDataComponent;
import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dict.common.utils.DictCacheUtil;
import com.cemobile.framework.dict.entities.Dict;
import com.cemobile.framework.entity.LabTeacher;
import com.cemobile.framework.entity.Org;
import com.cemobile.framework.entity.Orgtree;
import com.cemobile.framework.entity.TeacherUser;
import com.cemobile.framework.services.ILabTeacherService;
import com.cemobile.framework.services.IOrgsService;
import com.cemobile.framework.web.view.View;


/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月22日上午9:10:02
 * 类说明：web-组织机构管理
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
@Controller
@RequestMapping("/admin/campusOrg")
public class CampusOrgController {

	// 逻辑错误日志
    private static Logger log = Logger.getLogger(CampusOrgController.class);
    @Autowired
    private AjaxDataComponent ajaxDataComponent;
    @Autowired
    private ILabTeacherService labTeacherService;
    @Autowired
    private IOrgsService orgService;
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日上午9:57:39
     * 方法说明：组织机构管理-跳转组织列表页面
     * 参数：@param model
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toList(Model model,HttpSession session) {
    	TeacherUser user = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = user.getUserId();
		LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(userId);
		Long orgId=0l;
		if(labTeacher!=null)
		{
			orgId=labTeacher.getDepartmentId();
		}
		
		model.addAttribute("_orgId", orgId);
		return View.ORG.LIST;
	}
	
	/**
	 * 
	 * 创建人：chenzx
	 * 创建时间：2016年2月17日 09:55:52
	 * 方法说明：组织机构管理-跳转添加组织页面
	 * 参数：@param model
	 * 参数：@param parentId
	 * 参数：@param orgLevel
	 * 参数：@return String
	 * 修改人：无
	 * 修改时间：无
	 * 修改说明：无
	 */
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public String toAdd(Model model, String parentId, Integer orgLevel) {
		model.addAttribute("parentId", parentId);
		model.addAttribute("orgLevel", ++orgLevel);
		return View.ORG.ADD;
	}
	
	/**
	 * 
	 * 创建人：chenzx
	 * 创建时间：2016年2月17日 09:55:52
	 * 方法说明：组织机构管理-从字典表查询角色等级 添加机构时查询父机构的角色等级，新添加、修改的角色等级 <= 父机构的角色等级
	 * 参数：@param model
	 * 参数：@param itemValue 无
	 * 修改人：无
	 * 修改时间：无
	 * 修改说明：无
	 */
	public void putModel(Model model, Long itemValue) {
		List<Dict> roleLevels = DictCacheUtil.getItemsByDictCode("DICT_ROLE_LEVELS");
		for (int i = 0; i < roleLevels.size(); i++) {
		    //获取记录的ITEM_VALUE
			String a = roleLevels.get(i).getDictValue();
			if (Long.parseLong(a) < itemValue) {
				roleLevels.remove(i);
				i--;
			}
		}
		model.addAttribute("roleLevels", roleLevels);
	}
	
	/**
	 * 
	 * 创建人：chenzx
	 * 创建时间：2016年2月17日 09:55:52
	 * 方法说明：组织机构管理-跳转编辑组织页面
	 * 参数：@param orgId
	 * 参数：@param model
	 * 参数：@param session
	 * 参数：@return String
	 * 修改人：无
	 * 修改时间：无
	 * 修改说明：无
	 */
	@RequestMapping(value = "/toEdit", method = RequestMethod.GET)
	public String toEdit(String orgId,String level, Model model,HttpSession session) {
		TeacherUser sysUser = (TeacherUser)session.getAttribute("TeacherUser");
		
		Orgtree orgtree=new Orgtree();
		orgtree.setId(orgId);
		orgtree.setLevel(level);
		List<Object> list=orgService.treeBygId(orgtree);
		
        model.addAttribute("org", list.get(0));
		return View.ORG.EDIT;
	}
	
	
    
    /**
     * 
     * 创建人：chenzx
     * 创建时间：2016年2月17日 09:55:52
     * 方法说明：组织机构管理-tree结构组织
     * 参数：@param orgtree
     * 参数：@param org
     * 参数：@param session
     * 参数：@return 无
     * 修改人：无
     * 修改时间：无
     * 修改说明：无
     */
	@RequestMapping(value = "/treelist", method = RequestMethod.POST)
	public @ResponseBody AjaxData treelist(@Valid Orgtree orgtree, Org org, HttpSession session) {
		//获取当前登录的用户
		TeacherUser tsysUser = (TeacherUser)session.getAttribute("TeacherUser");
		Long userId = tsysUser.getTeacherId();
		
		if (org.getDepartmentId()== null) {
			LabTeacher labTeacher=labTeacherService.selectByPrimaryKey(userId);
			if(labTeacher!=null)
			{
				org.setCollegeId(labTeacher.getCollegeId());
				org.setDepartmentId(labTeacher.getDepartmentId());
			}
			//判断是否为超级管理员
			if ("admin".equals(tsysUser.getUsername())) {
				//若是admin将orgId设为0
				org.setCollegeId(0l);
			}
		}
		
		try {
			List<Orgtree> orglist=orgService.treelist(org);
			return ajaxDataComponent.createSuccess(orglist);
		} catch (Exception e) {
			log.error("E1501",e);
			return ajaxDataComponent.createErrorCode("E1501");
		}
	}
	
	/**
	 * 
	 * 创建人：chenzx
	 * 创建时间：2016年2月17日 09:55:52
	 * 方法说明：组织机构管理-根据orgId，查询组织
	 * 参数：@param org
	 * 参数：@param session
	 * 参数：@param page
	 * 参数：@return AjaxData
	 * 修改人：无
	 * 修改时间：无
	 * 修改说明：无
	 */
	@RequestMapping(value = "/treeBygId", method = RequestMethod.POST)
	public @ResponseBody AjaxData treeBygId(@Valid Orgtree org,HttpSession session,Page page) {
		try {
		    //如果前端传递的组织机构id是null，那么就从session中获取用户的userId，使用这个userId获取组织机构Id
			if (org.getId()== null) {
				TeacherUser tsysUser = (TeacherUser)session.getAttribute("TeacherUser");
				Long userId = tsysUser.getUserId();
				
				org.setId(tsysUser.getCollegeId().toString());
				org.setLevel("college");
			}
			
			
			//通过组织机构Id获取组织机构树
			List<Object> list=orgService.treeBygId(org);
			
			List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("orgObj", list);
			result.add(m);
			return ajaxDataComponent.createSuccess(result,1);
		} catch (Exception e) {
			log.error(e);
			return ajaxDataComponent.createErrorCode("E1501");
		}
	}
	
}
