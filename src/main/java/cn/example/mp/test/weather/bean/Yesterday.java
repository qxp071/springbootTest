package cn.example.mp.test.weather.bean;

import lombok.Data;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/12 10:20
 */
@Data
public class Yesterday {
    /**
     * 时间
     */
    private String date;
    /**
     * 最高气温
     */
    private String high;
    /**
     * 风向
     */
    private String fx;
    /**
     * 最低气温
     */
    private String low;
    /**
     * 风力
     */
    private String fl;
    /**
     * 天气类型（阴，晴，多云，雨。。。）
     */
    private String type;
}
