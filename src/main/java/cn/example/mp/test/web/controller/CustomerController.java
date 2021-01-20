package cn.example.mp.test.web.controller;


import cn.example.mp.test.util.ExcelUtil;
import cn.example.mp.test.util.ExcelUtil2;
import cn.example.mp.test.web.entity.Customer;
import cn.example.mp.test.web.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 * 测试从数据库中查询-导出100万数据。耗时1分左右，导出文件31.1M
 * @author xianpei.qin
 * @since 2021-01-20
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("list")
    public ResponseEntity getCustomer() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        String expFielName = new String(("测试导出"+".xlsx").getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", expFielName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        List<Customer> list = customerService.list();
        List<Map> listMap = new ArrayList<>();
        for (Customer customer : list) {
            Map customerMap = new LinkedHashMap();
            customerMap.put("id", customer.getId());
            customerMap.put("userName", customer.getUserName());
            customerMap.put("birth", customer.getBirth());
            customerMap.put("sex", customer.getSex());
            customerMap.put("email", customer.getEmail());
            customerMap.put("mobile", customer.getMobile());
            customerMap.put("createDate", customer.getCreateDate());
            customerMap.put("updateDate", customer.getUpdateDate());
            customerMap.put("description", customer.getDescription());
            listMap.add(customerMap);

        }
        String[] columnTitles = { "id", "用户名", "生日","性别", "邮箱", "电话", "创建时间","修改时间", "备注"};
        byte[] bytes = ExcelUtil2.buildExcelSXSS(columnTitles, listMap);
        return new ResponseEntity(bytes, headers, HttpStatus.CREATED);

    }

}

