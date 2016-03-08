package com.campusmate.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campusmate.R;
import com.campusmate.adview.Advertisements;
import com.campusmate.bean.CourseList;
import com.campusmate.commondata.CommonData;
import com.campusmate.resultbean.CourseListBean;
import com.campusmate.utils.Config_PT;
import com.campusmate.utils.GsonAnalyze;
import com.campusmate.utils.HttpClient;
import com.lidroid.xutils.http.ResponseInfo;

public class MyChildFragment extends BaseFragment{
	private TextView courseMorning;
	private LinearLayout course1;
	private LinearLayout course2;
	private LinearLayout adLl;
	private TextView courseAternoon;
	private LinearLayout course3;
	private LinearLayout course4;
	private TextView courseNight;
	private LinearLayout course5;
	private LinearLayout course6;
	private int currentdate=0;//当前fragment所显示的时间
	private boolean reCreateView=false;;
	private boolean isFrist=true;
	private CourseListBean result_bean;
	private int httpTag=0;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.syllabus, container,false);
		Log.e("childFragment", "createView");
		initAsyc();
		initView(view);
		initAd(inflater);
		//是否重新填充数据
        if(reCreateView||isFrist){
        	initData(currentdate*CommonData.ONE_DAY+CommonData.CURRENT_DAY);
        }
        isFrist=false;
        reCreateView=false;
		Log.e("initCreate", reCreateView+"");
		return view;
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
//		Log.e("UserVisibleHit", isVisibleToUser+"");
		super.setUserVisibleHint(isVisibleToUser);
	}


	public void reCreateView(int data){
		currentdate=data;
		reCreateView=true;
		Log.e("reCreateView", "childFrament"+"   "+reCreateView);
	}
	@Override
	public void initData(Long data) {
		// TODO Auto-generated method stub	
		Log.e("initData", "childFragment");
		httpPost1();
		super.initData(data);
	}
	private void initAsyc(){
		
	}
	private void initView(View view){
		courseMorning=(TextView)view.findViewById(R.id.course_morning);
		course1 = (LinearLayout)view.findViewById( R.id.course_1 );
		course2 = (LinearLayout)view.findViewById( R.id.course_2 );
		adLl = (LinearLayout)view.findViewById( R.id.ad_course_ll );
		courseAternoon=(TextView)view.findViewById(R.id.course_afternoon);
		course3 = (LinearLayout)view.findViewById( R.id.course_3 );
		course4 = (LinearLayout)view.findViewById( R.id.course_4 );
		courseNight=(TextView)view.findViewById(R.id.course_night);
		course5 = (LinearLayout)view.findViewById( R.id.course_5 );
		course6 = (LinearLayout)view.findViewById( R.id.course_6 );
		
		((TextView)course2.findViewById(R.id.course_start)).setText("3");
		((TextView)course2.findViewById(R.id.course_end)).setText("4");
		((TextView)course3.findViewById(R.id.course_start)).setText("5");
		((TextView)course3.findViewById(R.id.course_end)).setText("6");
		((TextView)course4.findViewById(R.id.course_start)).setText("7");
		((TextView)course4.findViewById(R.id.course_end)).setText("8");
		((TextView)course5.findViewById(R.id.course_start)).setText("9");
		((TextView)course5.findViewById(R.id.course_end)).setText("10");
		((TextView)course6.findViewById(R.id.course_start)).setText("11");
		((TextView)course6.findViewById(R.id.course_end)).setText("12");
		//设置上课时间
//		setCourseTime(i, text);
		//设置签到状态(此行代码应该放在请求签到数据返回后调用)
//		setCourseSign(i)
	}
	//设置当前课程背景色改变
	private void setCurrentCourse(int i,boolean b){
		switch(i){
		case 1:
			((LinearLayout)course1.findViewById(R.id.backgraound)).setEnabled(b);
			((TextView)course1.findViewById(R.id.course_name)).setEnabled(b);
			((TextView)course1.findViewById(R.id.course_time)).setEnabled(b);
			((TextView)course1.findViewById(R.id.course_address)).setEnabled(b);
			((TextView)course1.findViewById(R.id.course_signin)).setEnabled(b);
			((TextView)course1.findViewById(R.id.course_signout)).setEnabled(b);
			setCurrentCourse(6, true);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		}
	}
	//设置课程内容，如果课程名称和上课地点
	private void setCourseContent(int i,CourseList bean){
		switch(i){
		case 1:
			((TextView)course1.findViewById(R.id.course_name)).setText(bean.getCurriculumName());
			if("2".equals(bean.getCourseType())){
				TextView time=(TextView)course1.findViewById(R.id.course_time);
				time.setText(bean.getStartDate()+"-"+bean.getEndDate());
			}		
			((TextView)course1.findViewById(R.id.course_address)).setText(bean.getPositionName());
			break;
        case 2:
        	((TextView)course2.findViewById(R.id.course_name)).setText(bean.getCurriculumName());
			if("2".equals(bean.getCourseType())){
				TextView time=(TextView)course2.findViewById(R.id.course_time);
				time.setText(bean.getStartDate()+"-"+bean.getEndDate());
			}		
			((TextView)course2.findViewById(R.id.course_address)).setText(bean.getPositionName());
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		}
	}
	//设置上课时间
	private void setCourseTime(int i,String text){
		switch(i){
		case 1:
			((TextView)course1.findViewById(R.id.course_time)).setText(text);
			break;
        case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		}
	}
	//设置签到状态
	private void setCourseSign(int i){
		switch(i){
		case 1:
//			((TextView)course1.findViewById(R.id.course_signin)).setText();
//			((TextView)course1.findViewById(R.id.course_signout)).setText(text);
			break;
        case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		}
	}
	public void initAd(LayoutInflater inflater){
		JSONArray advertiseArray = new JSONArray();
		try {
			JSONObject head_img0 = new JSONObject();
			head_img0.put("head_img","http://pic.nipic.com/2008-08-12/200881211331729_2.jpg");
			JSONObject head_img1 = new JSONObject();
			head_img1.put("head_img","http://pic1.ooopic.com/uploadfilepic/sheji/2010-01-12/OOOPIC_1982zpwang407_20100112ae3851a13c83b1c4.jpg");
			JSONObject head_img2 = new JSONObject();
			head_img2.put("head_img","http://pic1.ooopic.com/uploadfilepic/sheji/2009-09-12/OOOPIC_wenneng837_200909122b2c8368339dd52a.jpg");
			advertiseArray.put(head_img0);
			advertiseArray.put(head_img1);
			advertiseArray.put(head_img2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adLl.addView(new Advertisements(this.getActivity(), true, inflater, 3000).initView(advertiseArray));
	}
	private void httpPost1(){
		httpTag=1;
		String url=CommonData.HttpUrl;
//		String url=CommonData.HttpUrl+"107";
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("act", "107");
		map.put("ticket", Config_PT.getSharePreStr(mContext, CommonData.UserInfo, "ticket"));
		map.put("weekNo", "");
		map.put("weekday", "");
		map.put("classId", "");
		map.put("tremId", "");
		HttpClient.Post(url, map, rc_f, mContext);
	}
	private void httpPost2(){
		httpTag=2;
	}

	@Override
	protected void httpSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		switch(httpTag){
		case 1://获取课程表信息
			result_bean=GsonAnalyze.analyze(arg0.result, CourseListBean.class);
			if(checkResultData(result_bean)){
				ArrayList<CourseList> array=(ArrayList<CourseList>)
						result_bean.getData().get(0).getCourseList();
				if(array==null){
					Config_PT.showToast(mContext, "获取不到课程表信息..");
					return;
				}
				for(int i=0;i<array.size();i++){
					setCourseContent(Integer.valueOf(array.get(i).getSection()),
							array.get(i));
				}
				//获取课程表信息后紧接着获取签到信息
				httpPost2();
			}else{
				Config_PT.showToast(mContext, result_bean.getCodeText());
			}
			break;
		case 2://获取签到信息
			
			break;
		}
		
		
		super.httpSuccess(arg0);
	}
	
	   
}
