package com.cemobile.framework.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cemobile.framework.entity.AppUser;
import com.cemobile.framework.entity.Student;
import com.cemobile.framework.entity.Teacher;
import com.cemobile.framework.services.IStudentService;
import com.cemobile.framework.services.ITeacherService;
import com.cemobile.framework.terminal.common.TerminalCodeException;
import com.cemobile.framework.terminal.common.TerminalData;
import com.cemobile.framework.terminal.common.TerminalDataUtils;
import com.cemobile.framework.terminal.common.TerminalSession;
import com.cemobile.framework.terminal.common.TerminalSessionManager;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月25日上午9:24:31
 * 类说明：app接口控制层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
@Controller
@RequestMapping(value = "/api/teminal")
public class TerminalController {
	protected static Logger log = Logger.getLogger(TerminalController.class);
	@Autowired
	protected TerminalDataUtils terminalDataUtils;
	@Autowired
	protected TerminalSessionManager teminalSessionManager;
	
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/test")
	public @ResponseBody
	TerminalData userInfoModify(HttpServletRequest request, Long isE) {
		try {
			if (isE != null && isE == 1) {
				throw new TerminalCodeException("E3002");
			}
			if (isE != null && isE == 2) {
				throw new Exception();
			}
			return terminalDataUtils.createSuccess("hello world!");
		} catch (TerminalCodeException te) {
			log.warn(te.getMessage());
			return terminalDataUtils.createErrorCode(te);
		} catch (Exception e) {
			log.error("E3001", e);
			return terminalDataUtils.createErrorCode("E3001");
		}
	}

	@RequestMapping(value = "test/login")
	public @ResponseBody
	TerminalData weixinLogin(String username, String password) {
		try {
			if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
				throw new TerminalCodeException("E2010");
			}
			if (!username.equals(password)) {
				throw new Exception();
			}
		} catch (TerminalCodeException te) {
			log.warn(te.getMessage());
			return terminalDataUtils.createErrorCode(te);
		} catch (Exception e) {
			log.error("E2001", e);
			return terminalDataUtils.createErrorCode("E2001");
		}
		// 传话票据
		String ticket = null;
		try {

			Long userid = 1L;
			// 创建会话
			TerminalSession<String, Object> terminalSession = teminalSessionManager.createTeminalSession(userid);
			ticket = (String) terminalSession.get("ticket");
			if (StringUtils.isEmpty(ticket)) {
				return terminalDataUtils.createErrorCode("E2013");
			}
			// 缓存用户信息再会话对象
			// userInfo.setTicket(ticket);
			// terminalSession.put("userInfo", userInfo);

		} catch (Exception e) {
			log.error("E2012", e);
			return terminalDataUtils.createErrorCode("E2012");
		}
		return terminalDataUtils.createSuccess(ticket);
	}

	/**
	 * 
	 * 创建人：chenzx
	 * 创建时间：2016年2月25日下午3:52:48
	 * 方法说明：app接口-登录验证
	 * 参数：@param username
	 * 参数：@param password
	 * 参数：@param role
	 * 参数：@param os
	 * 参数：@return 无
	 * 修改人：无
	 * 修改时间：无
	 * 修改说明：无
	 */
	@RequestMapping(value = "/login")
	public @ResponseBody
	TerminalData appLogin(String username, String password,Long role,Long os) {
//		username="xyzs";
//		password="E10ADC3949BA59ABBE56E057F20F883E";
//		role=2l;
//		os=1l;
		try {
			if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || role==null || os==null) {
				throw new TerminalCodeException("E2010");
			}
			
		} catch (TerminalCodeException te) {
			log.warn(te.getMessage());
			return terminalDataUtils.createErrorCode(te);
		} catch (Exception e) {
			log.error("E2001", e);
			return terminalDataUtils.createErrorCode("E2001");
		}
		// 传话票据
		String ticket = null;
		//密码加密
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		//将密码用MD5加密，并将它转成大写的（用toUpperCase()方法）
		password=md5.encodePassword(password,null).toUpperCase();

		List<AppUser> list=new ArrayList<AppUser>();
		try {

			AppUser appUser=new AppUser();
			if(role==1){
				Student student=studentService.selectByPrimaryKey(username);
				if(student==null){
					return terminalDataUtils.createError("该用户不存在！");
				}
				if(!student.getPassword().equals(password)){
					return terminalDataUtils.createError("密码不正确！");
				}
				appUser.setUserId(student.getStudentId());
				appUser.setRole(role);
				appUser.setClassId(student.getClassId());
			}
			else{
				Teacher teacher=teacherService.selectByPrimaryName(username);
				if(teacher==null){
					return terminalDataUtils.createError("该用户不存在！");
				}
				if(!teacher.getPassword().equals(password)){
					return terminalDataUtils.createError("密码不正确！");
				}
				appUser.setUserId(teacher.getTeacherId());
				appUser.setCollegeId(teacher.getCollegeId());
				appUser.setDepartmentId(teacher.getDepartmentId());
				appUser.setRole(role);
			}
			
			// 创建会话
			TerminalSession<String, Object> terminalSession = teminalSessionManager.createTeminalSession(appUser.getUserId());
			ticket = (String) terminalSession.get("ticket");
			appUser.setTicket(ticket);
			if (StringUtils.isEmpty(ticket)) {
				return terminalDataUtils.createErrorCode("E2013");
			}
			
			list.add(appUser);
			
		} catch (Exception e) {
			log.error("E2012", e);
			return terminalDataUtils.createErrorCode("E2012");
		}
		
		return terminalDataUtils.createSuccess(list, 1);
	}

}
