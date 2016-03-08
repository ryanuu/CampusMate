package com.campusmate;

import android.os.Bundle;

import com.campusmate.dialogandpop.MyDialog1;
import com.campusmate.dialogandpop.MyDialog2;
import com.campusmate.dialogandpop.MyPopupWindow1;
//基类Activity，实现的功能有弹出dialog和popupwindow
public class BaseActivity2 extends BaseActivity1{
	protected static int ONLYPOP=0; //需要显示pop
	protected static int ONLYDIALOG2=1;//需要显示dialog2
	protected static int BOTHPAD=3;//需要显示两者
	protected MyDialog1 dialog1;//普遍样式dialog（自动生成）
	protected MyDialog2 dialog2;//支持自定义样式dialog
	protected MyPopupWindow1 pop1;//支持自定义样式popupwindow
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
    //只需要dialog1时调用（自动生成）
	@Override
	protected void initWidget() {
		// TODO Auto-generated method stub
		super.initWidget();
		dialog1=new MyDialog1(mContext);
	}
	//需要popupwindow和自定义dialog2时调用
	protected void initWidget(int type,int...resource){
		switch(type){
		case 0://只需要pop
			pop1=new MyPopupWindow1(this,resource[0]);
			break;
		case 1://只需要dialog2
			dialog2=new MyDialog2(mContext, resource[0]);
			break;
		case 2://同时需要
			pop1=new MyPopupWindow1(this,resource[0]);
			dialog2=new MyDialog2(mContext, resource[1]);
			break;
		}
		
	}

	@Override
	protected void initviewAndListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initAsyc() {
		// TODO Auto-generated method stub
		
	}

	
}
