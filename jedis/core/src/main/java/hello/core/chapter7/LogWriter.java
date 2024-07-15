package hello.core.chapter7;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {
    private static final String KEY_WAS_LOG = "was:log";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS ");
    JedisHelper helper;

    /**
     * 레디스에 로그를 기록하기 위한 Logger의 생성자
     * @param helper 제디스 헬퍼 객체
     */
    public LogWriter(JedisHelper helper){
        this.helper = helper;
    }

    public Long log(String log) {
        Jedis jedis = this.helper.getConnection();
        Long rtn = jedis.append(KEY_WAS_LOG, sdf.format(new Date()) + log + "\n");

        this.helper.returnResource(jedis);
        return rtn;
    }
}
