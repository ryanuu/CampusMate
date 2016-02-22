package com.campusmate.dialogandpop;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.campusmate.R;

public class MyProgressBar1 extends Dialog{
	
	private TextView pbtv;
	public MyProgressBar1(Context context){
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_progressbar);
		pbtv=(TextView)findViewById(R.id.pbtv);
	}
	public void setText(String text){
		pbtv.setText(text);
	}
	
}
