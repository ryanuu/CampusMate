package com.campusmate.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campusmate.R;
import com.campusmate.adapter.MainFragmentPagerAdapter;
import com.campusmate.bean.SectionList;
import com.campusmate.bean.WeekList;
import com.campusmate.commondata.CommonData;
import com.campusmate.fragment.BaseFragment;
import com.campusmate.fragment.MyFragment1;
import com.campusmate.fragment.MyFragment2;
import com.campusmate.resultbean.SectionListBean;
import com.campusmate.resultbean.WeekListBean;
import com.campusmate.utils.Config_PT;
import com.campusmate.utils.DB_Service;
import com.campusmate.utils.GsonAnalyze;
import com.campusmate.utils.HttpClient;
import com.campusmate.view.MyViewPager;
import com.cemt.ble.base.BeaconDev;
import com.lidroid.xutils.http.ResponseInfo;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushService;


public class MainActivity extends SignInActivity implements OnClickListener{	
	private LinearLayout mainFooter;
	private TextView footer1;
	private TextView footer2;
	private MyViewPager mainBody;
	private ArrayList<BaseFragment> fragmentlist;
	private int currentHttp=0;//网络请求的次数，默认为0
	private WeekListBean weekbean;
	private SectionListBean sectionbean;
	private boolean ForcedToChangeWeek=true;//强行改变周表
	private int SIGN_STATE=0;//签到状态，0表示为进行签到；1表示已签到；2表示已签退
	private MyFragment1 fragment1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		//微信信鸽代码
		Context context = getApplicationContext();
		XGPushManager.registerPush(context);    		 
		// 2.36（不包括）之前的版本需要调用以下2行代码
		Intent service = new Intent(context, XGPushService.class);
		context.startService(service);
	}
	

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}


	@Override
	protected void initviewAndListener() {
		// TODO Auto-generated method stub
		super.initviewAndListener();
		mainFooter = (LinearLayout)findViewById( R.id.main_footer );
		footer1 = (TextView)findViewById( R.id.footer_1 );
		footer2 = (TextView)findViewById( R.id.footer_2 );
		mainBody = (MyViewPager)findViewById( R.id.main_body );
		findViewById( R.id.footer_ll_1 ).setOnClickListener(this);
		findViewById( R.id.footer_ll_2 ).setOnClickListener(this);
		fragmentlist=new ArrayList<BaseFragment>();		
	}

	@Override
	protected void initAsyc() {
		// TODO Auto-generated method stub
		super.initAsyc();
		//获取当前时间
		CommonData.CURRENT_DAY=System.currentTimeMillis();
		//检查周表和节表
		checkTableIsExist(1);
	}
	//蓝牙数据获取、签到
	protected void BlesignIn(List<BeaconDev> list){
		httpPost3(list.get(0).getUuid());
	}
	//蓝牙数据获取、签退
	protected void BlesignOut(List<BeaconDev> list){
		
	}
	//初始化数据
	public void initData(){	
		try{//确定一学期的周数
			List<WeekList> list=DB_Service.getDb(mContext).findAll(WeekList.class);
			CommonData.WEEKNUN=list.size()*7;
		}catch(Exception e){
			e.printStackTrace();
		}		
		fragmentlist.add(fragment1=new MyFragment1(this.getSupportFragmentManager()));
		fragmentlist.add(new MyFragment2());
		mainBody.setAdapter(new MainFragmentPagerAdapter(this.getSupportFragmentManager(), fragmentlist));
		mainBody.setCurrentItem(0);
		mainBody.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	//检查是否已存在周表和节表
	private void checkTableIsExist(int i){
		switch(i){
		case 1://检查周表
			try{
				//获取数据库对象,并判断表是否存在
				boolean weekTableIsExist=
			    DB_Service.getDb(mContext).tableIsExist(WeekList.class);
				if(!weekTableIsExist||ForcedToChangeWeek){
					Log.e("weektable", "not exist "+weekTableIsExist);
					httpPost1();
				}else{
					Log.e("weektable", "exist "+weekTableIsExist);
					//检查是否存在节表
					checkTableIsExist(2);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
			break;
		case 2://检查节表
			try{
				//获取数据库对象,并判断表是否存在
				boolean sectionTableIsExist=
			    DB_Service.getDb(mContext).tableIsExist(SectionList.class);
				if(!sectionTableIsExist||ForcedToChangeWeek){
					Log.e("sectiontable", "not exist "+sectionTableIsExist);
					httpPost2();
				}else{
					Log.e("sectiontable", "exist "+sectionTableIsExist);
					//检查是否存在节表
					initData();
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
			break;
		}
		
	}
	 public class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			fragmentlist.get(arg0).initData();
			switch(arg0){
			case 0:
				footer1.setEnabled(true);
				footer2.setEnabled(false);
				break;
			case 1:
				footer1.setEnabled(false);
				footer2.setEnabled(true);
				break;
			}
		}  	          
	                
    } 
	 //获取周列表
	private void httpPost1(){
		setTextProgressBar("获取周表..");
		currentHttp=1;
		String url=CommonData.HttpUrl;
//		String url=CommonData.HttpUrl+"104";
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("act", "104");
		map.put("ticket", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "ticket"));
		map.put("collegeId", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "collegeId"));
		HttpClient.Post(url, map, rc, mContext);
	}
	//获取节列表
	private void httpPost2(){
		setTextProgressBar("获取时间表..");
		currentHttp=2;
		String url=CommonData.HttpUrl;
//		String url=CommonData.HttpUrl+"105";
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("act", "105");
		map.put("ticket", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "ticket"));
		map.put("collegeId", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "collegeId"));
		HttpClient.Post(url, map, rc, mContext);
	}
	//签到和签退
	private void httpPost3(String uuid){
		setTextProgressBar("进行签到..");
		currentHttp=3;
		String url=CommonData.HttpUrl;
//		String url=CommonData.HttpUrl+"108";
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("act", "108");
		map.put("ticket", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "ticket"));
		map.put("studentId", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "studentId"));
		map.put("termID", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "termID"));
		map.put("weekNo", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "termID"));
		map.put("weekday", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "termID"));
		map.put("curriculum_id", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "curriculum_id"));
		HttpClient.Post(url, map, rc, mContext);
	}

	
	@Override
	protected void httpSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		super.httpSuccess(arg0);
		switch(currentHttp){
		case 1://获取周表
			DB_Service.deleteTable(WeekList.class);
			weekbean=GsonAnalyze.analyze(arg0.result, WeekListBean.class);
			if(checkResultData(weekbean)){
				DB_Service.batchInsert(weekbean.getData().get(0).getWeekList());
			}else{
				Config_PT.showToast(mContext, weekbean.getCodeText());
			}
			//检查是否存在节表
			checkTableIsExist(2);
			break;
		case 2://获取节表
			DB_Service.deleteTable(SectionList.class);
			sectionbean=GsonAnalyze.analyze(arg0.result, SectionListBean.class);
			if(checkResultData(sectionbean)){
				DB_Service.batchInsert(sectionbean.getData().get(0).getSectionList());
			}else{
				Config_PT.showToast(mContext, weekbean.getCodeText());
			}
			initData();
			break;
		case 3://签到和签退
			Config_PT.showToast(mContext, "已成功签到");
			int i=MyFragment1.currentPage;
			fragment1.getChildFragments().get(i).initData();
			break;
			
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.footer_ll_1:
			mainBody.setCurrentItem(0);
			footer1.setEnabled(true);
			footer2.setEnabled(false);
			break;
		case R.id.footer_ll_2:
        	mainBody.setCurrentItem(1);
        	footer1.setEnabled(false);
			footer2.setEnabled(true);
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode==KeyEvent.KEYCODE_BACK ){
			dialog1.setContent("确定退出？")
			.setBtnClick(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog1.dismiss();
				}
				
			},
			new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					MainActivity.this.finish();
					dialog1.dismiss();
				}
			
		}).show();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
}
