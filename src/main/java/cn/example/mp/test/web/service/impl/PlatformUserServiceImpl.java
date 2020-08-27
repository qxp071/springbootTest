package cn.example.mp.test.web.service.impl;

import cn.example.mp.test.web.entity.PlatformUser;
import cn.example.mp.test.web.mapper.PlatformUserMapper;
import cn.example.mp.test.web.service.PlatformUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qin
 * @since 2020-03-17
 */
@Service
public class PlatformUserServiceImpl extends ServiceImpl<PlatformUserMapper, PlatformUser> implements PlatformUserService {

}
