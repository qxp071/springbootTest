package cn.example.mp.test.web.entity;

import org.springframework.stereotype.Component;

/**
 * @author: xianpei.qin
 * @create: 2020-03-25 19:57
 **/
@Component
public class BaseResponse<T> {

    private AappHead appHead;

    private T body;

    public AappHead getAppHead() {
        return appHead;
    }

    public void setAppHead(AappHead appHead) {
        this.appHead = appHead;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}