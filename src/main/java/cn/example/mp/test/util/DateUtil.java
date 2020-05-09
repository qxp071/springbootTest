package cn.example.mp.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <p>Description:	日期工具类	<p>
 *
 * @author tangwy
 * @date 2019年7月22日
 */
public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    public static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";
    public static final String SIMPLE_DATE = "yyyy-MM";
    public static final String SIMPLEDATE = "yyyyMM";
    public static final String SIMPLE_TIME = "HH:mm";
    public static final String SIMPLE_DATE_PATTERN2 = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_DATE_PATTERN3 = "yyyy-MM-dd hh:mm:ss.SSS";
    public static final String SIMPLE_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String SIMPLE_DATE_PATTERN4 = "yyyy/MM/dd";
    public static final String DATE_DAY_FLAG="d";
    public static final String DATE_HOUR_FLAG="h";
    public static final String DATE_MINUTE_FLAG="m";
    public static final String DATE_SECEND_FLAG="s";
    public static final String DATE_MOUTH_FLAG="mh";
    public static final String DATE_YEAR_FLAG="y";
    public static final String SINPLEDATE_YYMMDD = "YYYYMMDD";
    public static final String SIMPLETIME_HHMMSS = "HHMMSS";

    public static final String ERROR_MSG = "dateUtil error :{}";

    private DateUtil() {
    }

    /**
     * 根据整型返回日期
     * @param year
     * @param month
     * @param dayOfMonth
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date ofDate(int year, int month, int dayOfMonth, int hour, int minute, int second){
    	return Date.from(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static String currentMonthNumberOne() {
    	// 获取当前月的第一天  
	    SimpleDateFormat format = new SimpleDateFormat(SIMPLE_DATE_PATTERN);  
	    Calendar cale = Calendar.getInstance();  
	    cale.add(Calendar.MONTH, 0);  
	    cale.set(Calendar.DAY_OF_MONTH, 1);  
	    return format.format(cale.getTime()); 
    }
    
    
    
    public static Date parseSimpleDate(final String source) {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (Exception e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return date;

    }
    
    public static Date parseSimpleDate2(final String source) {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN4);
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (Exception e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return date;

    }
    
    public static Date parseSimpleDate3(final String source) {
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN2);
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (Exception e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return date;

    }

    public static Date parseSimpleDate(String source, String format) {
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return date;

    }
    
    public static Date stringToDate(String dateString,String parrentString){
    	final SimpleDateFormat sdf = new SimpleDateFormat(parrentString, Locale.SIMPLIFIED_CHINESE);
    	Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return date;
    }

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
        String newDate = null;
        newDate = sdf.format(date);
        return newDate;

    }

    /**
     * @param date
     * @return
     */
    public static String formatDate2(Date date) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN2);
        String newDate = null;
        newDate = sdf.format(date);
        return newDate;

    }

    /**
     * 获取与日期date间隔range天的日期
     * @param date 日期
     * @param range 间隔日期，可传入负数.
     * @return
     */
    public static Date rangeDate(final Date date, final int range) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, range);
        return calendar.getTime();
    }

    /** 计算两个日期之间的天数差
     *  2018-01-20 和 2018-01-21 天数差为1
     * @param dateFrom 起始日期
     * @param dateTo 终止日期
     * @return
     */
    public static long diffDay(Date dateFrom, Date dateTo) {
        if (dateFrom == null || dateTo == null) {
            return 0;
        }
        return (trim(dateTo).getTime() - trim(dateFrom).getTime()) / (1000 * 60 * 60 * 24);
    }
    /**
     * 比较这个日期的相差数
     * @param diffType Calendar.SECOND,Calendar.MINUTE,Calendar.HOUR,Calendar.DATE
     * @param dateFrom 起始时间
     * @param dateTo 结束时间
     * @return
     */
    public static long diff(int diffType,Date dateFrom, Date dateTo){
    	if (dateFrom == null || dateTo == null) {
            return 0;
        }
    	long timeFrom=dateFrom.getTime();
    	long timeTo=dateTo.getTime();
    	long diffTime=timeTo-timeFrom;
    	
    	long diffTimeSecond=diffTime/1000;
    	if(diffType==Calendar.SECOND){
    		return diffTimeSecond;
    	}
    	long diffTimeMinute=diffTimeSecond/60;
    	if(diffType==Calendar.MINUTE){
    		return diffTimeMinute;
    	}
    	long diffTimeHour=diffTimeMinute/60;
    	
    	if(diffType==Calendar.HOUR){
    		return diffTimeHour;
    	}
    	long diffTimeDate=diffTimeMinute/24;
    	if(diffType==Calendar.DATE){
        	return diffTimeDate;
    	}
    	return diffTimeHour;
    }
    
    /**
     * 计算日期往后增加n天
     * @param from  起始日
     * @param n  增加的天数
     * @return
     */
    public static Date addDay(Date from, int n){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        calendar.add(Calendar.DAY_OF_YEAR, n);
        return calendar.getTime();
    }

    /**
     * 截断时分秒
     * @param date
     * @return
     */
    public static Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 格式化日期
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }
    
    
    /** 比较两个日期大小, 比较忽略时分秒毫秒
     * @param date1
     * @param date2
     * @return 0 代表相等
     *         1 代表date1 大于 date2
     *         -1 代表date1 小于date2
     */
    public static int compare(Date date1, Date date2){
        long dateLong1 = trim(date1).getTime();
        long dateLong2 = trim(date2).getTime();
        if(dateLong1 > dateLong2){
            return 1;
        }else if(dateLong1 < dateLong2){
            return -1;
        }else {
            return 0;
        }
    }
    /**
     * 只取年月
     * @param date
     * @return
     */
    public static String formatDate3(Date date) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE);
        String newDate = null;
        newDate = sdf.format(date);
        return newDate;
    }
    
    /**
     * 只取年月
     * @param date
     * @return
     */
    public static String formatDate4(Date date) {
        if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLEDATE);
        String newDate = null;
        newDate = sdf.format(date);
        return newDate;
    }
    /**
     * 获取格式 yyMMdd 格式日期
     * @param date
     * @return
     */
    public static String formatDate5(Date date){
        if (date == null){
            return  null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SINPLEDATE_YYMMDD);
        return sdf.format(date);
    }

    /**
     * 获取
     * @param date
     * @return
     */
    public static String formatDate6(Date date){
        if (date == null){
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLETIME_HHMMSS);
        return sdf.format(date);
    }
    
    /**
     * date转timestamp
     * @param date
     * @return
     */
	public static Timestamp dateToTimestamp(Date date) {
		SimpleDateFormat formatTimestamp = new SimpleDateFormat(SIMPLE_DATE_PATTERN2);
		return Timestamp.valueOf(formatTimestamp.format(date));
	}
	
	 /**
     * 字符串转timestamp
     * @param
     * @return
     */
	public static Timestamp strToTimestamp(String dateStr) {
		return Timestamp.valueOf(dateStr);
	}
	/**
     * date转timestamp
     * @param date
     * @return
     */
    public static String dateToTimes(Date date) {
    	if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_TIME);
        String newDate = null;
        newDate = sdf.format(date);
        return newDate;
    }
    /**
     * 取上一个月
     * @param date
     * @return
     */
    public static String getLastMonth(Date date) {
    	if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date m = calendar.getTime();
        final SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE);
        return sdf.format(m);
    }
    /**
     * 只取日
     * @param date
     * @return
     */
    public static String getDay(Date date) {
    	if (date == null) {
            return null;
        }
        final SimpleDateFormat sdf2= new SimpleDateFormat("dd");
        return sdf2.format(date);
    }
   
    /**
     * 获取当前时间的上个月最后一天
     * @param date
     * 
     */
    public static  Date getLastMonthLastDate(Date date) {
    	Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        // 往前推一个月
		cal.add(Calendar.MONTH, -1);
        // 获取这个月的最大日期时间
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
    }

    /**
     *  获取时间在星期的第几天
     * @param date
     * @return
     */
    public static int getDateOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 比较当前日期是否大于对比日期
     * date1 当前日期
     * date2 对比日期
     * **/
    public static boolean compareStringDate( String date1 , String date2 ){
        DateFormat sdf = new SimpleDateFormat(SINPLEDATE_YYMMDD);
        boolean mark = false ;
        try {
           if(sdf.parse(date1).getTime()<=sdf.parse(date2).getTime()){
                mark = true ;
            }
        } catch (ParseException e) {
            LOGGER.error(ERROR_MSG, e.getMessage(), e);
        }
        return mark ;
    }

}

