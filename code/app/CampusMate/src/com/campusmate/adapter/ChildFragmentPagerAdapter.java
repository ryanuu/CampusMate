package com.campusmate.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.campusmate.commondata.CommonData;
import com.campusmate.fragment.MyChildFragment;

public class ChildFragmentPagerAdapter  extends FragmentStatePagerAdapter{  
    ArrayList<MyChildFragment> list; 
    private int[] CONTENT = new int[]{4,0,1,2,3,4,0};
    public ChildFragmentPagerAdapter(FragmentManager fm,ArrayList<MyChildFragment> list) {  
        super(fm);  
        this.list = list;  
          
    }
    

	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
//		Log.e("setPramaryItem",position+"");
		super.setPrimaryItem(container, position, object);
	}


	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		MyChildFragment childFragment;
		childFragment=this.list.get(position%list.size());
		Log.e("getItem",position+"");
		Log.e("Fragment",position%list.size()+"");
		childFragment.reCreateView(position);
		return childFragment;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return CommonData.WEEKNUN;
	}        
   
}