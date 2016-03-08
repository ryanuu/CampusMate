package com.campusmate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_PATTERN = "MM-dd HH:mm";
	public static final String DATE_TIME_PATTERN_TWO = "yyyy-MM-dd HH:mm";
	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			DATE_TIME_PATTERN);
	public static final SimpleDateFormat DATE_TIME_FORMAT_TWO = new SimpleDateFormat(
			DATE_TIME_PATTERN_TWO);

	public static String getCurrentTime() {
		Date date = new Date();
		Long time = date.getTime();
		return time.toString();
	}

	/*
	 * 将日期转成字符串格式
	 */
	public static String formatDateTime(Date date) {
		if (date == null)
			return "";
		return DATE_TIME_FORMAT.format(date);
	}

	public static String formatMemberDateTime(Date date) {
		if (date == null)
			return "";
		return DATE_TIME_FORMAT_TWO.format(date);
	}

	/*
	 * 将字符串转化成日期格式
	 */
	public static Date parseDateTime(String dateStr) {
		try {
			return DATE_TIME_FORMAT.parse(dateStr);
		} catch (ParseException ex) {
			return null;
		}
	}
	/*
	 * 将Long转化成日期格式
	 */
	public static String LongToDate(Long dateStr) throws ParseException {
		return DATE_TIME_FORMAT.format(new Date(dateStr)); 
	}
	/*
	 * 将Long转化成日期格式
	 */
	public static String LongToDate(Long dateStr,String TIME_PATTERN) throws ParseException {
		return new SimpleDateFormat(
				TIME_PATTERN).format(new Date(dateStr));
	}
	/*
	 * 将String转化成日期格式
	 */
	public static String StringToDate(String dateStr) {
		try {
			return DATE_TIME_FORMAT.format(DATE_TIME_FORMAT.parse(dateStr));
		} catch (ParseException ex) {
			return null;
		}
	}
	/*
	 * 比较两个日期的大小
	 */
	public static int Compare_Date(Long date1,Long date2) {
		Date dt1 = new Date(date1);
        Date dt2 = new Date(date2);;
        if (dt1.getTime() > dt2.getTime()) {
            System.out.println("dt1 在dt2前");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            System.out.println("dt1在dt2后");
            return -1;
        } else {
            return 0;
        }
	}
	/*
	 * 比较两个日期的大小
	 */
	public static int Compare_Date(String date1,String date2) {
		try {
            Date dt1 = DATE_TIME_FORMAT.parse(date1);
            Date dt2 = DATE_TIME_FORMAT.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
		} catch (ParseException ex) {
			ex.printStackTrace();
			return -2;
		}
	}
}