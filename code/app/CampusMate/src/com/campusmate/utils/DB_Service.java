package com.campusmate.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.campusmate.AppContext;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;

public class DB_Service {
	static DbUtils db = null;
	//创建数据库的两个方法
	public static DbUtils getDb(Context context,String db_name) {
	    if (context == null) {
		context = AppContext.getInstance();
	    }
		if (db == null) {
		db = DbUtils.create(context, db_name+".db");
		db.configAllowTransaction(true);	
		}
		return db;
	}
	public static DbUtils getDb(Context context) {
	    if (context == null) {
		context = AppContext.getInstance();
	    }
		if (db == null) {
		db = DbUtils.create(context, "CampusMate.db");
		db.configAllowTransaction(true);	
		}
		return db;
	}
    //删除表
	public static <T> void deleteTable(Class<T>...objects){
    	try{
    		for(int i=0;i<objects.length;i++){
    		  db.dropTable(objects[i]);
    		}
  		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	//创建表
	public static <T> void createTable(Class<T>...objects){
    	try{
    		for(int i=0;i<objects.length;i++){
    			db.createTableIfNotExist(objects[i]);
    		}   		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 批量新增
	 * 
	 * @param list
	 */
	public static <T> void batchInsert(ArrayList<T> list) {
		try{
			db.saveAll(list);	        
			Log.e(list.get(0).getClass().getName(), "succeed");
		}catch (Exception e){
			Log.e("shujuku", "failed");
			e.printStackTrace();
		}	
	}
	//根据一个参数查询，以List的方式返回
	public static <T> List<T> queryParams(Class<T> ot, String params,int value) {
		List<T> list = new ArrayList<T>();
		try{
			list=db.findAll(Selector.from(ot).where(params,"=",value).orderBy("id"));			
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
    //根据两个参数查询，以List的方式返回
	public static <T> List<T>  querySting(Class<T> ot, String params1,String params2,int value1,int value2,String op1,String op2) {
		List<T> list = new ArrayList<T>();
		try{
			list=db.findAll(Selector.from(ot).where(params1,op1,value1).and(WhereBuilder.b(params2, op2, value2)).orderBy("id"));
			Log.e("searchString", list.toString());
		}catch (Exception e){
			Log.e("searchString", "failed");
			e.printStackTrace();			
		}
		return list;
	}
	
}
