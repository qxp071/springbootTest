package cn.example.mp.test.sys.util;

import cn.example.mp.test.sys.entity.SysLog;
import cn.example.mp.test.sys.interceptor.LogThread;
import cn.example.mp.test.util.IpUtil;
import cn.example.mp.test.util.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/08/30 15:30
 */
public class LogUtil{

    public static void saveLog(HttpServletRequest request, Object handler, Exception ex)  {
        SysLog log = new SysLog();
        log.setRequestUri(request.getRequestURI());
        log.setMethod(request.getMethod());
        log.setUserAgent(request.getHeader("user-agent"));
        log.setParams(request.getQueryString());
        log.setRemoteAddr(IpUtil.getIp2(request));
        try {
            LogThread logThread = new LogThread();
            logThread.interceptorLogQueue.put(log);
            ThreadPoolManager.newInstance().addExecuteTask(logThread);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
