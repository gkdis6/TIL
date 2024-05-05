package hello.core.chapter5;

import redis.clients.jedis.Jedis;

public class HelloJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String result = jedis.set("redisbook", "Hello redis!");
        System.out.println("result = " + result);
        System.out.println(jedis.get("redisbook"));
    }
}
