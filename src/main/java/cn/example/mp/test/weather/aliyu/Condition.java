package cn.example.mp.test.weather.aliyu; /**
 * Copyright 2020 bejson.com
 */
import java.util.Date;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @Date
 **/
public class Condition {

    private String condition;
    private String humidity;
    private String icon;
    private String temp;
    private Date updatetime;
    private String vis;
    private String windDegrees;
    private String windDir;
    private String windLevel;
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getCondition() {
        return condition;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getHumidity() {
        return humidity;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIcon() {
        return icon;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
    public String getTemp() {
        return temp;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }
    public String getVis() {
        return vis;
    }

    public void setWindDegrees(String windDegrees) {
        this.windDegrees = windDegrees;
    }
    public String getWindDegrees() {
        return windDegrees;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }
    public String getWindDir() {
        return windDir;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }
    public String getWindLevel() {
        return windLevel;
    }

}