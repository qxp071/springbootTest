package cn.example.mp.test.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: xianpei.qin
 * @create: 2019-10-29 10:49
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MyException.class)
    public ResultBody bizException(){

        return ResultBody.error("系统发生异常，请联系管理员！");
    }
}