package cn.example.mp.test.weather.aliyu;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/14 10:42
 */
public class WeatherResult {

    //天气类型
    private String weatherType;

    //最高气温
    private String high;

    //最低气温
    private String low;

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String hight) {
        this.high = hight;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
