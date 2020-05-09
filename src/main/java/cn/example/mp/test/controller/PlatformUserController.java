package cn.example.mp.test.controller;


import cn.example.mp.test.entity.PlatformUser;
import cn.example.mp.test.service.PlatformUserService;
import cn.example.mp.test.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author qin
 * @since 2020-03-17
 */
@Controller
@RequestMapping("/platformUser")
public class PlatformUserController {


    @Autowired
    private PlatformUserService userService;

    @GetMapping("/import")
    @ResponseBody
    public void importExcel() throws Exception {

        String file = "F:\\用户脱敏数据.xlsx";
        String fineName = "用户脱敏数据.xlsx";

        FileInputStream in = new FileInputStream(file);
        List<List<Object>> bankListByExcel = ExcelUtil.getBankListByExcel(in, fineName);

        List<PlatformUser> olist = new ArrayList<>();

        for (int i = 0; i < bankListByExcel.size(); i++) {
            List<Object> ob = bankListByExcel.get(i);

            PlatformUser user = new PlatformUser();

            user.setUserId(ob.get(0).toString().trim());
            user.setOrgId(ob.get(4).toString());
            user.setUserName(ob.get(3).toString());
            user.setNickName(ob.get(1).toString());
            user.setCreateUsername("SuperAdmin");
            user.setCreateNickname("超级管理员");
            user.setUpdateUsername("SuperAdmin");
            user.setUpdateNickname("超级管理员");
            user.setUserPwd("bba01dbf2b69772112780a4d2212326d2d3fe511");
            user.setUserSalt("578f8d7c1294b4ed");
            user.setUserType("D");
            user.setLockFlag("0");
            user.setShortcutFlag("1");
            user.setStopFlag("0");
            user.setResetFlag("1");
            user.setPwdUpdateTime(LocalDateTime.now());
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());

            olist.add(user);

        }

        userService.saveBatch(olist);

    }

}

