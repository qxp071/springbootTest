package cn.example.mp.test.main;

import cn.example.mp.test.util.DateUtil;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: xianpei.qin
 * @create: 2020-03-17 15:18
 **/
public class TextMain {

    public static void main(String[] args) throws ParseException {

       /* HandlerMethod handlerMethod = null;
        RequestMappingInfo mappingInfo = null;
        RequestMappingHandlerMapping requestMappingHandlerMapping = null;
        DispatcherServlet dispatcherServlet = null;
        AbstractHandlerMapping mapping = null;
        AbstractHandlerMethodMapping abstractHandlerMethodMapping = null;
*/

        Date time = Calendar.getInstance().getTime();
        String s = DateUtil.formatDate(time, "yyyy-MM-dd HH:mm");

        fff(s,"yyyy-MM-dd HH:mm:ss");


    }

    public static void fff(String time,String f) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(f);
        Date date = sdf.parse(time);
        String format1 = sdf.format(date);
        String time2 = format1.substring(0,format1.length()-3);
        System.out.println(time2);

    }



}