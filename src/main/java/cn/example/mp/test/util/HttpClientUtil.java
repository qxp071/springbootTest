package cn.example.mp.test.util;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author: xianpei.qin
 * @create: 2020-04-14 19:26
 **/
public class HttpClientUtil {


    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
    public static final int connTimeout = 10000;
    public static final int readTimeout = 10000;

    /**
     * 超时时间默认10s
     * @param url
     * @param params
     * @param encoding
     * @throws ParseException
     * @throws IOException
     * @return String
     */
    public static byte[] sendPost(String url, Map<String, Object> params, String encoding) throws ParseException, IOException {
        return sendPost(url, params, encoding, connTimeout, readTimeout);
    }

    /**
     * 自定义超时时间
     * @param url
     * @param params
     * @param encoding
     * @param connTimeout
     * @param readTimeout
     * @throws ParseException
     * @throws IOException
     * @return String
     */
    public static byte[] sendPost(String url, Map<String, Object> params, String encoding, Integer connTimeout, Integer readTimeout) throws ParseException, IOException {
        byte [] body = new byte[0] ;
        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 设置参数
        RequestConfig.Builder customReqConf = RequestConfig.custom();
        if (connTimeout != null) {
            customReqConf.setConnectTimeout(connTimeout);
        }
        if (readTimeout != null) {
            customReqConf.setSocketTimeout(readTimeout);
        }
        httpPost.setConfig(customReqConf.build());

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Entry<String, Object> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        // 设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        log.info("请求地址：" + url);
        log.info("请求参数：" + nvps.toString());

        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        int httpCode = response.getStatusLine().getStatusCode();
        log.info("响应状态={}", httpCode);

        if (httpCode == 302) {
            Header header = response.getFirstHeader("location"); // 跳转的目标地址是在
            // HTTP-HEAD 中的
            String newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
            log.info("重定向请求地址={}", newuri);
            httpPost = new HttpPost(newuri);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (nvps.size() != 0) {
                // 设置参数到请求对象中
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
            }
            response = client.execute(httpPost);
            httpCode = response.getStatusLine().getStatusCode();
            log.info("重定向后响应状态={}", httpCode);
        }
        // 获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 按指定编码转换结果实体为String类型
            body = EntityUtils.toByteArray(entity);
        }
        EntityUtils.consume(entity);
        // 释放链接
        response.close();
        log.info("交易响应结果：{}", body);
        return body;
    }


    public static byte[] sendGet(String url, Map<String, String> params, String encoding) throws IOException, URISyntaxException {
        return sendGet( url, params,  encoding,connTimeout, readTimeout);
    }

    private static byte [] sendGet(String url, Map<String, String> params, String encoding, Integer connTimeout, Integer readTimeout) throws IOException, URISyntaxException {
        byte [] body = new byte[0];
        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建带参数的url
        URIBuilder uriBuilder = new URIBuilder(url);
        // 设置参数
        RequestConfig.Builder customReqConf = RequestConfig.custom();
        if (connTimeout != null) {
            customReqConf.setConnectTimeout(connTimeout);
        }
        if (readTimeout != null) {
            customReqConf.setSocketTimeout(readTimeout);
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        // 设置参数到请求对象中
        uriBuilder.setParameters(nvps);
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setConfig(customReqConf.build());
        log.info("请求地址：" + url);
        log.info("请求参数：" + nvps.toString());
        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpGet);
        int httpCode = response.getStatusLine().getStatusCode();
        log.info("响应状态={}", httpCode);
        if (httpCode == 302) {
            // 跳转的目标地址是在
            Header header = response.getFirstHeader("location");
            // HTTP-HEAD 中的
            // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
            String newuri = header.getValue();
            log.info("重定向请求地址={}", newuri);
            uriBuilder = new URIBuilder(url);
            httpGet = new HttpGet(uriBuilder.build());
            httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (nvps.size() != 0) {
                // 设置参数到请求对象中
                uriBuilder.setParameters(nvps);
            }
            response = client.execute(httpGet);
            httpCode = response.getStatusLine().getStatusCode();
            log.info("重定向后响应状态={}", httpCode);
        }
        // 获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 按指定编码转换结果实体为byte数组
            body = EntityUtils.toByteArray(entity);
        }
        EntityUtils.consume(entity);
        // 释放链接
        response.close();
        log.info("交易响应结果：{}", body);
        return body;
    }

    public static byte [] uploadFile(String url, Map<String, Object> params) throws ParseException, IOException {
        byte [] body = new byte[0];
        // 创建httpclient对象
        CloseableHttpClient client = HttpClientBuilder.create().build();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 设置参数
        MultipartEntityBuilder multipartEntityBuilder = null;
        if (params != null) {
            MultipartFile file = (MultipartFile) params.get("file");
            String fileName = (String) params.get("fileName");
            ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));
            multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532);
            multipartEntityBuilder.addBinaryBody("file", file.getInputStream(), ContentType.DEFAULT_BINARY, file.getOriginalFilename());
            multipartEntityBuilder.addTextBody("fileName", fileName,contentType); //文件名
            multipartEntityBuilder.addTextBody("fileMd5", FileMd5Util.getFileMd5(file)); //md5
            multipartEntityBuilder.addTextBody("flag",(String) params.get("flag")); //固定
            multipartEntityBuilder.addTextBody("batchNo",(String) params.get("batchNo")); //批次号
            //新增流水号相关字段
            multipartEntityBuilder.addTextBody("svcRqsSysEnShrtName",(String) params.get("svcRqsSysEnShrtName")); //服务请求系统英文简称
            multipartEntityBuilder.addTextBody("svcRqsSysTxnTimpstamp",(String) params.get("svcRqsSysTxnTimpstamp")); //服务请求系统交易时间戳
            multipartEntityBuilder.addTextBody("svcRqsSysSerNo",(String) params.get("svcRqsSysSerNo")); //服务请求系统流水号
            multipartEntityBuilder.addTextBody("globalSerialNo",(String) params.get("globalSerialNo")); //全局流水号
            multipartEntityBuilder.addTextBody("origSvcRqsSysEnShrtName",(String) params.get("origSvcRqsSysEnShrtName")); //源服务请求系统英文简称
            multipartEntityBuilder.addTextBody("origSvcRqsSysTxnTimpstamp",(String) params.get("origSvcRqsSysTxnTimpstamp")); //源服务请求系统交易时间戳
        }
        // 设置参数到请求对象中
        HttpEntity requestEntity = multipartEntityBuilder.build();
        httpPost.setEntity(requestEntity);
        log.info("请求地址：" + url);
        log.info("请求参数：" + params.toString());

        // 执行请求操作，并拿到结果（同步阻塞）
        HttpResponse response = client.execute(httpPost);
        int httpCode = response.getStatusLine().getStatusCode();
        log.info("响应状态={}", httpCode);
        if(httpCode !=200){
                throw new RuntimeException("文件上传业务支撑平台失败,请稍后重新查询：" + httpCode);
        }
        // 获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 按指定编码转换结果实体为String类型
            body = EntityUtils.toByteArray(entity);
        }
        EntityUtils.consume(entity);
        // 释放链接
        client.close();
        log.info("交易响应结果：{}", new String(body));
        return body;
    }
}