/**
  * Copyright 2020 bejson.com 
  */
package cn.example.mp.test.weather.aliyu;
import java.util.List;

/**
 * Auto-generated: 2020-10-14 10:26:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */public class WeatherData {

    private City city;
    private List<Forecast> forecast;
    private Condition condition;
    public void setCity(City city) {
         this.city = city;
     }
     public City getCity() {
         return city;
     }

    public void setForecast(List<Forecast> forecast) {
         this.forecast = forecast;
     }
     public List<Forecast> getForecast() {
         return forecast;
     }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}