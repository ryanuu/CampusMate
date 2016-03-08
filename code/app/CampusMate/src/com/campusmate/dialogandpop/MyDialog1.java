package com.campusmate.dialogandpop;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.campusmate.R;

public class MyDialog1{
	private Context context;
	private AlertDialog dialog;
	public static int BTN_NUM_ONE=1;
	public static int BTN_NUM_TWO=2;
	//对话框包含的空间
	private TextView title,content,btnL,btnR,line;
	//对话框的按钮个数
	private int btnNum=2;
	private boolean isShowTitle=true;
	//对话框的字段
	private String title_dialog="提示",content_dialog,btnL_dialog="取消",btnR_dialog="确定";
	//对话框的按钮监听
	private android.view.View.OnClickListener [] listeners;
	public MyDialog1(Context context){
		this.context=context;
	}
	public void show(){
		dialog=new AlertDialog.Builder(context).create();
		//点击外部区域不能取消dialog 
		dialog.setCanceledOnTouchOutside(true);
		dialog.setOnKeyListener(keylistener);
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.common_dialog);
		title=(TextView) window.findViewById(R.id.dialog_title);
		showTitle(isShowTitle);
		Title(title_dialog);
		content=(TextView) window.findViewById(R.id.dialog_content);
		content(content_dialog);
		btnL=(TextView) window.findViewById(R.id.dialog_btnl);
		BtnL(btnL_dialog);
		btnR=(TextView) window.findViewById(R.id.dialog_btnr);
		BtnR(btnR_dialog);
		line=(TextView) window.findViewById(R.id.dialog_line);
		BtnClick(listeners);
		BtnNum(btnNum);	
		window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		window.setGravity(Gravity.CENTER);
	}
	public static OnKeyListener keylistener = new DialogInterface.OnKeyListener(){
		public boolean onKey(DialogInterface dialog,  int keyCode, KeyEvent event) {
			if (keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	} ;
	public boolean isShowing(){
		if(dialog!=null){
			return dialog.isShowing();
		}else{
			return false;
		}	
	}
	public void dismiss(){
		dialog.dismiss();
	}
	private void Title(String s){
		title.setText(s);
	}
	public MyDialog1 setTitle(String s){
		title_dialog=s;
		return this;
	}
	private void showTitle(boolean b){
		if(b){
			title.setVisibility(View.VISIBLE);
		}else{
			title.setVisibility(View.GONE);
		}
	}
	public MyDialog1 setShowTitle(boolean b){
		isShowTitle=b;
		return this;
	}
	private void content(String s){
		content.setText(s);
	}
	public MyDialog1 setContent(String s){
		content_dialog=s;
		return this;
	}
	private void BtnL(String s){
		btnL.setText(s);
	}
	public MyDialog1 setBtnL(String s){
		btnL_dialog=s;
		return this;
	}
	private void BtnR(String s){
		btnR.setText(s);
	}
	public MyDialog1 setBtnR(String s){
		btnR_dialog=s;
		return this;
	}
	private void BtnNum(int i){
		switch(i){
		case 1://只需要一个按钮		
			btnL.setVisibility(View.VISIBLE);
			line.setVisibility(View.GONE);
			btnR.setVisibility(View.GONE);
			break;
		case 2://需要两个按钮
			btnL.setVisibility(View.VISIBLE);
			line.setVisibility(View.VISIBLE);
			btnR.setVisibility(View.VISIBLE);
			break;
		}
	}
	public MyDialog1 setBtnNum(int i){
		btnNum=i;
		return this;
	}
	private void BtnClick(android.view.View.OnClickListener...clickListeners){
		if(clickListeners==null){
			return;
		}
		switch(clickListeners.length){
		case 0:
			break;
		case 1:
			btnL.setOnClickListener(clickListeners[0]);
			break;
		case 2:
			btnL.setOnClickListener(clickListeners[0]);
			btnR.setOnClickListener(clickListeners[1]);
			break;
		case 3:
			break;
		}
	}
	public MyDialog1 setBtnClick(android.view.View.OnClickListener...clickListeners){
		listeners=clickListeners;
		return this;
	}

	
}
