package com.campusmate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campusmate.R;

public class MyChildFragment extends BaseFragment{

	private TextView title;
	private TextView notification;
	private TextView pullIcon;
	private TextView currentDate;
	private ImageView extraIcon;
	private LinearLayout course1;
	private LinearLayout course2;
	private LinearLayout adLl;
	private LinearLayout course3;
	private LinearLayout course4;
	private LinearLayout course5;
	private LinearLayout course6;

	/**
	 * Find the Views in the layout<br />
	 * <br />
	 * Auto-created on 2016-02-22 14:59:21 by Android Layout Finder
	 * (http://www.buzzingandroid.com/tools/android-layout-finder)
	 */
	private void findViews() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.syllabus, container,false);
		initAsyc();
		initView(view);
		return view;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		super.initData();
	}
	private void initAsyc(){
		
	}
	private void initView(View view){
		title = (TextView)view.findViewById( R.id.title );
		notification = (TextView)view.findViewById( R.id.notification );
		pullIcon = (TextView)view.findViewById( R.id.pull_icon );
		currentDate = (TextView)view.findViewById( R.id.current_date );
		extraIcon = (ImageView)view.findViewById( R.id.extra_icon );
		course1 = (LinearLayout)view.findViewById( R.id.course_1 );
		course2 = (LinearLayout)view.findViewById( R.id.course_2 );
		adLl = (LinearLayout)view.findViewById( R.id.ad_ll );
		course3 = (LinearLayout)view.findViewById( R.id.course_3 );
		course4 = (LinearLayout)view.findViewById( R.id.course_4 );
		course5 = (LinearLayout)view.findViewById( R.id.course_5 );
		course6 = (LinearLayout)view.findViewById( R.id.course_6 );
	}

	
}
