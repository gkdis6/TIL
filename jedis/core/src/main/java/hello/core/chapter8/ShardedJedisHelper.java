package hello.core.chapter8;

import java.util.*;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;
import redis.clients.jedis.util.Hashing;

public class ShardedJedisHelper {
    protected static final String SHARD1_HOST = "192.168.56.102";
    protected static final int SHARD1_PORT = 6380;
    protected static final String SHARD2_HOST = "192.168.56.102";
    protected static final int SHARD2_PORT = 6381;

    private final Set<JedisSharding> connectionList = new HashSet<JedisSharding>();

    private JedisSharding shardedPool;

    /**
     * 싱글통 처리를 위한 홀더 클래스
     * 제디스 연결풀이 포함된 도우미 객체를 반환한다.
     */
    private static class LazyHolder {
        @SuppressWarnings("synthetic-access")
        private static final ShardedJedisHelper INSTANCE = new ShardedJedisHelper();
    }

    private ShardedJedisHelper() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setBlockWhenExhausted(true);

        List<HostAndPort> shards = new ArrayList<HostAndPort>();
        shards.add(new HostAndPort(SHARD1_HOST, SHARD1_PORT));
        shards.add(new HostAndPort(SHARD2_HOST, SHARD2_PORT));

        this.shardedPool = new JedisSharding(shards, (JedisClientConfig) poolConfig, Hashing.MURMUR_HASH);
    }

    @SuppressWarnings("synthetic-access")
    public static ShardedJedisHelper getInstance() {
        return LazyHolder.INSTANCE;
    }

//    final public ShardedJedis getConnection() {
//        ShardedJedis jedis = this.shardedPool.getResource();
//        this.connectionList.add(jedis);
//
//        return jedis;
//    }
//
//    final public void returnResource(ShardedJedis jedis) {
//        this.shardedPool.returnResource(jedis);
//    }
//
//    final public void destroyPool() {
//        Iterator<ShardedJedis> jedisList = this.connectionList.iterator();
//
//        while(jedisList.hasNext()){
//            ShardedJedis jedis = jedisList.next();
//            this.shardedPool.returnResource(jedis);
//        }
//        this.shardedPool.destroy();
//    }
}
