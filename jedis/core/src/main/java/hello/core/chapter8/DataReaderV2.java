package hello.core.chapter8;

import redis.clients.jedis.Jedis;

import java.util.List;

public class DataReaderV2 {
    private Jedis jedis;
    private static final int TIMEOUT = 1000;

    /**
     * 데이터 조회를 위한 ReaderV2 클래스 생성자
     * @param jedis 데이터를 조회할 노드에 대한 제디스 연결
     */
    public DataReaderV2(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 주어진 키에 저장된 데이터를 조회한다.
     * @param key 데이터 조회를 위한 키
     * @return 조회된 데이터. 만약 키가 존재하지 않으면 데이터가 입력될 때까지 대기한다.
     */
    public List<String> get(String key) {
        return this.jedis.brpop(TIMEOUT, key);
    }
}
