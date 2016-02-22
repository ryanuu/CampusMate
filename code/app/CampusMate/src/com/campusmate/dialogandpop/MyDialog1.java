package com.campusmate.dialogandpop;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.campusmate.R;

public class MyDialog1 extends Dialog {

	public static int BTN_NUM_ONE=1;
	public static int BTN_NUM_TWO=2;
	private TextView title,content,btnL,btnR,line;
	public MyDialog1(Context context){
		super(context);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_dialog);
		title=(TextView)findViewById(R.id.dialog_title);
		content=(TextView)findViewById(R.id.dialog_content);
		btnL=(TextView)findViewById(R.id.dialog_btnl);
		btnR=(TextView)findViewById(R.id.dialog_btnr);
		line=(TextView)findViewById(R.id.dialog_line);
	}
	public MyDialog1 setTitle(String s){
		title.setText(s);
		return this;
	}
	public MyDialog1 setShowTitle(boolean b){
		if(b){
			title.setVisibility(View.VISIBLE);
		}else{
			title.setVisibility(View.GONE);
		}
		return this;
	}
	public MyDialog1 setContent(String s){
		content.setText(s);
		return this;
	}
	public MyDialog1 setBtnL(String s){
		btnL.setText(s);
		return this;
	}
	public MyDialog1 setBtnR(String s){
		btnR.setText(s);
		return this;
	}
	public MyDialog1 setBtnNum(int i){
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
		return this;
	}
	public void setBtnClick(android.view.View.OnClickListener...clickListeners){
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

	
}
