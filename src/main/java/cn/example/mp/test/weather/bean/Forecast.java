package cn.example.mp.test.weather.bean;

import lombok.Data;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/12 10:20
 */
@Data
public class Forecast {
    /**
     * 时间
     */
    private String date;
    /**
     * 最高气温
     */
    private String high;
    /**
     * 风力
     */
    private String fengli;
    /**
     * 最低气温
     */
    private String low;
    /**
     * 风向
     */
    private String fengxiang;
    /**
     * 天气类型
     */
    private String type;
}
