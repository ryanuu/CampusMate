package com.campusmate;

import android.os.Bundle;

import com.campusmate.dialogandpop.MyDialog1;
import com.campusmate.dialogandpop.MyDialog2;
import com.campusmate.dialogandpop.MyPopupWindow1;
//����Activity��ʵ�ֵĹ����е���dialog��popupwindow
public class BaseActivity2 extends BaseActivity1{
	protected static int ONLYPOP=0; //��Ҫ��ʾpop
	protected static int ONLYDIALOG2=1;//��Ҫ��ʾdialog2
	protected static int BOTHPAD=3;//��Ҫ��ʾ����
	protected MyDialog1 dialog1;//�ձ���ʽdialog���Զ����ɣ�
	protected MyDialog2 dialog2;//֧���Զ�����ʽdialog
	protected MyPopupWindow1 pop1;//֧���Զ�����ʽpopupwindow
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
    //ֻ��Ҫdialog1ʱ���ã��Զ����ɣ�
	@Override
	protected void initWidget() {
		// TODO Auto-generated method stub
		super.initWidget();
		dialog1=new MyDialog1(mContext);
	}
	//��Ҫpopupwindow���Զ���dialog2ʱ����
	protected void initWidget(int type,int...resource){
		switch(type){
		case 0://ֻ��Ҫpop
			pop1=new MyPopupWindow1(this,resource[0]);
			break;
		case 1://ֻ��Ҫdialog2
			dialog2=new MyDialog2(mContext, resource[0]);
			break;
		case 2://ͬʱ��Ҫ
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
