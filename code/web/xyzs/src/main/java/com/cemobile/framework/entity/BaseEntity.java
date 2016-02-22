package com.cemobile.framework.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.org.rapid_framework.util.DateConvertUtils;

public class BaseEntity
  implements Serializable
{
  /** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
protected static final String DATE_FORMAT = "yyyy-MM-dd";
  protected static final String TIME_FORMAT = "HH:mm:ss";
  protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
  private String sortColumns;
  private List<?> conditions;

  public BaseEntity()
  {
    this.sortColumns = null;
    this.conditions = null;
  }

  public static String date2String(Date date, String dateFormat)
  {
    return DateConvertUtils.format(date, dateFormat);
  }

  public static <T extends Date> T string2Date(String dateString, String dateFormat, Class<T> targetResultType) {
    return DateConvertUtils.parse(dateString, dateFormat, targetResultType);
  }

  public static Date string2Date(String dateString, String dateFormat) {
    return DateConvertUtils.parse(dateString, dateFormat);
  }

  public List<?> getConditions()
  {
    return this.conditions;
  }

  public void setConditions(List<?> conditions) {
    this.conditions = conditions;
  }

  public String getSortColumns() {
    return this.sortColumns;
  }

  public void setSortColumns(String sortColumns) {
    this.sortColumns = sortColumns;
  }
}