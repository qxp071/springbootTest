package cn.example.mp.test.common;

/**
 * @author: xianpei.qin
 * @create: 2019-10-29 10:45
 **/
public class ResultBody {

    private String  code;

    private String message;

    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object result) {
        this.data = result;
    }

    public static ResultBody success(String message){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode("1");
        resultBody.setMessage(message);
        return  resultBody;
    }
    public static ResultBody success(Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode("1");
        resultBody.setMessage("true");
        resultBody.setData(data);
        return  resultBody;
    }

    public static ResultBody success(String message,Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode("1");
        resultBody.setMessage(message);
        resultBody.setData(data);
        return  resultBody;
    }


    public static ResultBody error(String message){
        ResultBody resultBody  = new ResultBody();
        resultBody.setCode("-1");
        resultBody.setMessage(message);
        return resultBody;

    }

}