package cn.example.mp.test.fileparam;

import org.springframework.web.multipart.MultipartFile;

/**
 * 业务支撑平台文件上传请求参数
 * @author: xianpei.qin
 * @create: 2020-04-20 09:57
 **/
public class UploadRequest {

    /**
     * 文件对象
     */
    private MultipartFile file;

    /**
     *文件名
     */
    private String fileName;

    /**
     *文件md5值
     */
    private String fileMd5;

    /**
     * 文件批次号
     */
    private String batchNo;

    /**
     *获取文件路径,请求参数flag为1，result为文件的全路径；flag为0，result为文件在文件存储服务器的文件名
     */
    private String flag;

    /**
     *服务请求系统英文简称
     */
    private String svcRqsSysEnShrtName;

    /**
     *服务请求系统交易时间戳
     */
    private String svcRqsSysTxnTimpstamp;

    /**
     *服务请求系统流水号
     */
    private String svcRqsSysSerNo;

    /**
     *全局流水号
     */
    private String globalSerialNo;

    /**
     *源服务请求系统英文简称
     */
    private String origSvcRqsSysEnShrtName;

    /**
     *源服务请求系统交易时间戳
     */
    private String origSvcRqsSysTxnTimpstamp;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    @Override
    public String toString() {
        return "UploadRequest{" +
                "file=" + file +
                ", fileName='" + fileName + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", batchNo='" + batchNo + '\'' +
                ", flag='" + flag + '\'' +
                ", svcRqsSysEnShrtName='" + svcRqsSysEnShrtName + '\'' +
                ", svcRqsSysTxnTimpstamp='" + svcRqsSysTxnTimpstamp + '\'' +
                ", svcRqsSysSerNo='" + svcRqsSysSerNo + '\'' +
                ", globalSerialNo='" + globalSerialNo + '\'' +
                ", origSvcRqsSysEnShrtName='" + origSvcRqsSysEnShrtName + '\'' +
                ", origSvcRqsSysTxnTimpstamp='" + origSvcRqsSysTxnTimpstamp + '\'' +
                '}';
    }
}