package com.campusmate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.campusmate.commondata.CommonData;
import com.campusmate.dialogandpop.MyProgressBar1;
import com.campusmate.resultbean.BaseResultBean;
import com.campusmate.utils.Config_PT;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

public  class BaseFragment extends Fragment{
    protected Context mContext;
	protected MyProgressBar1 pb;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.mContext=this.getActivity();
	}
	public  void initData(){
		
	}
    public  void initData(Long data){
		
	}
	protected RequestCallBack<String> rc_f=new RequestCallBack<String>(){	
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
		Config_PT.showToast(this.getActivity(), arg0.getExceptionCode()+":"+arg1);
		Log.e("error", arg0.getExceptionCode()+":"+arg1);
	}
	protected boolean checkResultData(BaseResultBean bean){
		if(bean==null){
			Config_PT.showToast(this.getActivity(), "bean 为空");
			return false;
		}
		if(CommonData.Code_Success.equals(bean.getCode())){
			return true;
		}else{
			return false;
		}
	}
//显示进度
	protected void showProgressBar(){
		if(pb!=null&&(!pb.isShowing())){
			pb.show();
		}
	}
//取消进度显示
	protected void dismissProgressBar(){
		if(pb!=null&&pb.isShowing()){
			pb.dismiss();
		}
	}
//设置进度文字显示	
	protected void setTextProgressBar(String s){
		if(pb!=null){
			pb.setContent(s);
		}		
	}
}
