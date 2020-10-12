package cn.example.mp.test.weather.bean;

import lombok.Data;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/12 10:19
 */
@Data
public class WeatherResponse {

    /**
     * 天气数据
     */
    private WeatherData data;
    /**
     * 响应状态
     */
    private int status;
    /**
     * 响应描述
     */
    private String desc;
}
