package cn.example.mp.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author qinxianpei
 * @date 2020-04-23 20:44
 */
public class PropertiesUtil {

    public static Properties getProperties(String fileName) throws IOException {
        Properties pts = new Properties();
        ClassLoader classL = PropertiesUtil.class.getClassLoader();
        InputStream is = null;
        try {
            is = classL.getResourceAsStream(fileName);
            pts.load(is);
            return pts;
        } catch (Exception e) {
            return null;
        }finally {
            is.close();
        }
    }
    public static String getProperties(String fileName,String key) throws IOException {
        Properties pts = new Properties();
        ClassLoader classL = PropertiesUtil.class.getClassLoader();
        InputStream is = null;
        try {
            is = classL.getResourceAsStream(fileName);
            pts.load(is);
            return pts.getProperty(key);
        } catch (Exception e) {
            return null;
        }finally {
            is.close();
        }
    }


}
