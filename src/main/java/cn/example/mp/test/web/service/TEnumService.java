package cn.example.mp.test.web.service;

import cn.example.mp.test.web.entity.TEnum;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-09-07
 */
public interface TEnumService extends IService<TEnum> {

    List<TEnum> getListById(List<String> ids);

}
