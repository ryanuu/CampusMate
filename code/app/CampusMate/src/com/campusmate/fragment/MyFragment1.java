package com.campusmate.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campusmate.R;
import com.campusmate.adapter.ChildFragmentPagerAdapter;
import com.campusmate.view.MyViewPager;

public class MyFragment1 extends BaseFragment{

	private MyViewPager childBody;
	private ArrayList<MyChildFragment> childFragments;
	private FragmentManager fm;
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
	private void initView(View view){
		childBody=(MyViewPager)view.findViewById(R.id.child_body);
		childBody.setAdapter(new ChildFragmentPagerAdapter(fm,childFragments));
		childBody.setCurrentItem(Integer.MAX_VALUE/2);
		childBody.setOnPageChangeListener(new ChildOnPageChangeListener());
	}
	 public class ChildOnPageChangeListener implements OnPageChangeListener{

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
	
}
