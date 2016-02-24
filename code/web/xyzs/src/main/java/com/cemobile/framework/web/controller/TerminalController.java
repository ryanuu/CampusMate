package com.cemobile.framework.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cemobile.framework.terminal.common.TerminalCodeException;
import com.cemobile.framework.terminal.common.TerminalData;
import com.cemobile.framework.terminal.common.TerminalDataUtils;
import com.cemobile.framework.terminal.common.TerminalSession;
import com.cemobile.framework.terminal.common.TerminalSessionManager;

@Controller
@RequestMapping(value = "/api/v1")
public class TerminalController {
	protected static Logger log = Logger.getLogger(TerminalController.class);
	@Autowired
	protected TerminalDataUtils terminalDataUtils;
	@Autowired
	protected TerminalSessionManager teminalSessionManager;

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

}
