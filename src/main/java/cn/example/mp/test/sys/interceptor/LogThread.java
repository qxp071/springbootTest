package cn.example.mp.test.sys.interceptor;

import cn.example.mp.test.sys.entity.SysLog;
import cn.example.mp.test.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/08/30 15:14
 */
@Component
public class LogThread extends Thread {

    @Autowired
    private SysLogService sysLogService;

    public  LinkedBlockingQueue<SysLog> interceptorLogQueue = new LinkedBlockingQueue<>();

    //声明一个本类的静态成员变量，以保存bean
    public static LogThread logThread;

    /**
     * 解决@Component注解下Autowired注入失败
     * postConstruce注解的作用是：注解在方法上，表示此方法是在Spring实例化该bean之后马上执行此方法，之后才会去实例化其他bean
     * 这样在Spring实例化LogThread之后，马上执行此方法，初始化logThread静态对象和成员变量sysLogService
     */
    @PostConstruct
    public void init(){
        logThread = this;
        logThread.sysLogService = this.sysLogService;
    }

    @Override
    public void run() {
        try {
            SysLog log = interceptorLogQueue.take();
            logThread.sysLogService.save(log);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
