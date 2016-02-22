package com.campusmate.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
//�ж��ַ��������Ƿ�Ϊ�գ��ж��ֻ������ʽ�Ƿ���ȷ
public class TextIsEmpty {
	//�ж��ַ��������Ƿ�Ϊ��
	public static boolean isEmpty(String text){
		if(null==text){
			return true;
		}else if("".equals(text)){
			return true;
		}
		return false;
	}
	public static boolean isEmpty(String...strings){
		for(int i=0;i< strings.length;i++){
			if(null==strings[i]){
				return true;
			}else if("".equals(strings[i])){
				return true;
			}
		}	
		return false;
	}
	//�ж��ֻ������ʽ�Ƿ���ȷ
	public static boolean isPhoneNumber(String phoneNumber){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,3-9]))\\d{8}$");  

		Matcher m = p.matcher(phoneNumber);  

	    Log.e("isPhoneNumber",m.matches()+"---");  

		return m.matches();
	}
	//�ж϶��Textview�Ƿ�Ϊ��
	public static int textViewIsEmpty(TextView...textViews ){
		int result=-1;
		for(int i=0;i<textViews.length;i++){
			if(isEmpty(textViews[i].getText().toString())){
				result=i;
				break;
			}
		}
		return result;
	}
	//�ж϶��EditText�Ƿ�Ϊ��
	public static int editTextIsEmpty(EditText...textViews){
		int result=-1;
		for(int i=0;i<textViews.length;i++){
			if(isEmpty(textViews[i].getText().toString())){
				result=i;
				break;
			}
		}
		return result;
	}
}
