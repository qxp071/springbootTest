package cn.example.mp.test.constant;

/**
 * @Description 常量类
 * @Author yuanshiyu
 * @Date 2019/9/29 13:45
 * @VERSION 1.0
 */
public final class SasLagerScreenConst {

	private SasLagerScreenConst() {
	}

	/**
	 * return_code_name
	 */
	public static final String RESP_CODE_NAME = "resultCode";

	/**
	 * return_msg_name
	 */
	public static final String RESP_MSG_NAME = "resultType";

	/**
	 * return_data_name
	 */
	public static final String RESP_DATA_NAME = "dataArray";


	/**
	 * 正则匹配YYYY-MM
	 */
	public static final String REG_YYYY = "^(\\d{4})$";


	/**
	 * 正则匹配YYYY-MM
	 */
	public static final String REG_YYYY_MM = "^(\\d{4})-(\\d{2})$";

	/**
	 * 正则匹配YYYY-MM-DD
	 */
	public static final String REG_YYYY_MM_DD = "^(\\d{4})-(\\d{2})-(\\d{2})$";

	/**
	 * 时间格式 YYYY
	 */
	public static final String TIME_FORMAT_YYYY = "yyyy";

	/**
	 * 时间格式 YYYY-MM
	 */
	public static final String TIME_FORMAT_YYYY_MM = "yyyy-MM";

	/**
	 * 时间格式 YYYY-MM
	 */
	public static final String TIME_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	/**
	 * 横杠‘-’拼接符
	 */
	public static final String DELIMITER_WHIPPLETREE = "-";
	/**
	 * 0值
	 */
	public static final int DEFAULT_ZORE_VALUE = 0;
	/**
	 * 1值
	 */
	public static final int DEFAULT_ONE_VALUE = 1;

	/**
	 * 2值
	 */
	public static final int DEFAULT_TWO_VALUE = 2;
	/**
	 * 查询关键字-全公司
	 */
	public static final String QUARY_KEY_ALL_COMPANY = "全公司";

}
