package com.cemobile.framework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.cemobile.framework.base.entities.TsysUser;
import com.cemobile.framework.base.services.ILoginRecodeService;
import com.cemobile.framework.entity.TeacherUser;
import com.cemobile.framework.services.ITeacherService;
import com.mysql.jdbc.StringUtils;

@Component
public class MyAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
	public MyAuthenticationSuccessHandler(){
		setDefaultTargetUrl("/admin");
		setTargetUrlParameter("jumpUrl");
	}
	
	
	@Autowired
	ILoginRecodeService loginRecodeService;
	@Autowired
	ITeacherService teacherService;
	/**
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 * @Adder by ChenDewei 2013-3-13 下午5:14:56
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String username = authentication.getName();
		if(!StringUtils.isNullOrEmpty(username)){
			loginRecodeService.clearLoginFailRecode(username);
			request.getSession().removeAttribute("isVerificationCode");
		}
		//添加自定义的登录用户信息
		TsysUser tsysUser=(TsysUser) request.getSession().getAttribute("TsysUser");
		TeacherUser teacherUser=teacherService.selectByPrimaryKey(tsysUser.getUserId());
		request.getSession().setAttribute("TeacherUser", teacherUser);
		
		super.onAuthenticationSuccess(request, response, authentication);
		
	}
}
