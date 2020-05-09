package cn.example.mp.test.fileparam;

/**
 * 业务支撑平台文件删除、下载返回信息
 * @author: xianpei.qin
 * @create: 2020-04-20 09:54
 **/
public class FileResponse {

    /**
     *返回码
     */
    private Integer retCode;

    /**
     *异常信息
     */
    private String retMsg;

    /**
     *返回结果信息,请求参数flag为1，result为文件的全路径；flag为0，result为文件在文件存储服务器的文件名
     */
    private String retEntity;


    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetEntity() {
        return retEntity;
    }

    public void setRetEntity(String retEntity) {
        this.retEntity = retEntity;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "retCode=" + retCode +
                ", retMsg='" + retMsg + '\'' +
                ", retEntity='" + retEntity + '\'' +
                '}';
    }
}