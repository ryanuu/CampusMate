package com.campusmate.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.campusmate.fragment.BaseFragment;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter{  
    ArrayList<BaseFragment> list; 
    public MainFragmentPagerAdapter(FragmentManager fm,ArrayList<BaseFragment> list) {       
    	super(fm);  
        this.list = list;  
          
    }        
    @Override  
    public int getCount() {  
        return list.size();  
    }  
      
    @Override  
    public Fragment getItem(int arg0) {  
        return list.get(arg0);  
    }  
}
