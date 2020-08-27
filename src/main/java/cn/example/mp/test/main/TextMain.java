package cn.example.mp.test.main;

import cn.example.mp.test.entity.SystemOrg;
import cn.example.mp.test.fileparam.DownloadRequest;
import cn.example.mp.test.fileparam.FileResponse;
import cn.example.mp.test.util.DateUtil;
import cn.example.mp.test.util.ExcelUtil;
import cn.example.mp.test.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author: xianpei.qin
 * @create: 2020-03-17 15:18
 **/
public class TextMain {

    public static void main(String[] args)  {

        HandlerMethod handlerMethod = null;
        RequestMappingInfo mappingInfo = null;
        RequestMappingHandlerMapping requestMappingHandlerMapping = null;
        DispatcherServlet dispatcherServlet = null;
        AbstractHandlerMapping mapping = null;
        AbstractHandlerMethodMapping abstractHandlerMethodMapping = null;


    }


}