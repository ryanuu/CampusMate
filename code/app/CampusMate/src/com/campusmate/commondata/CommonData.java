package com.campusmate.commondata;

public class CommonData {

	//模拟后台网址
	public static String HttpUrl="http://192.168.0.202:8085/" +
			"InterfaceSimulator/Controller/RequestInterfaceController.java";
	//志星地址
//	public static String HttpUrl="http://192.168.0.21:8080/xyzs/api/teminal/";
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
	//一学期共有几周(默认1周，便于调试)
	public static int WEEKNUN=1;
	//一天的时间戳
	public static Long ONE_DAY=24*60*60*1000L;
	//当前时间戳
    public static Long CURRENT_DAY=0L;
    //当前周几
    public static String WEEKDAY;
	
}
