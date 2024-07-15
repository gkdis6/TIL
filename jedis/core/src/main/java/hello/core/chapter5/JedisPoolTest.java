package hello.core.chapter5;

import java.util.Map;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setBlockWhenExhausted(true);

        JedisPool pool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        Jedis firstClient = pool.getResource();
        firstClient.hset("info:자린고비", "이름", "자린고비");
        firstClient.hset("info:자린고비", "생일", "1970-12-20");

        Jedis secondClient = pool.getResource();
        Map<String, String> result = secondClient.hgetAll("info:자린고비");
        System.out.println("이름 : " + result.get("이름"));
        System.out.println("생일 : " + result.get("생일"));

        pool.returnResource(firstClient);
        pool.returnResource(secondClient);

//        pool.close();
//        pool.clear();
//        pool.destroy();
    }
}
