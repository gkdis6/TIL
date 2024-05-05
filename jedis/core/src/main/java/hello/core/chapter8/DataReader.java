package hello.core.chapter8;

import redis.clients.jedis.Jedis;

public class DataReader {
    private Jedis jedis;

    /**
     * 데이터 조회를 위한 Reader 클래스 생성자
     * @param jedis 데이터를 조회할 노드에 대한 제디스 연결
     */
    public DataReader(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 주어진 키에 저장된 데이터를 조회한다.
     * @param key 데이터 조회를 위한 키
     * @return 조회된 데이터. 만약 키가 존재하지 않으면 null을 반환한다.
     */
    public String get(String key) {
        return this.jedis.get(key);
    }
}
