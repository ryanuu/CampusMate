package com.campusmate.dialogandpop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.campusmate.R;

public class MyProgressBar1{
	private Context context;
	private AlertDialog dialog;
	private String content="";
	public MyProgressBar1(Context context){
		this.context=context;
	}
	public MyProgressBar1(Context context,String content){
		this.context=context;
		this.content=content;
	}

	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void show(){
		dialog=new AlertDialog.Builder(context).create();
		//点击外部区域不能取消dialog 
		dialog.setCanceledOnTouchOutside(false);
		dialog.setOnKeyListener(keylistener);
		dialog.show();

		Window window = dialog.getWindow();
		window.setContentView(R.layout.common_progressbar);
		//设置背景半透明
		WindowManager.LayoutParams winlp = dialog.getWindow()  
		        .getAttributes();  
		winlp.alpha = 0.5f; // 0.0-1.0 
		window.setAttributes(winlp);
		TextView tv_content = (TextView) window.findViewById(R.id.pbtv);
		if(!"".equals(content))
		tv_content.setText(content);
		window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
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
	
}
