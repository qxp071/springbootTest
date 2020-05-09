package cn.example.mp.test.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author: xianpei.qin
 * @create: 2020-04-12 15:47
 **/
public class XMLUtils {

    /**
     *
     * @param clazz
     *            类的字节码文件
     * @param xml
     *            传入的XML字符串
     * @return XML字符串转实体类
     */
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        T t = (T) xStream.fromXML(xml);
        return t;
    }

    /**
     *
     *
     * @param obj
     *            实体类
     * @return 实体类转XML字符串
     */
    public static String toXml(Object obj) {
        XStream xStream = new XStream(new DomDriver());
        // 扫描@XStream注解
        xStream.processAnnotations(obj.getClass());
        //正则过滤双下划线转为单下划线
        return xStream.toXML(obj).replaceAll("\\_+", "_");
    }

}