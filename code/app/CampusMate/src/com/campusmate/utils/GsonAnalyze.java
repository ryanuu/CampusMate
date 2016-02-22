package com.campusmate.utils;

import java.lang.reflect.Type;

import android.util.Log;

import com.google.gson.Gson;

public class GsonAnalyze {
	private static Gson gson = new Gson();
	//½âÎögson×Ö·û´®
		public static  <T> T analyze(String s,Class<T> cla){
			Log.e("result", s);
			T t=null;
			try{
				t=cla.newInstance();
				t = gson.fromJson(s, cla);
			}catch(Exception e){
				Log.e("gson", "failed");
				e.printStackTrace();
			}				
			return t;
		}
		public static  <T> T analyze(String s,Type type){
			Log.e("result", s);
			T t=null;
			try{
				t = gson.fromJson(s,type);
			}catch(Exception e){
				e.printStackTrace();
			}				
			return t;
		}

}
