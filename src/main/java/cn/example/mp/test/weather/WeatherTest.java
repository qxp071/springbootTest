package cn.example.mp.test.weather;

import cn.example.mp.test.util.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.kafka.common.protocol.types.Field;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/10/10 16:43
 */
public class WeatherTest {


    public static void main(String[] args) {
        String weatherUrl = "http://wthrcdn.etouch.cn/weather_mini?city=";
        String city = "广州";
        String weather = getWeather(city, weatherUrl);
        System.out.println(weather);
    }

    public static String getWeather(String city, String weatherUrl) {
        byte[] bytes = null;
        String result = null;
        try {
            // 创建httpclient对象
            CloseableHttpClient client = HttpClients.createDefault();
            // 创建带参数的url
            URIBuilder uriBuilder = new URIBuilder(weatherUrl+city);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            CloseableHttpResponse response = client.execute(httpGet);
            int httpCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 按指定编码转换结果实体为byte数组
                bytes = EntityUtils.toByteArray(entity);
            }
            EntityUtils.consume(entity);
            response.close();
            result = new String(bytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
