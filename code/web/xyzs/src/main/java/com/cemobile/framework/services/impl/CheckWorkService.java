package com.cemobile.framework.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.dao.LabCheckWorkMapper;
import com.cemobile.framework.dao.TimeMapper;
import com.cemobile.framework.entity.CheckWork;
import com.cemobile.framework.entity.LabCheckWork;
import com.cemobile.framework.entity.PlaytimeTime;
import com.cemobile.framework.services.ICheckWorkService;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年4月11日下午3:54:49
 * 类说明：签到模块服务层
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
@Service
@Transactional
public class CheckWorkService implements ICheckWorkService{
	
	@Autowired
    private LabCheckWorkMapper labCheckWorkMapper;
	@Autowired
	private TimeMapper timeMapper;
	
	@Override
	public CheckWork insert(CheckWork checkWork) {
		// TODO Auto-generated method stub
		//获取签到课程的上下课时间
		PlaytimeTime playtimeTime=new PlaytimeTime();
		playtimeTime.setTermId(checkWork.getTermId());
		playtimeTime.setSection(checkWork.getSection());
		List<PlaytimeTime> timeList=timeMapper.queryByKeyword(playtimeTime);
		PlaytimeTime time=timeList.get(0);
		
		//获取上课签到数据
		
		List<LabCheckWork> checkWorkList=labCheckWorkMapper.queryByKeyword(checkWork);
		
		//获取当前时间
		Date date=new Date();
		
		//上课签到
		if(checkWorkList.size()==0){
			try {
				//转换时间格式
				SimpleDateFormat format2 = new SimpleDateFormat("hh:mm:ss");
				Date startDate;//上课时间
				Date endDate;//下课时间
				startDate = format2.parse(time.getStartDate());
				endDate=format2.parse(time.getEndDate());
				if(date.getTime()>startDate.getTime() && date.getTime()<=endDate.getTime()){
					checkWork.setStatus("1");//迟到
				}
				else if(date.getTime()<=startDate.getTime()){
					checkWork.setStatus("0");//签到
				}
				else{
					checkWork.setStatus("2");//旷课
				}
				checkWork.setStartDate(date);
				checkWork.setDel(0);
				//将数据添加到数据库
				long i=labCheckWorkMapper.insert(checkWork);
				checkWork.setCheckId(i);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			//下课签到
			try {
				//转换时间格式
				SimpleDateFormat format2 = new SimpleDateFormat("hh:mm:ss");
				Date startDate;//上课时间
				Date endDate;//下课时间
				startDate = format2.parse(time.getStartDate());
				endDate=format2.parse(time.getEndDate());
				//获取上课签到的数据
				LabCheckWork labCheckWork=new LabCheckWork();
				labCheckWork=checkWorkList.get(0);
				
				if(date.getTime()>startDate.getTime() && date.getTime()<=endDate.getTime()){
					labCheckWork.setStatus(labCheckWork.getStatus()+",1");//迟到
				}
				else if(date.getTime()<=startDate.getTime()){
					labCheckWork.setStatus(labCheckWork.getStatus()+",0");//签到
				}
				else{
					checkWork.setStatus("3");//早退
				}
				labCheckWork.setEndDate(date);
				//将数据添加到数据库
				labCheckWorkMapper.updateByPrimaryKey(labCheckWork);
				checkWork.setCheckId(labCheckWork.getCheckId());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return checkWork;
	}

}
