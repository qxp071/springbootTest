package cn.example.mp.test.util;

import cn.csg.fc.csgf.logger.CsgfLogger;
import cn.example.mp.test.constant.SasLagerScreenConst;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description 工具类
 * @Author yuanshiyu
 * @Date 2019/9/29 13:50
 * @VERSION 1.0
 */
public class SasLagerScreenUtil {

	/**
	 * CSGF日志
	 */
	public static final CsgfLogger CSGF_LOGGER = CsgfLogger.getBusinessLogger();

	/**
	 * 私有构造器
	 */
	private SasLagerScreenUtil() {
	}

	/**
	 * 返回校验异常信息
	 * @return
	 */
	public static final Map<String, Object> returnValidateResultInfo(int initialCapacity, String code, String msg){
		WeakHashMap<String, Object> weakParams = new WeakHashMap<>(initialCapacity);
		weakParams.put(SasLagerScreenConst.RESP_CODE_NAME, code);
		weakParams.put(SasLagerScreenConst.RESP_MSG_NAME, msg);
		return weakParams;
	}

	/**
	 * 返回校验异常信息
	 * @return
	 */
	public static final Map<String, Object> returnValidateResultInfo(int initialCapacity, String code, String msg, List<? extends Object> data){
		WeakHashMap<String, Object> weakParams = new WeakHashMap<>(initialCapacity);
		weakParams.put(SasLagerScreenConst.RESP_CODE_NAME, code);
		weakParams.put(SasLagerScreenConst.RESP_MSG_NAME, msg);
		weakParams.put(SasLagerScreenConst.RESP_DATA_NAME, data);
		return weakParams;
	}

	/**
	 * 返回校验异常信息
	 * @return
	 */
	public static final Map<String, Object> returnValidateResultInfo(int initialCapacity, String code, String msg, Map<String, ?> data){
		WeakHashMap<String, Object> weakParams = new WeakHashMap<>(initialCapacity);
		weakParams.put(SasLagerScreenConst.RESP_CODE_NAME, code);
		weakParams.put(SasLagerScreenConst.RESP_MSG_NAME, msg);
		//将多个Map合并成一个
		weakParams.putAll(data);
		return weakParams;
	}

	/**
	 * 校验时间字符串是否为特定格式
	 * @param targetTime
	 * @param reg
	 * @return
	 */
	public static final boolean validateRequestTime(String targetTime, String reg){
		return new WeakReference<Pattern>(Pattern.compile(reg)).get().matcher(targetTime).matches();
	}

	/**
	 * 字符串转日期
	 * @param targetTime
	 * @param toFomat
	 * @return
	 */
	public static Date strToDate(String targetTime, String toFomat){
		return new WeakReference<DateTime>(DateTime.parse(targetTime, DateTimeFormat.forPattern(toFomat))).get().toDate();
	}

	/**
	 * 获取下一天
	 * @author 袁诗雨
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getNextDate(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))).get()
				.plusDays(SasLagerScreenConst.DEFAULT_ONE_VALUE).toString(toFormat);
	}

	/**
	 * 获取去年最后一天
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getLastDayOfLastYear(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusYears(SasLagerScreenConst.DEFAULT_ONE_VALUE).monthOfYear().withMaximumValue()
						.dayOfMonth().withMaximumValue()).get().toString(toFormat);
	}

	/**
	 * 获取环比月份最后一天
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getLastDateOfYoyMonth(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusMonths(SasLagerScreenConst.DEFAULT_ONE_VALUE)
						.dayOfMonth().withMaximumValue()).get().toString(toFormat);
	}

	/**
	 * 获取目标时间对应年开始时间 xxxx-01-01
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getCurrentYearBeginTime(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.monthOfYear().withMinimumValue()
						.dayOfMonth().withMinimumValue()).get().toString(toFormat);
	}

	/**
	 * 获取去年同期时间
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getYearOnYearTime(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusYears(SasLagerScreenConst.DEFAULT_ONE_VALUE)).get().toString(toFormat);
	}

	/**
	 * 获取上月时间
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getMonthOnMonthTime(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusMonths(SasLagerScreenConst.DEFAULT_ONE_VALUE)).get().toString(toFormat);
	}

	/**
	 * 获取前年同期时间
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getTwoYearsAgoTime(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusYears(SasLagerScreenConst.DEFAULT_TWO_VALUE)).get().toString(toFormat);
	}

	/**
	 * 获取去年开始时间 xxxx-01-01
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getYearOnYearBeginTime(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))
						.minusYears(SasLagerScreenConst.DEFAULT_ONE_VALUE)
						.monthOfYear().withMinimumValue()
						.dayOfMonth().withMinimumValue()).get().toString(toFormat);
	}

	/**
	 * 返回季度开始年月和结束年月
	 * @param currentYear
	 * @param currentQuarter
	 * @return
	 */
	public static String[] getQuarterInMonth(Integer currentYear, Integer currentQuarter) {
		final int minVal = 1;
		final int maxVal = 4;
		final int[] startMonthsOfQuarters = {1, 4, 7, 10};
		final int[] endMonthsOfQuarters = {3, 6, 9, 12};
		if(currentQuarter == null || currentQuarter < minVal || currentQuarter > maxVal){
			return new String[SasLagerScreenConst.DEFAULT_ZORE_VALUE];
		}
		int index = currentQuarter - 1;
		return returnBeginMonthAndEndMonthOfQuarters(currentYear, startMonthsOfQuarters[index], endMonthsOfQuarters[index]);
	}

