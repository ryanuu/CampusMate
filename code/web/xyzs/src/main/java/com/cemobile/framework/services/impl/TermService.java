package com.cemobile.framework.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cemobile.framework.common.page.Page;
import com.cemobile.framework.dao.TermMapper;
import com.cemobile.framework.entity.Term;
import com.cemobile.framework.entity.Week;
import com.cemobile.framework.services.ITermService;

@Service
@Transactional
public class TermService implements ITermService {
	
	@Autowired
	private TermMapper termMapper;
	
	@Override
	public Page queryByKeyword(Term term,Page page){
			List<Term> resultList=termMapper.queryByKeyword(term,page);
			page.setResult(resultList);
			return page;
	}

	@Override
    public Page queryAllTerm(Page page) {
        List<Term> labTermList=termMapper.queryAllTerm(page);
        page.setResult(labTermList);
        return page;
    }
	
	@Override
	public Term selectByKeyword(Long id) {
		// TODO Auto-generated method stub
		return termMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Week> selectWeek(Long collegeId) {
		
		List<Week> weekList=new ArrayList<Week>();
		Long tremId=null;
		String tremName="";
		
		//用collegeId查询学期信息
		Term term=new Term();
		term.setCollegeId(collegeId);
		List<Term> resultList=termMapper.queryByKeyword(term, new Page());
		if(resultList.size()>0){
			//学期开始时间
			Date termCdate=new Date();
			//学期结束时间
			Date termNdate=new Date();
			for(Term m:resultList){
				if(termCdate.getTime()>=m.getCreateDate().getTime() && termCdate.getTime()<=m.getEndDate().getTime()){
					termCdate=m.getStartDate();
					termNdate=m.getEndDate();
					tremId=m.getTermId();
					tremName=m.getTermName();
				}
			}
			
			//开始为本年第几周
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(termCdate);
			
			int weekNo=1;
			while(calendar.getTime().getTime()<=termNdate.getTime()){
				Week week=new Week();
				week.setWeekNo(Long.valueOf(weekNo));
				if(weekNo==1){
					int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
					if(dayWeek<2){
						//周一为第一天
						calendar.add(calendar.DATE,2-dayWeek);
					}
					else{
						dayWeek=dayWeek-2;
					}
					week.setStartDate(calendar.getTime());
					//日期加7
					calendar.add(calendar.DATE,6-dayWeek);
					week.setEndDate(calendar.getTime());
				}
				else{
					//日期加1
					calendar.add(calendar.DATE,1);
					week.setStartDate(calendar.getTime());
					//日期加7
					calendar.add(calendar.DATE,6);
					week.setEndDate(calendar.getTime());
				}
				week.setTremId(tremId);
				week.setTremName(tremName);
				weekList.add(week);
				weekNo++;
			}
		}
		
		
		return weekList;
	}
	

}
