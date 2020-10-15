/**
  * Copyright 2020 bejson.com 
  */
package cn.example.mp.test.weather.aliyu;

/**
 * Auto-generated: 2020-10-14 10:26:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class City {


    /**
     * 城市iD
     */
    private int cityId;
    /**
     * 国家
     */
    private String counName;

    /**
     * 标准时区
     */
    private String ianatimeZone;
    /**
     * 城市名称
     */
    private String name;
    /**
     * 上级区域名称
     */
    private String pname;
    /**
     * 二级城市名
     */
    private String secondaryname;
    /**
     * 时区
     */
    private String timezone;
    public void setCityId(int cityId) {
         this.cityId = cityId;
     }
     public int getCityId() {
         return cityId;
     }

    public void setCounname(String counname) {
         this.counName = counname;
     }
     public String getCounname() {
         return counName;
     }

    public void setIanatimezone(String ianatimezone) {
         this.ianatimeZone = ianatimezone;
     }
     public String getIanatimezone() {
         return ianatimeZone;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPname(String pname) {
         this.pname = pname;
     }
     public String getPname() {
         return pname;
     }

    public void setSecondaryname(String secondaryname) {
         this.secondaryname = secondaryname;
     }
     public String getSecondaryname() {
         return secondaryname;
     }

    public void setTimezone(String timezone) {
         this.timezone = timezone;
     }
     public String getTimezone() {
         return timezone;
     }

}