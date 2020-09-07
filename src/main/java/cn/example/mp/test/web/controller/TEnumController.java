package cn.example.mp.test.web.controller;


import cn.example.mp.test.common.ResultBody;
import cn.example.mp.test.web.entity.TEnum;
import cn.example.mp.test.web.service.TEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-09-07
 */
@RestController
@RequestMapping("/tEnum")
public class TEnumController {

    @Autowired
    private TEnumService enumService;

    /**
     * 一对多关系查询
     * @param ids
     * @return
     */
    @RequestMapping("/getA")
    public ResultBody getA(String ids){
        String[] split = ids.split(",");
        List<String> idList = Arrays.asList(split);

        List<TEnum> teList =  enumService.getListById(idList);

        return ResultBody.success(teList);

    }

}

