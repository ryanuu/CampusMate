package com.campusmate.dialogandpop;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.campusmate.R;

public class MyDialog2 extends Dialog {
	public static int BTN_NUM_ONE=1;
	public static int BTN_NUM_TWO=2;
	private View contentView;
	private View[] views;
	public MyDialog2(Context context,int resource){
		super(context);
		 LayoutInflater inflater = (LayoutInflater) context  
	                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
          contentView = inflater.inflate(resource, null);  
			        
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(contentView);
	}
	//设置需要有点击事件的按钮（view）
	public void setView(int...resources){
		views=new View[resources.length];
		for(int i=0;i<resources.length;i++){
			views[i]=contentView.findViewById(resources[i]);
		}

	}
		//设置按钮点击事件
	public void setViewClick(android.view.View.OnClickListener...listener){
		for(int i=0;i<listener.length&&i<views.length;i++){
			views[i].setOnClickListener(listener[i]);
		}
	}
	
}
