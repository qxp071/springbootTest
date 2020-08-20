package cn.example.mp.test.redis;

import cn.example.mp.test.util.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * @Description jedisUtil工具类
 * @Author xianpei.qin
 * @Date 2020.08.20 10.20
 **/
public class JedisUtil {

    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    /**
     * 从spring容器中取出jedisPoll
     */
    private static JedisPool jedisPool = SpringContextHolder.getBean(JedisPool.class);

    /**
     * 获取从池中jedis
     * @return
     */
    public synchronized static Jedis getJedis(){
        try {
            if(jedisPool!=null){
                Jedis jedis = jedisPool.getResource();
                return jedis;
            }else{
                return null;
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 释放资源
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                value = jedis.get(key);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
            }
        } catch (Exception e) {
            logger.warn("get {} = {}", key,value,e);
        } finally {
            returnResource(jedis);
        }
        return value;
    }
    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String set(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("set {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("set {} = {}", key, value, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

}
