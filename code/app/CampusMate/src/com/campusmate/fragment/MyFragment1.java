package com.campusmate.fragment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.campusmate.R;
import com.campusmate.adapter.ChildFragmentPagerAdapter;
import com.campusmate.commondata.CommonData;
import com.campusmate.utils.DateUtil;
import com.campusmate.view.MarqueeTextView;
import com.campusmate.view.MyViewPager;

public class MyFragment1 extends BaseFragment{
	private TextView title;
	private MarqueeTextView notification;
	private TextView pullIcon;
	private TextView currentDate;
	private ImageView extraIcon;
	private MyViewPager childBody;
	private ArrayList<MyChildFragment> childFragments=new ArrayList<MyChildFragment>();
	private FragmentManager fm;
	public static boolean ScanScroll=true;//设置viewpager是否可滑动，默认可以
	private int currentweek=0;//当前周
	public static int currentPage=0;//当前页面
	private String[] WEEK_Num={"周日","周一","周二","周三","周四","周五","周六"};
	
	public MyFragment1(FragmentManager fm){
		this.fm=fm;
	}
	public MyFragment1(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.main_body_a, container,false);
		initAsyc();
		initView(view);
		return view;
	}
    private void initAsyc(){
    	for(int i=0;i<5;i++){
    		childFragments.add(new MyChildFragment());
    	}
    }
    
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		super.initData();
		childBody.getAdapter().notifyDataSetChanged();
	}
	private void initView(View view){
		title = (TextView)view.findViewById( R.id.title );
		notification = (MarqueeTextView)view.findViewById( R.id.notification );
		pullIcon = (TextView)view.findViewById( R.id.pull_icon );
		currentDate = (TextView)view.findViewById( R.id.current_date );
		extraIcon = (ImageView)view.findViewById( R.id.extra_icon );
		
		Drawable drawable= getResources().getDrawable(R.drawable.notification);
		drawable.setBounds(0, 0, 32, 32);
		notification.setCompoundDrawables(drawable,null,null,null);
		Drawable drawable2= getResources().getDrawable(R.drawable.pull_down);
		drawable2.setBounds(0, 2, 20, 14);
		pullIcon.setCompoundDrawables(drawable2,null,null,null);
		
		childBody=(MyViewPager)view.findViewById(R.id.child_body);
		childBody.setAdapter(new ChildFragmentPagerAdapter(fm,childFragments));
		childBody.setCurrentItem(currentPage);
		childBody.setOnPageChangeListener(new ChildOnPageChangeListener());
		//显示当前时间
		try{
			currentweek=Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
			
			currentDate.setText(DateUtil.LongToDate
					(CommonData.CURRENT_DAY,"MM/dd")
					+" "+WEEK_Num[currentweek]
					);
		}catch (ParseException e){
			e.printStackTrace();
		}
	}
	private boolean isScrolling=false;
	private int scroll_direction=0;//滑动方向，0为不滑动，1为向右，-1为向左
	private int lastValue=-1;//滑动的方向判断
	private int scroll_Num=0;//向左或向右滑动的页数
	public class ChildOnPageChangeListener implements OnPageChangeListener{

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				Log.e("onPageScrollStateChanged", arg0+"");
				if (arg0 == 1) {//正在滑动
					isScrolling = true;
				} else {
					isScrolling = false;
				}
//				if (arg0 == 2) {//滑动停止
//					
//					 scroll_direction=0;
//			    }
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
//				Log.e("onPageScrolled", arg0+"");
				if (isScrolling) {
					 if (lastValue > arg2) {
					 // 递减，向左侧滑动
						 scroll_direction=1;
                         Log.e("scroll", arg2+"  left "+scroll_direction);
					 } else if (lastValue < arg2) {
					 // 递减，向右侧滑动
						 scroll_direction=1;
						 Log.e("scroll", arg2+"  right "+scroll_direction);
					 } else if (lastValue == arg2) {
						 scroll_direction=0;
						 Log.e("scroll", arg2+"  stop "+scroll_direction);
					 }
				}
					 lastValue = arg2;
			}

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub				
				try{
					int PageNum=scroll_direction*(position-currentPage);
					Log.e("scroll_stop", " "+currentweek+ "/"+scroll_direction);
					int weekNum=(currentweek+PageNum)%7;
					if(weekNum==-1){
						weekNum=6;
					}else if(weekNum>=7){
						weekNum=0;
					}
					currentDate.setText(DateUtil.LongToDate
							(CommonData.CURRENT_DAY+PageNum*
									CommonData.ONE_DAY,"MM/dd")
							+" "+WEEK_Num[weekNum]
							);
				}catch (ParseException e){
					e.printStackTrace();
				}
				scroll_direction=0;
			}  	          
		                
     }
	public ArrayList<MyChildFragment> getChildFragments() {
		return childFragments;
	}
	public void setChildFragments(ArrayList<MyChildFragment> childFragments) {
		this.childFragments = childFragments;
	}
	
	public MyViewPager getChildBody() {
		return childBody;
	}
	public void setChildBody(MyViewPager childBody) {
		this.childBody = childBody;
	}
	
}
