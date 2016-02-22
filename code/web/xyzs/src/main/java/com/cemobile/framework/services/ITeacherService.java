package com.cemobile.framework.services;

import com.cemobile.framework.entity.TeacherUser;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年2月22日下午3:11:17
 * 类说明：登录用户查询
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public interface ITeacherService {
	//根据id查询用户的所有信息（两表）
	public TeacherUser selectByPrimaryKey(Long id);
}
