package cn.example.mp.test.weather.bean;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/12 10:19
 */
@Data
public class WeatherData {

    /**
     * 昨天的天气
     */
    private Yesterday yesterday;
    /**
     * 城市
     */
    private String city;
    /**
     * 今天的天气及预测未来几天的天气数据
     */
    private List<Forecast> forecast;
    /**
     * 感冒穿衣指数
     */
    private String ganmao;
    private String wendu;
}
