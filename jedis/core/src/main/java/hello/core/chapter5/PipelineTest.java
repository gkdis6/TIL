package hello.core.chapter5;

import java.io.IOException;
import java.net.UnknownHostException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PipelineTest {
    private static final int TOTAL_OPERATIONS = 10000000;

    public static void main(String[] args) throws UnknownHostException, IOException {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.connect();

        long start = System.currentTimeMillis();

        String key, value;
        Pipeline p = jedis.pipelined(); //제디스가 제공하는 파이프라인 객체를 생성하고 초기화

        for (int n = 0; n <= TOTAL_OPERATIONS; n++) {
            key = value = String.valueOf("key" + (100000000 + n));
            p.set(key, value);
        }
        p.sync(); //파이프라인의 응답을 서버로부터 모두 수신하여 제디스의 응답 객체로 변환

        jedis.disconnect();

        long elapsed = now() - start;
        System.out.println("초당 처리 건수 " + TOTAL_OPERATIONS / elapsed * 1000f);
        System.out.println("소요 시간 " + elapsed / 1000f + "초");
    }
        private static long now() {
            return System.currentTimeMillis();
        }
    }