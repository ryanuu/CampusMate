package com.campusmate;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.campusmate.bean.BaseResultBean;
import com.campusmate.commondata.CommonData;
import com.campusmate.dialogandpop.MyProgressBar1;
import com.campusmate.utils.Config_PT;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
//����Activity��ʵ�ֵĹ�������������ص�����ʾ��Ӧprogress
public class BaseActivity1 extends FragmentActivity{
	
	protected Context mContext;
	protected int currentTag=0;//���ڶ����������ʱ���ַ������ݣ�
	protected MyProgressBar1 pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext=this;
		initWidget();
		initviewAndListener();
		initAsyc();
	}
	protected void initWidget(){
		pb=new MyProgressBar1(mContext);
	}
	
	protected  void initviewAndListener(){};
	protected  void initAsyc(){};
	protected RequestCallBack<String> rc=new RequestCallBack<String>(){	
		@Override
		public void onFailure(com.lidroid.xutils.exception.HttpException arg0,
				String arg1) {
			// TODO Auto-generated method stub
			httpFailure(arg0, arg1);
		}

		@Override
		public void onLoading(long total, long current, boolean isUploading) {
			// TODO Auto-generated method stub
			super.onLoading(total, current, isUploading);
			httpLoading(total, current, isUploading);
		}

		@Override
		public void onStart() {
			// TODO Auto-generated method stub
			super.onStart();			
			httpStart();
		}

		@Override
		public void onSuccess(ResponseInfo<String> arg0) {
			// TODO Auto-generated method stub		
			httpSuccess(arg0);
		}
		
	};
	protected void httpStart(){
		showProgressBar();
	}
	protected void httpLoading(long total, long current, boolean isUploading){}
	protected void httpSuccess(ResponseInfo<String> arg0){
		dismissProgressBar();
	}
	protected void httpFailure(com.lidroid.xutils.exception.HttpException arg0, String arg1){
		dismissProgressBar();
		Config_PT.showToast(this, arg0.getExceptionCode()+":"+arg1);
	}
	protected boolean checkResultData(BaseResultBean bean){
		if(bean==null){
			Config_PT.showToast(mContext, "bean Ϊ��");
			return false;
		}
		if(CommonData.Code_Success.equals(bean.getCode())){
			return true;
		}else{
			return false;
		}
	}
//��ʾ����
	protected void showProgressBar(){
		if(pb!=null&&(!pb.isShowing())){
			pb.show();
		}
	}
//ȡ��������ʾ
	protected void dismissProgressBar(){
		if(pb!=null&&pb.isShowing()){
			pb.dismiss();
		}
	}
//���ý���������ʾ	
	protected void setTextProgressBar(String s){
		if(pb!=null){
			pb.setText(s);
		}		
	}
}
