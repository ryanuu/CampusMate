package com.campusmate.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campusmate.BaseActivity2;
import com.campusmate.R;
import com.campusmate.adapter.MainFragmentPagerAdapter;
import com.campusmate.fragment.BaseFragment;
import com.campusmate.fragment.MyFragment1;
import com.campusmate.fragment.MyFragment2;
import com.campusmate.fragment.MyFragment3;
import com.campusmate.view.MyViewPager;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushService;


public class MainActivity extends BaseActivity2 implements OnClickListener{	
	private LinearLayout mainFooter;
	private TextView footer1;
	private TextView footer2;
	private TextView footer3;
	private TextView footer4;
	private MyViewPager mainBody;
	private ArrayList<BaseFragment> fragmentlist;
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
	protected void initviewAndListener() {
		// TODO Auto-generated method stub
		super.initviewAndListener();
		mainFooter = (LinearLayout)findViewById( R.id.main_footer );
		footer1 = (TextView)findViewById( R.id.footer_1 );
		footer2 = (TextView)findViewById( R.id.footer_2 );
		footer3 = (TextView)findViewById( R.id.footer_3 );
		footer4 = (TextView)findViewById( R.id.footer_4 );
		mainBody = (MyViewPager)findViewById( R.id.main_body );
		footer1.setOnClickListener(this);
		footer2.setOnClickListener(this);
		footer3.setOnClickListener(this);
		footer4.setOnClickListener(this);
		
		fragmentlist=new ArrayList<BaseFragment>();
		fragmentlist.add(new MyFragment1(this.getSupportFragmentManager()));
		fragmentlist.add(new MyFragment2());
		fragmentlist.add(new MyFragment3());
		mainBody.setAdapter(new MainFragmentPagerAdapter(this.getSupportFragmentManager(), fragmentlist));
		mainBody.setCurrentItem(0);
		mainBody.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	@Override
	protected void initAsyc() {
		// TODO Auto-generated method stub
		super.initAsyc();
		
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
			
		}  	          
	                
	    }   

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.footer_1:
			mainBody.setCurrentItem(0);
			break;
        case R.id.footer_2:
        	mainBody.setCurrentItem(1);
			break;
       case R.id.footer_3:
    	    mainBody.setCurrentItem(2);
	        break;
       case R.id.footer_4:
    	    mainBody.setCurrentItem(3);
	        break;
		}
	}
	
}
