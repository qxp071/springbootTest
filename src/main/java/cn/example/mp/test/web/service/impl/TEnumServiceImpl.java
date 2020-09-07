package cn.example.mp.test.web.service.impl;

import cn.example.mp.test.web.entity.TEnum;
import cn.example.mp.test.web.mapper.TEnumMapper;
import cn.example.mp.test.web.service.TEnumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-09-07
 */
@Service
public class TEnumServiceImpl extends ServiceImpl<TEnumMapper, TEnum> implements TEnumService {

    @Autowired
    private TEnumMapper mapper;

    @Override
    public List<TEnum> getListById(List<String> ids) {
        return mapper.getListById(ids);
    }
}
