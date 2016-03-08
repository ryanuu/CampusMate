package com.campusmate.activity;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.campusmate.BaseActivity2;
import com.campusmate.R;
import com.campusmate.commondata.CommonData;
import com.campusmate.resultbean.LoginResultBean;
import com.campusmate.utils.Config_PT;
import com.campusmate.utils.GsonAnalyze;
import com.campusmate.utils.HttpClient;
import com.campusmate.utils.TextIsEmpty;
import com.google.gson.stream.JsonReader;
import com.lidroid.xutils.http.ResponseInfo;

public class LoginActivity extends BaseActivity2 implements OnClickListener{
	private EditText userAccount;
	private EditText userPassword;
	private RadioButton rememberBtn;
	private TextView rememberTv;
	private RadioButton autolBtn;
	private TextView autolTv;
	private TextView student;
	private TextView teacher;
	private TextView loginBtn;
	
	private LoginResultBean bean;
	private boolean RememberAP=true;//记住密码
	private boolean AutoLogin=false;//自动登陆
	private String role="1";//角色，默认为学生

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.login);
		super.onCreate(savedInstanceState);	
	}

	@Override
	protected void initviewAndListener() {
		// TODO Auto-generated method stub
		super.initviewAndListener();
		userAccount = (EditText)findViewById( R.id.user_account );
		userPassword = (EditText)findViewById( R.id.user_password );
		rememberBtn = (RadioButton)findViewById( R.id.remember_btn );
		rememberTv = (TextView)findViewById( R.id.remember_tv );
		autolBtn = (RadioButton)findViewById( R.id.autol_btn );
		autolTv = (TextView)findViewById( R.id.autol_tv );
		student = (TextView)findViewById( R.id.student );
		teacher = (TextView)findViewById( R.id.teacher );
		loginBtn = (TextView)findViewById( R.id.login_btn );

		rememberBtn.setOnClickListener( this );
		rememberTv.setOnClickListener(this);
		autolBtn.setOnClickListener( this );
		autolTv.setOnClickListener(this);
		student.setOnClickListener(this);
		teacher.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
	}

	@Override
	protected void initAsyc() {
		// TODO Auto-generated method stub
		super.initAsyc();
		String state=Config_PT.getSharePreStr(this, CommonData.LoginInfo,
				CommonData.LoginState);
		Log.e("loginstate", state);
		if("1".equals(state)){//自动登陆
			AutoLogin=true;
			autolBtn.setChecked(true);
			userAccount.setText(Config_PT.getSharePreStr(this, CommonData.LoginInfo,
				CommonData.LoginAccount));
			userPassword.setText(Config_PT.getSharePreStr(this, CommonData.LoginInfo,
					CommonData.LoginPassword));
			role=Config_PT.getSharePreStr(this, CommonData.LoginInfo,
					CommonData.LoginRole);
			if("1".equals(role)){//角色为学生
				student.setEnabled(false);
				teacher.setEnabled(true);
			}else{//角色为老师
				student.setEnabled(true);
				teacher.setEnabled(false);
			}
			httpPost();
		}else if("2".equals(state)){//记住密码
			rememberBtn.setChecked(true);
			RememberAP=true;
			userAccount.setText(Config_PT.getSharePreStr(this, CommonData.LoginInfo,
					CommonData.LoginAccount));
			userPassword.setText(Config_PT.getSharePreStr(this, CommonData.LoginInfo,
					CommonData.LoginPassword));
			role=Config_PT.getSharePreStr(this, CommonData.LoginInfo,
					CommonData.LoginRole);
			if("1".equals(role)){//角色为学生
				student.setEnabled(false);
				teacher.setEnabled(true);
			}else{//角色为老师
				student.setEnabled(true);
				teacher.setEnabled(false);
			}
			userPassword.requestFocus();
		}else{//空
			student.performClick();
			rememberBtn.setChecked(true);
			RememberAP=true;
		}
		
	}
	private void httpPost(){
//		String url=CommonData.HttpUrl+"login";
		String url=CommonData.HttpUrl;
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("act", "login");
		map.put("username", userAccount.getText().toString());
		map.put("password", userPassword.getText().toString());
		map.put("role", role);
		map.put("os", "1");
		HttpClient.Post(url, map, rc, mContext);
	}
	

	@Override
	protected void httpSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		super.httpSuccess(arg0);
		bean=GsonAnalyze.analyze(arg0.result, LoginResultBean.class);
		if(checkResultData(bean)){
			saveUserInfo(arg0.result);			
			if(AutoLogin){//如果设置成自动登陆（自动登陆保含记住密码）
				HashMap<String, String> map=new HashMap<String, String>();
				map.put(CommonData.LoginState,"1");
				map.put(CommonData.LoginAccount, userAccount.getText().toString());
				map.put(CommonData.LoginPassword, userPassword.getText().toString());
				map.put(CommonData.LoginRole, role);
				saveLoginInfo(map);
				
			}else if(RememberAP){//如果设置成记住密码
				HashMap<String, String> map=new HashMap<String, String>();
				map.put(CommonData.LoginState,"2");
				map.put(CommonData.LoginAccount, userAccount.getText().toString());
				map.put(CommonData.LoginPassword, userPassword.getText().toString());
				map.put(CommonData.LoginRole, role);
				saveLoginInfo(map);
			}else{
				HashMap<String, String> map=new HashMap<String, String>();
				map.put(CommonData.LoginState,"0");
				saveLoginInfo(map);
			}
			Intent intent =new Intent(this,MainActivity.class);
			startActivity(intent);
//			this.finish();
		}
	    Config_PT.showToast(this, bean.getCodeText());
		
		
	}
	//保存用户信息
		public void saveUserInfo(String jsondata){
			try{
				JSONObject jsonobject=new JSONObject(jsondata);
				JSONArray jsonlist=jsonobject.getJSONArray("data");
				JSONObject jsonmap=jsonlist.getJSONObject(0);
				Iterator<String> nameItr = jsonmap.keys();			
				String name;
				String s="";
				while(nameItr.hasNext()){
					name=nameItr.next();
					Config_PT.putSharePre(mContext, CommonData.UserInfo, name, jsonmap.getString(name));
					s+=name+":"+jsonmap.getString(name)+"  ";
				}
				Log.e("saveUserInfo", s);
			}catch(Exception e){
				Log.e("saveUserInfo", "failed");
				e.printStackTrace();				
			}
			
		}
   //保存登陆信息：是否记住密码，是否自动登陆
		public void saveLoginInfo(HashMap<String, String> map){
			String s="";
			for (HashMap.Entry<String, String> entry : map.entrySet()) {
				Config_PT.putSharePre(this, CommonData.LoginInfo,
						entry.getKey(), entry.getValue()); 
				s+=(entry.getKey()+":"+ entry.getValue()+"   ");
	         }
			Log.e("saveLoginInfo", s);
		}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.remember_btn:
		case R.id.remember_tv:
			rememberBtn.setChecked(!rememberBtn.isChecked());
			RememberAP=rememberBtn.isChecked();
			break;
		case R.id.autol_btn:
		case R.id.autol_tv:
			autolBtn.setChecked(!autolBtn.isChecked());
			AutoLogin=autolBtn.isChecked();
			//自动登陆默认包含记住密码
			if(autolBtn.isChecked()){
				rememberBtn.setChecked(true);
				RememberAP=true;
			}		
			break;
		case R.id.student:
			student.setEnabled(false);
			teacher.setEnabled(true);
			role="1";
			break;
		case R.id.teacher:
			student.setEnabled(true);
			teacher.setEnabled(false);		
			role="2";
			break;
		case R.id.login_btn:
			//判断账号是否为空
		    if(TextIsEmpty.isEmpty(userAccount.getText().toString())){
		    	Config_PT.showToast(this, "学号/工号 不能为空");
		    	break;
		    }
		    //判断密码是否为空
		    else if(TextIsEmpty.isEmpty(userPassword.getText().toString())){
		    	Config_PT.showToast(this, "密码 不能为空");
		    	break;
		    }
		    httpPost();
			break;
		}
	}

	
}
