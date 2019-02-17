package com.xy5120.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *  Class Name: DateUtil.java
 *  Description: 日期工具类
 *  @author xy  DateTime 2018-12-6 下午06:00:19 
 *  @version 1.0
 */
public class DateUtil {
	public static void main(String[] args) {
	}
	
	
	/**
	 * 
	 *  Description:根据给定的日期格式把毫秒值转成固定格式的字符串
	 *  @author xy  DateTime 2018-12-6 下午06:24:17
	 *  @param time 毫秒值
	 *  @param sformat	日期类型
	 *  @return
	 */
	public static String getStringDate(long time,String sformat){
		/*
          SimpleDateFormat函数语法：
         yy-MM-dd
          G 年代标志符
          y 年
          M 月
          d 日
          h 时 在上午或下午 (1~12)
          H 时 在一天中 (0~23)
          m 分
          s 秒
          S 毫秒
          E 星期
          D 一年中的第几天
          F 一月中第几个星期几
          w 一年中第几个星期
          W 一月中第几个星期
          a 上午 / 下午 标记符
          k 时 在一天中 (1~24)
          K 时 在上午或下午 (0~11)
          z 时区
         */
	    SimpleDateFormat formatter = new SimpleDateFormat(sformat);  
	    String dateString = formatter.format(new Date(time));
		return dateString;
	}
	/**
	 * 
	 *  Description:获取sqlDate现在时间
	 *  @author xy  DateTime 2018-12-6 下午06:11:01
	 *  @return  "yyyy-MM-dd HH:mm:ss "
	 */
	public static Date getSqlDate() {  
	    Date sqlDate = new java.sql.Date(new Date().getTime());  
	    return sqlDate;  
	}  
	
	/**
	 * 
	 *  Description:判断日期格式和范围 是否正确
	 *  @author xy  DateTime 2018-12-6 下午06:02:45
	 *  @param date "yyyy-MM-dd"
	 *  @return
	 */
	public static boolean isDate(String date){
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";  
        Pattern pat = Pattern.compile(rexp);    
        Matcher mat = pat.matcher(date);    
        boolean dateType = mat.matches();  

        return dateType;  
	}
	
	/**
	 * 
	 *  Description:根据年月日计算年龄,birthTimeString:"yy-MM-dd"
	 *  @author xy  DateTime 2018-12-6 下午06:02:05
	 *  @param birthTimeString
	 *  @return
	 */
	public static int getAgeFromBirthTime(String birthTimeString) {
		//判断是否无数据
		if(birthTimeString==""||birthTimeString==null){
			return -1;
		}
		// 先截取到字符串中的年、月、日
		String strs[] = birthTimeString.trim().split("-");
		int selectYear = Integer.parseInt(strs[0]);
		int selectMonth = Integer.parseInt(strs[1]);
		int selectDay = Integer.parseInt(strs[2]);
		// 得到当前时间的年、月、日
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayNow = cal.get(Calendar.DATE);
 
		// 用当前年月日减去生日年月日
		int yearMinus = yearNow - selectYear;
		int monthMinus = monthNow - selectMonth;
		int dayMinus = dayNow - selectDay;
 
		int age = yearMinus;// 先大致赋值
		if (yearMinus < 0) {// 选了未来的年份
			age = 0;
		} else if (yearMinus == 0) {// 同年的，要么为1，要么为0
			if (monthMinus < 0) {// 选了未来的月份
				age = 0;
			} else if (monthMinus == 0) {// 同月份的
				if (dayMinus < 0) {// 选了未来的日期
					age = 0;
				} else if (dayMinus >= 0) {
					age = 1;
				}
			} else if (monthMinus > 0) {
				age = 1;
			}
		} else if (yearMinus > 0) {
			if (monthMinus < 0) {// 当前月>生日月
			} else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄
				if (dayMinus < 0) {
				} else if (dayMinus >= 0) {
					age = age + 1;
				}
			} else if (monthMinus > 0) {
				age = age + 1;
			}
		}
		return age;
	}

	/**
	 * 
	 *  Description:根据毫秒值计算年龄
	 *  @author xy  DateTime 2018-12-6 下午06:01:28
	 *  @param birthTimeLong
	 *  @return
	 */
	public static int getAgeFromBirthTime(long birthTimeLong) {
		Date date = new Date(birthTimeLong * 1000l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String birthTimeString = format.format(date);
		return getAgeFromBirthTime(birthTimeString);
	}
}
