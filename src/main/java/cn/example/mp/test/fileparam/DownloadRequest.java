package cn.example.mp.test.fileparam;

/**
 * 业务支撑平台文件下载入参
 * @author: xianpei.qin
 * @create: 2020-04-20 09:46
 **/
public class DownloadRequest {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件FID
     */
    private String fileFdfsName;

    /**
     * 服务请求系统英文简称
     */
    private String svcRqsSysEnShrtName;

    /**
     * 服务请求系统交易时间戳
     */
    private String svcRqsSysTxnTimpstamp;

    /**
     * 服务请求系统流水号
     */
    private String svcRqsSysSerNo;

    /**
     * 全局流水号
     */
    private String globalSerialNo;

    /**
     * 源服务请求系统英文简称
     */
    private String origSvcRqsSysEnShrtName;

    /**
     * 源服务请求系统交易时间戳
     */
    private String origSvcRqsSysTxnTimpstamp;

    /**
     * 标志符(N),当fileFdfsName传空时，必传1
     */
    private String flagStatus;

    /**
     * 上传文件日期,YYYYMMDD(N)，当fileFdfsName传空时，必传，默认下载uploadFileDate日期下最新的fileName文件
     */
    private String uploadFileDate;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFdfsName() {
        return fileFdfsName;
    }

    public void setFileFdfsName(String fileFdfsName) {
        this.fileFdfsName = fileFdfsName;
    }

    public String getSvcRqsSysEnShrtName() {
        return svcRqsSysEnShrtName;
    }

    public void setSvcRqsSysEnShrtName(String svcRqsSysEnShrtName) {
        this.svcRqsSysEnShrtName = svcRqsSysEnShrtName;
    }

    public String getSvcRqsSysTxnTimpstamp() {
        return svcRqsSysTxnTimpstamp;
    }

    public void setSvcRqsSysTxnTimpstamp(String svcRqsSysTxnTimpstamp) {
        this.svcRqsSysTxnTimpstamp = svcRqsSysTxnTimpstamp;
    }

    public String getSvcRqsSysSerNo() {
        return svcRqsSysSerNo;
    }

    public void setSvcRqsSysSerNo(String svcRqsSysSerNo) {
        this.svcRqsSysSerNo = svcRqsSysSerNo;
    }

    public String getGlobalSerialNo() {
        return globalSerialNo;
    }

    public void setGlobalSerialNo(String globalSerialNo) {
        this.globalSerialNo = globalSerialNo;
    }

    public String getOrigSvcRqsSysEnShrtName() {
        return origSvcRqsSysEnShrtName;
    }

    public void setOrigSvcRqsSysEnShrtName(String origSvcRqsSysEnShrtName) {
        this.origSvcRqsSysEnShrtName = origSvcRqsSysEnShrtName;
    }

    public String getOrigSvcRqsSysTxnTimpstamp() {
        return origSvcRqsSysTxnTimpstamp;
    }

    public void setOrigSvcRqsSysTxnTimpstamp(String origSvcRqsSysTxnTimpstamp) {
        this.origSvcRqsSysTxnTimpstamp = origSvcRqsSysTxnTimpstamp;
    }

    public String getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(String flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getUploadFileDate() {
        return uploadFileDate;
    }

    public void setUploadFileDate(String uploadFileDate) {
        this.uploadFileDate = uploadFileDate;
    }

    @Override
    public String toString() {
        return "DownloadRequest{" +
                "fileName='" + fileName + '\'' +
                ", fileFdfsName='" + fileFdfsName + '\'' +
                ", svcRqsSysEnShrtName='" + svcRqsSysEnShrtName + '\'' +
                ", svcRqsSysTxnTimpstamp='" + svcRqsSysTxnTimpstamp + '\'' +
                ", svcRqsSysSerNo='" + svcRqsSysSerNo + '\'' +
                ", globalSerialNo='" + globalSerialNo + '\'' +
                ", origSvcRqsSysEnShrtName='" + origSvcRqsSysEnShrtName + '\'' +
                ", origSvcRqsSysTxnTimpstamp='" + origSvcRqsSysTxnTimpstamp + '\'' +
                ", flagStatus='" + flagStatus + '\'' +
                ", uploadFileDate='" + uploadFileDate + '\'' +
                '}';
    }
}