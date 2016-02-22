package com.campusmate.commondata;

public class CommonData {

	//模拟后台网址
	public static String HttpUrl="http://192.168.0.202:8085/" +
			"InterfaceSimulator/Controller/RequestInterfaceController.java";
	//成功返回数据code
	public static String Code_Success="S1000";
	//返回数据失败code
	public static String Code_Failure="";
	//sharepreference的用户信息的表名
	public static String UserInfo="userInfo";
	//sharepreference的登录信息的表名
	public static String LoginInfo="LoginInfo";
	//登录账号字段名
	public static String LoginAccount="LoginAccount";
	//登录密码字段名
	public static String LoginPassword="LoginPassword";
	//登录状态字段 ：是否保存密码,是否自动登陆，1为自动登陆，2为记住密码，0为空
	public static String LoginState="LoginState";
	//登录角色字段
	public static String LoginRole="LoginRole";
	
}
