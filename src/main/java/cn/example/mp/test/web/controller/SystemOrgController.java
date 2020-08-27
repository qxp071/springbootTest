package cn.example.mp.test.web.controller;


import cn.example.mp.test.web.entity.SystemOrg;
import cn.example.mp.test.web.service.SystemOrgService;
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
import java.util.UUID;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author qin
 * @since 2020-03-17
 */
@Controller
@RequestMapping("/systemOrg")
public class SystemOrgController {


    @Autowired
    private SystemOrgService orgService;

    @GetMapping("/import")
    @ResponseBody
    public void importExcel() throws Exception {

        String file = "F:\\组织脱敏数据.xlsx";
        String fineName = "组织脱敏数据.xlsx";

        FileInputStream in = new FileInputStream(file);
        List<List<Object>> bankListByExcel = ExcelUtil.getBankListByExcel(in, fineName);

        List<SystemOrg> olist = new ArrayList<>();

        for (int i = 0; i < bankListByExcel.size(); i++) {
            List<Object> ob = bankListByExcel.get(i);
            SystemOrg org = new SystemOrg();
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.replace("-", "");
//            org.setId(uuid);
            org.setId(ob.get(0).toString());
            org.setOrgId(ob.get(0).toString());
            org.setOrgName(ob.get(1).toString());
            org.setAreaCode("440106");
            org.setAddress("广州天河区");
            org.setUporg(ob.get(3).toString());
            org.setRecordStopFlag("0");
            org.setCorporateFlag("0");
            org.setOperator("SuperAdmin");
            org.setOprNickname("超级管理员");
            org.setCreateTime(LocalDateTime.now());
            org.setUpdateTime(LocalDateTime.now());
            olist.add(org);
        }
        orgService.saveBatch(olist);
    }
}

