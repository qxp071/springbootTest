package cn.example.mp.test.sys.controller;


import cn.example.mp.test.common.ResultBody;
import cn.example.mp.test.sys.entity.SysLog;
import cn.example.mp.test.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-08-30
 */
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping("/save")
    public ResultBody save(SysLog sysLog){

        System.out.println(sysLog.toString());


        sysLogService.save(sysLog);

        return ResultBody.success();

    }

}

