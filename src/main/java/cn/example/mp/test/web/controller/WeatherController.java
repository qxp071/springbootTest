package cn.example.mp.test.web.controller;

import cn.example.mp.test.util.HttpUtils;
import cn.example.mp.test.weather.aliyu.City;
import cn.example.mp.test.weather.aliyu.JsonRootBean;
import cn.example.mp.test.weather.aliyu.WeatherResult;
import cn.example.mp.test.weather.bean.Forecast;
import cn.example.mp.test.weather.bean.WeatherResponse;
import cn.example.mp.test.weather.bean.Yesterday;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/14 09:34
 */
@RestController
public class WeatherController {

    /**
     * 万年历天气接口
     * @param city
     * @return
     */
    @RequestMapping("getWeather/{city}")
    public Object weatherData(@PathVariable("city") String city){
        String weatherUrl = "http://wthrcdn.etouch.cn/weather_mini?city=";
        String weather = getWeather(city, weatherUrl);
        Gson gson = new Gson();
        WeatherResponse response = gson.fromJson(weather, WeatherResponse.class);
        String city1 = response.getData().getCity();
        Forecast today = response.getData().getForecast().get(0);
        Forecast tomorrow = response.getData().getForecast().get(1);
        Forecast third = response.getData().getForecast().get(2);
        /*Forecast fourth = response.getData().getForecast().get(3);
        Forecast fifth = response.getData().getForecast().get(4);*/

        //明天的天气预报
        WeatherResult tomorrowWeather = new WeatherResult();
        tomorrowWeather.setHigh(tomorrow.getHigh());
        tomorrowWeather.setLow(tomorrow.getLow());
        tomorrowWeather.setWeatherType(tomorrow.getType());
        //后天的天气预报
        WeatherResult thirdWeather = new WeatherResult();
        thirdWeather.setHigh(third.getHigh());
        thirdWeather.setLow(third.getLow());
        thirdWeather.setWeatherType(third.getType());

        Map<String,Object> resultMap = new LinkedHashMap<>(6);
        resultMap.put("city",city1);
        resultMap.put("currentTemp",response.getData().getWendu()+"°C");
        resultMap.put("windDir",today.getFengxiang());
        String str = today.getFengli();
        String substring = str.substring(str.lastIndexOf("[") + 1, str.indexOf("]"));
        resultMap.put("windLevel",substring);
        resultMap.put("high",today.getHigh());
        resultMap.put("low",today.getLow());

        resultMap.put("tomorrow",tomorrowWeather);
        resultMap.put("third",thirdWeather);
        return resultMap;
    }
    public static String getWeather(String city, String weatherUrl) {
        byte[] bytes = null;
        String result = null;
        try {
            // 创建httpclient对象
            CloseableHttpClient client = HttpClients.createDefault();
            // 创建带参数的url
            URIBuilder uriBuilder = new URIBuilder(weatherUrl+city);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            CloseableHttpResponse response = client.execute(httpGet);
            int httpCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 按指定编码转换结果实体为byte数组
                bytes = EntityUtils.toByteArray(entity);
            }
            EntityUtils.consume(entity);
            response.close();
            client.close();
            result = new String(bytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object getMojiWheather(){

        return "";

    }

    /**
     * 墨迹天气
     * @return
     */
    @RequestMapping("getAliyuntWeather")
    public  Object AliyunWeather() {
        Gson gson  = new Gson();
        String current = getCurrent();
        String threeDay = getThreeDay();
        JsonRootBean currentWeather = gson.fromJson(current, JsonRootBean.class);
        JsonRootBean threeDayWeather = gson.fromJson(threeDay, JsonRootBean.class);
        //城市
        City city = currentWeather.getData().getCity();
        //当前温度
        String temp = currentWeather.getData().getCondition().getTemp();
        //当前天气状况
        String condition = currentWeather.getData().getCondition().getCondition();
        //今天天最高气温
        String tempDay = threeDayWeather.getData().getForecast().get(0).getTempDay();
        //今天最低气温
        String tempNight = threeDayWeather.getData().getForecast().get(0).getTempNight();
        //风向
        String windDirDay = threeDayWeather.getData().getForecast().get(0).getWindDirDay();
        //风力
        String windLevelDay = threeDayWeather.getData().getForecast().get(0).getWindLevelDay();

        //明天天最高气温
        String tomorrowTempDay = threeDayWeather.getData().getForecast().get(1).getTempDay();
        //明天最低气温
        String tomorrowTempNight = threeDayWeather.getData().getForecast().get(1).getTempNight();
        //明天天气状况
        String tomorrowConditionDay = threeDayWeather.getData().getForecast().get(1).getConditionDay();

        //后天最高气温
        String thirdTempDay = threeDayWeather.getData().getForecast().get(2).getTempDay();
        //后天最低气温
        String thirdTempNight = threeDayWeather.getData().getForecast().get(2).getTempNight();
        //后天天气状况
        String thirdConditionDay = threeDayWeather.getData().getForecast().get(2).getConditionDay();

        //今天天气
        WeatherResult todayResult = new WeatherResult();
        todayResult.setHigh(tempDay);
        todayResult.setLow(tempNight);
        todayResult.setWeatherType(condition);

        //明天天气
        WeatherResult tomorrowResult = new WeatherResult();
        tomorrowResult.setHigh(tomorrowTempDay);
        tomorrowResult.setLow(tomorrowTempNight);
        tomorrowResult.setWeatherType(tomorrowConditionDay);

        //后天天气
        WeatherResult thirdResult = new WeatherResult();
        thirdResult.setHigh(thirdTempDay);
        thirdResult.setLow(thirdTempNight);
        thirdResult.setWeatherType(thirdConditionDay);

        Map<String,Object> map = new LinkedHashMap<>(6);
        map.put("city",city.getName());
        map.put("currentTemp",temp);
        map.put("windDir",windDirDay);
        map.put("windLevel",windLevelDay+"级");
        map.put("today",todayResult);
        map.put("tomorrow",tomorrowResult);
        map.put("third",thirdResult);
        return map;

    }


    /**
     * 今天精简预报
     */
    public String getCurrent(){

        String result = null;
        String host = "https://freecityid.market.alicloudapi.com";
        String path = "/whapi/json/alicityweather/briefcondition";
        String method = "POST";
        String appcode = "815b4ea80ac948af8d25e233a776f0d4";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("cityId", "886");
        //bodys.put("token", "815b4ea80ac948af8d25e233a776f0d4");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            result = EntityUtils.toString(response.getEntity());
           // System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 三天天气预报
     */
    public String getThreeDay(){
        String result = null;
        String host = "https://freecityid.market.alicloudapi.com";
        String path = "/whapi/json/alicityweather/briefforecast3days";
        String method = "POST";
        String appcode = "815b4ea80ac948af8d25e233a776f0d4";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("cityId", "886");
        //bodys.put("token", "815b4ea80ac948af8d25e233a776f0d4");
        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            result = EntityUtils.toString(response.getEntity());
           // System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }


}
