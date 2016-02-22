package com.campusmate.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.campusmate.fragment.MyChildFragment;

public class ChildFragmentPagerAdapter  extends FragmentPagerAdapter{  
    ArrayList<MyChildFragment> list;  
    public ChildFragmentPagerAdapter(FragmentManager fm,ArrayList<MyChildFragment> list) {  
        super(fm);  
        this.list = list;  
          
    }
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		MyChildFragment childFragment;
		childFragment=this.list.get(arg0%list.size());
		childFragment.initData();
		return childFragment;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}        
   
}