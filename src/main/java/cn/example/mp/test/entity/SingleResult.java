package cn.example.mp.test.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业单笔查询返回报文
 * @author: xianpei.qin
 * @create: 2020-04-11 11:31
 **/
@XStreamAlias("SingleResult")
public class SingleResult {

    @XStreamAlias("resCode")
    private String resCode;

    @XStreamAlias("resMsg")
    private String resMsg;

    @XStreamAlias("htmlStr")
    private String htmlStr;

    @XStreamAlias("htmlmd5")
    private String htmlmd5;

    @XStreamAlias("xmlStr")
    private String xmlStr;

    @XStreamAlias("xmlmd5")
    private String xmlmd5;

    @XStreamAlias("jsonStr")
    private String jsonStr;

    @XStreamAlias("jsonmd5")
    private String jsonmd5;

    @XStreamAlias("pdfStr")
    private String pdfStr;

    @XStreamAlias("pdfmd5")
    private String pdfmd5;

    @XStreamAlias("reportSource")
    private String reportSource;

    @XStreamAlias("reportVersion")
    private String reportVersion;

    @XStreamAlias("creditreportNo")
    private String creditreportNo;

    @XStreamAlias("reqID")
    private String reqID;

    @XStreamAlias("usetime")
    private String usetime;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getHtmlStr() {
        return htmlStr;
    }

    public void setHtmlStr(String htmlStr) {
        this.htmlStr = htmlStr;
    }

    public String getHtmlmd5() {
        return htmlmd5;
    }

    public void setHtmlmd5(String htmlmd5) {
        this.htmlmd5 = htmlmd5;
    }

    public String getXmlStr() {
        return xmlStr;
    }

    public void setXmlStr(String xmlStr) {
        this.xmlStr = xmlStr;
    }

    public String getXmlmd5() {
        return xmlmd5;
    }

    public void setXmlmd5(String xmlmd5) {
        this.xmlmd5 = xmlmd5;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public String getJsonmd5() {
        return jsonmd5;
    }

    public void setJsonmd5(String jsonmd5) {
        this.jsonmd5 = jsonmd5;
    }

    public String getPdfStr() {
        return pdfStr;
    }

    public void setPdfStr(String pdfStr) {
        this.pdfStr = pdfStr;
    }

    public String getPdfmd5() {
        return pdfmd5;
    }

    public void setPdfmd5(String pdfmd5) {
        this.pdfmd5 = pdfmd5;
    }

    public String getReportSource() {
        return reportSource;
    }

    public void setReportSource(String reportSource) {
        this.reportSource = reportSource;
    }

    public String getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(String reportVersion) {
        this.reportVersion = reportVersion;
    }

    public String getCreditreportNo() {
        return creditreportNo;
    }

    public void setCreditreportNo(String creditreportNo) {
        this.creditreportNo = creditreportNo;
    }

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    @Override
    public String toString() {
        return "SingleResult{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", htmlStr='" + htmlStr + '\'' +
                ", htmlmd5='" + htmlmd5 + '\'' +
                ", xmlStr='" + xmlStr + '\'' +
                ", xmlmd5='" + xmlmd5 + '\'' +
                ", jsonStr='" + jsonStr + '\'' +
                ", jsonmd5='" + jsonmd5 + '\'' +
                ", pdfStr='" + pdfStr + '\'' +
                ", pdfmd5='" + pdfmd5 + '\'' +
                ", reportSource='" + reportSource + '\'' +
                ", reportVersion='" + reportVersion + '\'' +
                ", creditreportNo='" + creditreportNo + '\'' +
                ", reqID='" + reqID + '\'' +
                ", usetime='" + usetime + '\'' +
                '}';
    }
}