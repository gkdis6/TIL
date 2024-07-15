package hello.core.chapter5;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisThreadTest {
    private static final float TOTAL_OP = 10000000f;
    private static final float THREAD = 5;

    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setBlockWhenExhausted(true);

        JedisPool pool = new JedisPool(poolConfig, "127.0.0.1", 6379);

        final long start = now();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                long elapsed = now() - start;

                System.out.println("스레드 개수 " + THREAD + "개");
                System.out.println("초당 처리 건수 " + TOTAL_OP / elapsed * 1000f);
                System.out.println("소요 시간 " + elapsed / 1000f + "초");
            }
        });

        JedisThreadTest test = new JedisThreadTest();
        for(int i = 0; i < THREAD; i++){
            test.makeWorker(pool, i).start();
        }
    }

    private Thread makeWorker(final JedisPool pool, final int idx){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String key, value;
                Jedis jedis = pool.getResource();

                for(int i = 1; i<= TOTAL_OP; i++){
                    if(i%THREAD == idx){
                        key = value = String.valueOf("key" + (10000000 + i));
                        jedis.set(key, value);
                    }
                }

                pool.returnResource(jedis);
            }
        });
        return thread;
    }

    static long now(){
        return System.currentTimeMillis();
    }
}