	/**
	 * 统计日期A与日期B之间的天数差
	 * @param beginDate
	 * @param endDate
	 * @param fromFormat
	 * @return
	 */
	public static final long durationDayBetweenTwoDate(String beginDate, String endDate, String fromFormat){
		return new WeakReference<Duration>(new Duration(
				new WeakReference<DateTime>(DateTime.parse(beginDate, DateTimeFormat.forPattern(fromFormat))).get(),
				new WeakReference<DateTime>(DateTime.parse(endDate, DateTimeFormat.forPattern(fromFormat))).get())
		).get().getStandardDays();
	}

	/**
	 * 处理返回季度开始年月和结束年月[]
	 * @param currentYear
	 * @param startMonthOfQuarter
	 * @param endMonthOfQuarter
	 * @return
	 */
	private static final String[] returnBeginMonthAndEndMonthOfQuarters(int currentYear, int startMonthOfQuarter, int endMonthOfQuarter){
		return new WeakReference<String[]>(new String[]{mergerYearAndMonthToYearMonthTime(currentYear, startMonthOfQuarter),
				mergerYearAndMonthToYearMonthTime(currentYear, endMonthOfQuarter)}).get();
	}

	/**
	 * 合并年份和月份为年月
	 * @param currentYear
	 * @param currentMonth
	 * @return
	 */
	private static final String mergerYearAndMonthToYearMonthTime(int currentYear, int currentMonth){
		return new WeakReference<DateTime>(DateTime.parse(new StringBuilder().append(currentYear).append(SasLagerScreenConst.DELIMITER_WHIPPLETREE)
						.append(currentMonth).toString(),
				DateTimeFormat.forPattern(SasLagerScreenConst.TIME_FORMAT_YYYY_MM))).get().toString(SasLagerScreenConst.TIME_FORMAT_YYYY_MM);
	}

	/**
	 * 获取输入月份最后一天
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getLastDayOfMonth(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))).get()
				.dayOfMonth().withMaximumValue().toString(toFormat);
	}


	/**
	 * 获取输入月份的第一天
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @return
	 */
	public static String getFirstDayOfMonth(String targetTime, String fromFormat, String toFormat){
		return new WeakReference<DateTime>(
				DateTime.parse(targetTime, DateTimeFormat.forPattern(fromFormat))).get()
				.dayOfMonth().withMinimumValue().toString(toFormat);
	}

	/**
	 * 获取所属旬开始时间和结束时间
	 *
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @param tenDays
	 * @return
	 */
	public static String[] getTenDayTime(String targetTime, String fromFormat, String toFormat, String tenDays) {
		String[] days = new String[2];
		switch (tenDays) {
			case "上旬":
				days[0] = getFirstDayOfMonth(targetTime, fromFormat, toFormat);
				days[1] = mergerYearAndMonthToYearMonthDay(targetTime, 10);
				break;
			case "中旬":
				days[0] = mergerYearAndMonthToYearMonthDay(targetTime, 11);
				days[1] = mergerYearAndMonthToYearMonthDay(targetTime, 20);
				break;
			case "下旬":
				days[0] = mergerYearAndMonthToYearMonthDay(targetTime, 21);
				days[1] = getLastDayOfMonth(targetTime, fromFormat, toFormat);
				break;
			default:
				days = null;
				break;
		}
		return days;
	}

	/**
	 * 获取当前上一旬开始时间和结束时间
	 *
	 * @param targetTime
	 * @param fromFormat
	 * @param toFormat
	 * @param tenDays
	 * @return
	 */
	public static String[] getLastTenDayTime(String targetTime, String fromFormat, String toFormat, String tenDays) {
		String[] days = new String[2];
		switch (tenDays) {
			case "上旬":
				days[0] = mergerYearAndMonthToYearMonthDay(getMonthOnMonthTime(targetTime, fromFormat, fromFormat), 21);
				days[1] = getLastDateOfYoyMonth(targetTime,  fromFormat, toFormat);
				break;
			case "中旬":
				days[0] = getFirstDayOfMonth(targetTime, fromFormat, toFormat);
				days[1] = mergerYearAndMonthToYearMonthDay(targetTime, 10);
				break;
			case "下旬":
				days[0] = mergerYearAndMonthToYearMonthDay(targetTime, 11);
				days[1] = mergerYearAndMonthToYearMonthDay(targetTime, 20);
				break;
			default:
				days = null;
				break;
		}
		return days;
	}

	/**
	 * 合并年月和日为年月日
	 *
	 * @param targetTime
	 * @param currentDay
	 * @return
	 */
	private static final String mergerYearAndMonthToYearMonthDay(String targetTime, int currentDay) {
		return new WeakReference<DateTime>(DateTime.parse(new StringBuilder().append(targetTime).append(SasLagerScreenConst.DELIMITER_WHIPPLETREE)
						.append(currentDay).toString(),
				DateTimeFormat.forPattern(SasLagerScreenConst.TIME_FORMAT_YYYY_MM_DD))).get().toString(SasLagerScreenConst.TIME_FORMAT_YYYY_MM_DD);
	}


	/**
	 * 将Map<String, Object>转换成Map<String, String>,主要作用是讲BigDecimal转为String 解决前端问题
	 *
	 * @param list
	 * @return
	 */
	public static List<Map<String, String>> mapObjectToString(List<Map<String, Object>> list){
		List<Map<String, String>> newList = null;
		if(!list.isEmpty()){
			newList = new ArrayList<>();
			Map<String, String> newMap = null;
			for (Map<String, Object> map : list) {
				newMap = new WeakHashMap<>();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					newMap.put(key, value.toString());
				}
				newList.add(newMap);
			}
		}
		return newList;
	}

}
