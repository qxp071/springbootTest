/**
  * Copyright 2020 bejson.com 
  */
package cn.example.mp.test.weather.aliyu;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @Date  
 **/
public class Forecast {

    /**
     * 白天天气
     */
    private String conditionDay;
    /**
     * 白天天气 id
     */
    private String conditionIdDay;
    /**
     * 夜间天气id
     */
    private String conditionIdNight;
    /**
     * 夜间天气 id
     */
    private String conditionNight;
    /**
     * 湿度
     */
    private String humidity;
    private String pop;
    /**
     * 预报日期
     */
    private Date predictDate;
    private String qpf;
    /**
     * 白天温度
     */
    private String tempDay;
    /**
     * 夜间温度
     */
    private String tempNight;
    /**
     * 更新时间
     */
    private Date updateTime;
    private String uvi;
    /**
     * 白天风向角度
     */
    private String windDegreesDay;
    /**
     * 夜间风向角度
     */
    private String windDegreesNight;
    /**
     * 白天风向
     */
    private String windDirDay;
    /**
     * 夜间风向
     */
    private String windDirNight;
    /**
     * 白天风级
     */
    private String windLevelDay;
    /**
     * 夜间风级
     */
    private String windLevelNight;
    public void setConditionDay(String conditionDay) {
         this.conditionDay = conditionDay;
     }
     public String getConditionDay() {
         return conditionDay;
     }

    public void setConditionIdDay(String conditionIdDay) {
         this.conditionIdDay = conditionIdDay;
     }
     public String getConditionIdDay() {
         return conditionIdDay;
     }

    public void setConditionIdNight(String conditionIdNight) {
         this.conditionIdNight = conditionIdNight;
     }
     public String getConditionIdNight() {
         return conditionIdNight;
     }

    public void setConditionNight(String conditionNight) {
         this.conditionNight = conditionNight;
     }
     public String getConditionNight() {
         return conditionNight;
     }

    public void setHumidity(String humidity) {
         this.humidity = humidity;
     }
     public String getHumidity() {
         return humidity;
     }

    public void setPop(String pop) {
         this.pop = pop;
     }
     public String getPop() {
         return pop;
     }

    public void setPredictDate(Date predictDate) {
         this.predictDate = predictDate;
     }
     public Date getPredictDate() {
         return predictDate;
     }

    public void setQpf(String qpf) {
         this.qpf = qpf;
     }
     public String getQpf() {
         return qpf;
     }

    public void setTempDay(String tempDay) {
         this.tempDay = tempDay;
     }
     public String getTempDay() {
         return tempDay;
     }

    public void setTempNight(String tempNight) {
         this.tempNight = tempNight;
     }
     public String getTempNight() {
         return tempNight;
     }

    public void setUpdateTime(Date updatetime) {
         this.updateTime = updatetime;
     }
     public Date getUpdateTime() {
         return updateTime;
     }

    public void setUvi(String uvi) {
         this.uvi = uvi;
     }
     public String getUvi() {
         return uvi;
     }

    public void setWindDegreesDay(String windDegreesDay) {
         this.windDegreesDay = windDegreesDay;
     }
     public String getWindDegreesDay() {
         return windDegreesDay;
     }

    public void setWindDegreesNight(String windDegreesNight) {
         this.windDegreesNight = windDegreesNight;
     }
     public String getWindDegreesNight() {
         return windDegreesNight;
     }

    public void setWindDirDay(String windDirDay) {
         this.windDirDay = windDirDay;
     }
     public String getWindDirDay() {
         return windDirDay;
     }

    public void setWindDirNight(String windDirNight) {
         this.windDirNight = windDirNight;
     }
     public String getWindDirNight() {
         return windDirNight;
     }

    public void setWindLevelDay(String windLevelDay) {
         this.windLevelDay = windLevelDay;
     }
     public String getWindLevelDay() {
         return windLevelDay;
     }

    public void setWindLevelNight(String windLevelNight) {
         this.windLevelNight = windLevelNight;
     }
     public String getWindLevelNight() {
         return windLevelNight;
     }

}