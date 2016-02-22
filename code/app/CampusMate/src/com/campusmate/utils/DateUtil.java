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
	public static String LongToDate(Long dateStr) {
		try {
			return DATE_TIME_FORMAT.format(DATE_TIME_FORMAT.parse(dateStr+""));
		} catch (ParseException ex) {
			return null;
		}
	}
	/*
	 * 将Double转化成日期格式
	 */
	public static String DoubleToDate(Double dateStr) {
		try {
			return DATE_TIME_FORMAT.format(DATE_TIME_FORMAT.parse(dateStr+""));
		} catch (ParseException ex) {
			return null;
		}
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
}