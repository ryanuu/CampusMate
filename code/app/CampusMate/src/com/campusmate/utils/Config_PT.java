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
     * @param mContext �����ģ���������һ��activity���õ� 
     * @param whichSp ʹ�õ�SharedPreferences������ 
     * @param field SharedPreferences����һ���ֶ� 
     * @return 
     */  
    //ȡ��whichSp��field�ֶζ�Ӧ��string���͵�ֵ  
    public static String getSharePreStr(Context mContext,String whichSp,String field){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, Activity.MODE_PRIVATE);  
        String s=sp.getString(field,"");//������ֶ�û��Ӧֵ����ȡ���ַ���0  
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
	//ȡ��whichSp��field�ֶζ�Ӧ��int���͵�ֵ  
    public static int getSharePreInt(Context mContext,String whichSp,String field){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        int i=sp.getInt(field,0);//������ֶ�û��Ӧֵ����ȡ��0  
        return i;  
    }  
    //����string���͵�value��whichSp�е�field�ֶ�  
    public static void putSharePre(Context mContext,String whichSp,String field,String value){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        sp.edit().putString(field, value).commit();  
    }  
    //����int���͵�value��whichSp�е�field�ֶ�  
    public static void putSharePre(Context mContext,String whichSp,String field,int value){  
        SharedPreferences sp=(SharedPreferences) mContext.getSharedPreferences(whichSp, 0);  
        sp.edit().putInt(field, value).commit();  
    }

	public static void showToast(Context mContext,String msg){
		    Toast toast=new Toast(mContext);  
	        toast=Toast.makeText(mContext,msg, 300);  
	        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);//���þ���  
	        toast.show();
	}
}
