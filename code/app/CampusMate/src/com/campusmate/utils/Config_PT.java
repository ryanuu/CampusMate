package com.campusmate.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.widget.Toast;

public class Config_PT {
	private static String UserType="1";
	private static String UserID="1";
	private static String LawerID="2";
	/**
	 * @return the userID
	 */
	public static String getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public static void setUserID(String userID) {
		UserID = userID;
	}
	/**
	 * @return the lawerID
	 */
	public static String getLawerID() {
		return LawerID;
	}
	/**
	 * @param lawerID the lawerID to set
	 */
	public static void setLawerID(String lawerID) {
		LawerID = lawerID;
	}
	/** 
     *  
     * @param mContext 上下文，来区别哪一个activity调用的 
     * @param whichSp 使用的SharedPreferences的名字 
     * @param field SharedPreferences的哪一个字段 
     * @return 
     */  
    //取出whichSp中field字段对应的string类型的值  
    public static String getSharePreStr(Context mContext,String whichSp,String field){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, Activity.MODE_PRIVATE);  
        String s=sp.getString(field,"");//如果该字段没对应值，则取出字符串0  
        return s;  
    }  
    /**
	 * @return the userType
	 */
	public static String getUserType() {
		return UserType;
	}
	/**
	 * @param userType the userType to set
	 */
	public static void setUserType(String userType) {
		UserType = userType;
	}
	//取出whichSp中field字段对应的int类型的值  
    public static int getSharePreInt(Context mContext,String whichSp,String field){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        int i=sp.getInt(field,0);//如果该字段没对应值，则取出0  
        return i;  
    }  
    //保存string类型的value到whichSp中的field字段  
    public static void putSharePre(Context mContext,String whichSp,String field,String value){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        sp.edit().putString(field, value).commit();  
    }  
    //保存int类型的value到whichSp中的field字段  
    public static void putSharePre(Context mContext,String whichSp,String field,int value){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        sp.edit().putInt(field, value).commit();  
    }

	public static void showToast(Context mContext,String msg){
		    Toast toast=new Toast(mContext);  
	        toast=Toast.makeText(mContext,msg, 300);  
	        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);//设置居中  
	        toast.show();
	}
}
