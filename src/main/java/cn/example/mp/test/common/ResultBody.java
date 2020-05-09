package cn.example.mp.test.common;

/**
 * @author: xianpei.qin
 * @create: 2019-10-29 10:45
 **/
public class ResultBody {

    private String  code;

    private String message;

    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResultBody success(){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode("1");
        resultBody.setMessage("true");
        return  resultBody;
    }

    public static ResultBody error(){
        ResultBody resultBody  = new ResultBody();
        resultBody.setCode("-1");
        resultBody.setMessage("error/400");
        return resultBody;

    }

}