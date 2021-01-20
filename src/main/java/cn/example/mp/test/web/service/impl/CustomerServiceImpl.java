package cn.example.mp.test.web.service.impl;

import cn.example.mp.test.web.entity.Customer;
import cn.example.mp.test.web.mapper.CustomerMapper;
import cn.example.mp.test.web.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianpei.qin
 * @since 2021-01-20
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {


}
