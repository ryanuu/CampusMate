package com.cemobile.framework.entity;

/**
 * 
 * 创建人：chenzx
 * 创建时间：2016年4月8日下午3:18:10
 * 类说明：课程表实体类
 * 修改人：无
 * 修改时间：无
 * 修改说明：无
 */
public class CourseList extends LabCourseList{

	private static final long serialVersionUID = 1L;
	
	private String place;			//场地（教学楼、操场）
	private String number;			//位置编号
	private int positionType;		//位置类型
	private String positionName;	//上课位置
	private String curriculumName;	//课程名字
	private int startWeek;			//课程开始周
	private int endWeek;			//课程结束周
	private Long teacherId;			//老师id
	private String teacherName;		//老师名字
	private String startTime;		//考试开始时间
	private String endTime;			//考试结束时间
	private int weeke;				//考试周
	private String uuid;			//蓝牙标识
	
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPositionType() {
		return positionType;
	}
	public void setPositionType(int positionType) {
		this.positionType = positionType;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getCurriculumName() {
		return curriculumName;
	}
	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}
	public int getStartWeek() {
		return startWeek;
	}
	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}
	public int getEndWeek() {
		return endWeek;
	}
	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getWeeke() {
		return weeke;
	}
	public void setWeeke(int weeke) {
		this.weeke = weeke;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
