package cn.example.mp.test.util;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
	/**
     * 获取随机字符串，可用于加密 添加字符，增加保密度
     */
    private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 获取任意位的随机字符串(0-9 a-z A-Z)
     * 
     * @param size
     *            位数
     * @return
     */
    public static final String getRandomNum(int size) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }
    
    /**
     * md5加密(ITS)
     * 
     * @param str
     * @param charSet
     * @return
     */
    public synchronized static final String getMD5Str(String str, String charSet) { // md5加密
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            if (charSet == null) {
                messageDigest.update(str.getBytes());
            } else {
                messageDigest.update(str.getBytes(charSet));
            }
        } catch (NoSuchAlgorithmException e) {

        } catch (UnsupportedEncodingException e) {

        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }
	
	/**
	 * 使用md5的算法进行加密
	 * @param plainText 加密前的明文
	 * @return 加密后的密文
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
}