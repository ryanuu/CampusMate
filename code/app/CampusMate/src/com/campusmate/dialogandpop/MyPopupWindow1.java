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
	            // ����SelectPicPopupWindow��View  
				this.setContentView(contentView);  
				// ����SelectPicPopupWindow��������Ŀ�  
				this.setWidth(LayoutParams.WRAP_CONTENT);  
				// ����SelectPicPopupWindow��������ĸ�  
				this.setHeight(LayoutParams.WRAP_CONTENT);  
				// ����SelectPicPopupWindow��������ɵ��  
				this.setFocusable(true);  
				this.setOutsideTouchable(true);  
				// ˢ��״̬  
				this.update();  
				// ʵ����һ��ColorDrawable��ɫΪ��͸��  
				ColorDrawable dw = new ColorDrawable(0000000000);  
				// ��back���������ط�ʹ����ʧ,������������ܴ���OnDismisslistener �����������ؼ��仯�Ȳ���  
				this.setBackgroundDrawable(dw);  				

	}
	//����popwupwindow�Ŀ�͸�
	public MyPopupWindow1 setWidthAndHeight(int w,int h){
		this.setWidth(w);
		this.setHeight(h);
		return this;
	}
	// ����SelectPicPopupWindow�������嶯��Ч��
	public MyPopupWindow1 setAnimation(int style){
		// mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);  	
		this.setAnimationStyle(style);
		return this;
	}
	//������Ҫ�е���¼��İ�ť��view��
	public void setView(int...resources){
		views=new View[resources.length];
		for(int i=0;i<resources.length;i++){
			views[i]=contentView.findViewById(resources[i]);
		}

	}
	//���ð�ť����¼�
	public void setViewClick(OnClickListener...listener){
		for(int i=0;i<listener.length&&i<views.length;i++){
			views[i].setOnClickListener(listener[i]);
		}
	}
	//��ʾpopupwindow�����ַ���
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
