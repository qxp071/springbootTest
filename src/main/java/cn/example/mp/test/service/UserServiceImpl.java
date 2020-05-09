package cn.example.mp.test.service;

import cn.example.mp.test.entity.User;
import cn.example.mp.test.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qin
 * @since 2019-10-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>{

}
