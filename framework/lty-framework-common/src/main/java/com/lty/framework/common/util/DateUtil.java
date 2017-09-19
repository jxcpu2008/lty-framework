package com.lty.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @描述: 日期工具类
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
public class DateUtil {

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符串
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符串
	 */
	public static String formatL(Date date) {

		return format(date, "yyyy-MM-dd") + " 23:59:59";
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
		return "";
	}

	public static String formatF(Date date) {

		return format(date, "yyyy-MM-dd") + " 00:00:00";
	}

	/**
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符串
	 */
	public static String formatTime(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @param pattern
	 *            字符串格式
	 * @return 日期字符串
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "null";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @return 日期类型
	 */
	public static Date format(String date) {
		return format(date, null);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @param pattern
	 *            格式
	 * @return 日期类型
	 */
	public static Date format(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return new Date();
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}

	static SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat yearF = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat yearM = new SimpleDateFormat("MM");

	/**
	 * 获取当年的第一天
	 * 
	 * @param year
	 * @return
	 */
	public static String getCurrYearFirst(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, Integer.parseInt(yearF.format(d)));
		Date currYearFirst = calendar.getTime();
		String beginTime1 = datef.format(currYearFirst) + " 00:00:00";
		return beginTime1;
	}

	/**
	 * 获取当年的最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static String getCurrYearLast(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, Integer.parseInt(yearF.format(d)));
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		String endTime1 = datef.format(currYearLast) + " 23:59:59";
		return endTime1;
	}

	/**
	 * 获取去年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static String getYearFirst(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, Integer.parseInt(yearF.format(d)) - 1);
		Date currYearFirst = calendar.getTime();
		String beginTime1 = datef.format(currYearFirst) + " 00:00:00";
		return beginTime1;
	}

	/**
	 * 获取去年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static String getYearLast(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, Integer.parseInt(yearF.format(d)) - 1);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		String endTime1 = datef.format(currYearLast) + " 23:59:59";
		return endTime1;
	}

	/**
	 * 获取某月第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static String getMonthFirst(Date d) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(d); // someDate 为你要获取的那个月的时间
		ca.set(Calendar.DAY_OF_MONTH, 1);
		// 第一天
		Date firstDate = ca.getTime();
		ca.add(Calendar.MONTH, 1);
		String beginTime1 = datef.format(firstDate) + " 00:00:00";
		return beginTime1;
	}

	/**
	 * 获取某月最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static String getMonthLast(Date d) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(d); // someDate 为你要获取的那个月的时间
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);
		// 最后一天
		Date lastDate = ca.getTime();
		String endTime1 = datef.format(lastDate) + " 23:59:59";
		return endTime1;
	}

}
