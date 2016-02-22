package com.campusmate.utils;

import java.io.File;
import java.util.HashMap;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.campusmate.AppContext;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;



public class HttpClient {
	public static void Get(String url,HashMap<String, String> map,RequestCallBack<String> rc,Context mContext){
		StringBuffer params=new StringBuffer();
		for (HashMap.Entry<String, String> entry : map.entrySet()) {
            params.append(entry.getKey()+"="+ entry.getValue());
            params.append("&");
        }
		params.deleteCharAt(params.length()-1); 
		String paramsUrl=url+"?"+params.toString();
		HttpUtils http = new HttpUtils();
		http.configCurrentHttpCacheExpiry(60*1000);
		Log.e("get", paramsUrl);
		http.send(HttpRequest.HttpMethod.GET, paramsUrl, rc);
	}
	
	public static void Post(String url,HashMap<String, String> map,RequestCallBack<String> rc,Context mContext){
		final RequestParams params = new RequestParams();
		String s=url;
		 for (HashMap.Entry<String, String> entry : map.entrySet()) {
             params.addBodyParameter(entry.getKey(),  entry.getValue());
             s+=" "+entry.getKey()+entry.getValue();
         }	
		 Log.e("post", s);
		HttpUtils http = new HttpUtils();
		http.configCurrentHttpCacheExpiry(60*1000);
		http.send(HttpRequest.HttpMethod.POST, url, params, rc);
	}
	public static void PostFile(String url,HashMap<String, String> map,RequestCallBack<String> rc){
		final RequestParams params = new RequestParams();
		for (HashMap.Entry<String, String> hentry : headerMap.entrySet()) {
			params.addHeader(hentry.getKey(), hentry.getValue());
		}
		for (HashMap.Entry<String, String> entry : map.entrySet()) {
			params.addBodyParameter(entry.getKey(), new File(entry.getValue()));
		}		
		HttpUtils http = new HttpUtils();
		http.send(HttpRequest.HttpMethod.POST,url,params,rc);
	}
	//����������ͷ����
	public static HashMap<String, String> headerMap=new HashMap<String, String>();
	public static void DownLoad(String downurl,String saveurl,RequestCallBack<File> rc){
		HttpUtils http = new HttpUtils();
		HttpHandler handler = http.download(downurl,
		    saveurl,
		    true, // ���Ŀ���ļ����ڣ�����δ��ɵĲ��ּ������ء���������֧��RANGEʱ���������ء�
		    true, // ��������󷵻���Ϣ�л�ȡ���ļ�����������ɺ��Զ���������
		     rc);
	}
	public static void DownLoad(String downUrl,RequestCallBack<File> rc,String filename){
		HttpUtils http = new HttpUtils();
		HttpHandler handler = http.download(downUrl,
		    Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+filename,
		    true, // ���Ŀ���ļ����ڣ�����δ��ɵĲ��ּ������ء���������֧��RANGEʱ���������ء�
		    true, // ��������󷵻���Ϣ�л�ȡ���ļ�����������ɺ��Զ���������
		     rc);
	}
	
}
