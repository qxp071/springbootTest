package cn.example.mp.test.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class JedisPollManager {

    @Value("${spring.redis.host}")
    private  String hostName;

    @Value("${spring.redis.port}")
    private  int port;

    @Value("${spring.redis.password}")
    private  String password;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    /**
     * 	资源池允许的最大空闲连接数
     */
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    /**
     * 资源池确保的最少空闲连接数
     */
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int MinIdle;

    /**
     * 资源池确保的最少空闲连接数
     */
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWaitMillis;

    /**
     * volatile修饰，确保可见性
     */
    private static volatile JedisPool jedisPool = null;

    /**
     * 注册jedisPool到spring容器中
     * @return
     */
    @Bean
    public JedisPool newPool() {
        //双重校验锁检查，确保jedisPool单例
        if(null==jedisPool){
            synchronized (JedisPollManager.class){
                if(null==jedisPool){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    //资源池中的最大连接数
                    jedisPoolConfig.setMaxTotal(maxTotal);
                    //资源池允许的最大空闲连接数
                    jedisPoolConfig.setMaxIdle(maxIdle);
                    //资源池确保的最少空闲连接数
                    jedisPoolConfig.setMinIdle(MinIdle);
                    //当资源池连接用尽后，调用者的最大等待时间（单位为毫秒）。-1（表示永不超时）
                    jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
                    //向资源池借用连接时是否做连接有效性检测（ping）。检测到的无效连接将会被移除。
                    jedisPoolConfig.setTestOnBorrow(true);
                    //向资源池归还连接时是否做连接有效性检测（ping）。检测到无效连接将会被移除。
                    jedisPoolConfig.setTestOnReturn(true);
                    jedisPool = new JedisPool(jedisPoolConfig,hostName,port,3000,password);
                }
            }
        }
        return jedisPool;
    }


}
