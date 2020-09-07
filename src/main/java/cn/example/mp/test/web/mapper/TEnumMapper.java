package cn.example.mp.test.web.mapper;

import cn.example.mp.test.web.entity.TEnum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-09-07
 */
public interface TEnumMapper extends BaseMapper<TEnum> {

    List<TEnum> getListById(@Param("list") List<String> idList);

}
