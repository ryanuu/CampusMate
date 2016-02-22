package com.campusmate.dialogandpop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

import com.campusmate.R;

public class MyPopupWindow1 extends PopupWindow{
	private View[] views;
	private View contentView;
	public MyPopupWindow1(final Activity context,int resource){
		 LayoutInflater inflater = (LayoutInflater) context  
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
		        contentView = inflater.inflate(resource, null);  
		        int h = context.getWindowManager().getDefaultDisplay().getHeight();  
		        int w = context.getWindowManager().getDefaultDisplay().getWidth();  
	            // 设置SelectPicPopupWindow的View  
				this.setContentView(contentView);  
				// 设置SelectPicPopupWindow弹出窗体的宽  
				this.setWidth(LayoutParams.WRAP_CONTENT);  
				// 设置SelectPicPopupWindow弹出窗体的高  
				this.setHeight(LayoutParams.WRAP_CONTENT);  
				// 设置SelectPicPopupWindow弹出窗体可点击  
				this.setFocusable(true);  
				this.setOutsideTouchable(true);  
				// 刷新状态  
				this.update();  
				// 实例化一个ColorDrawable颜色为半透明  
				ColorDrawable dw = new ColorDrawable(0000000000);  
				// 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作  
				this.setBackgroundDrawable(dw);  				

	}
	//设置popwupwindow的宽和高
	public MyPopupWindow1 setWidthAndHeight(int w,int h){
		this.setWidth(w);
		this.setHeight(h);
		return this;
	}
	// 设置SelectPicPopupWindow弹出窗体动画效果
	public MyPopupWindow1 setAnimation(int style){
		// mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);  	
		this.setAnimationStyle(style);
		return this;
	}
	//设置需要有点击事件的按钮（view）
	public void setView(int...resources){
		views=new View[resources.length];
		for(int i=0;i<resources.length;i++){
			views[i]=contentView.findViewById(resources[i]);
		}

	}
	//设置按钮点击事件
	public void setViewClick(OnClickListener...listener){
		for(int i=0;i<listener.length&&i<views.length;i++){
			views[i].setOnClickListener(listener[i]);
		}
	}
	//显示popupwindow的三种方法
	public void showAsPopupWindow(View v,int xoff,int yoff){
		if(this.isShowing()){
			this.dismiss();
		}else{
			this.showAsDropDown(v, xoff, yoff);
		}
	}
	public void showPopupWindow(View v,int gravity,int x,int y){
		if(this.isShowing()){
			this.dismiss();
		}else{
			this.showAtLocation(v, gravity, x, y);
		}
	}
	public void showPopupWindow(View v){
		if(this.isShowing()){
			this.dismiss();
		}else{
			this.showAtLocation(v, Gravity.CENTER, 0, 0);
		}
	}
	
}
