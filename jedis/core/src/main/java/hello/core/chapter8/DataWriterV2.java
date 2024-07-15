package hello.core.chapter8;

import redis.clients.jedis.Jedis;

public class DataWriterV2 {
    private Jedis jedis;

    /**
     * 데이터 저장을 위한 WriterV2 클래스 생성자
     * @param jedis 데이터를 저장할 노드에 대한 제디스 연결
     */
    public DataWriterV2(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 주어진 키에 데이터를 저장한다.
     * @param key 데이터 저장을 위한 레디스의 키
     * @param value 저장될 데이터
     */
    public void set(String key, String value) {
        this.jedis.lpush(key, value);
    }
}
