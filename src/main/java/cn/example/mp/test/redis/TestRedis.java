package cn.example.mp.test.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {

    public static void main(String[] args) {
       /* Jedis jedis  = new Jedis("192.168.1.101",6379);
        jedis.auth("123456");
        jedis.set("userName","tom");
        System.out.println(jedis.ping());
        String userName = jedis.get("userName");
        System.out.println(userName);*/

        String userName = JedisUtil.get("userName");
        System.out.println(userName);

    }

}
