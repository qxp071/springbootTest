package cn.example.mp.test.web.entity;

import java.util.List;

/**
 * @author: xianpei.qin
 * @create: 2020-03-25 19:45
 **/
public class Holiday {

    private String id;

    private String isWorkDay;

    private String holidayStartPoint;

    private List<HolidayApprovalPassList> holidayApprovalPassList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsWorkDay() {
        return isWorkDay;
    }

    public void setIsWorkDay(String isWorkDay) {
        this.isWorkDay = isWorkDay;
    }

    public String getHolidayStartPoint() {
        return holidayStartPoint;
    }

    public void setHolidayStartPoint(String holidayStartPoint) {
        this.holidayStartPoint = holidayStartPoint;
    }

    public List<HolidayApprovalPassList> getHolidayApprovalPassList() {
        return holidayApprovalPassList;
    }

    public void setHolidayApprovalPassList(List<HolidayApprovalPassList> holidayApprovalPassList) {
        this.holidayApprovalPassList = holidayApprovalPassList;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id='" + id + '\'' +
                ", isWorkDay='" + isWorkDay + '\'' +
                ", holidayStartPoint='" + holidayStartPoint + '\'' +
                ", holidayApprovalPassList=" + holidayApprovalPassList +
                '}';
    }
}