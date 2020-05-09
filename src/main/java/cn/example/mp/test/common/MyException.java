package cn.example.mp.test.common;

/**
 * @author: xianpei.qin
 * @create: 2019-10-29 10:41
 **/
public class MyException extends RuntimeException{

    private String errorCode;

    private String errorMessage;

    public MyException() {
    }

    public MyException( String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}