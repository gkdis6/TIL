package hello.core.chapter7;

import redis.clients.jedis.Jedis;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LogReceiverV2 {
    private static final JedisHelper helper = JedisHelper.getInstance();
    private static final String KEY_WAS_LOG = "was:log:list";
    private static final String LOG_FILE_NAME_PREFIX = "./waslog";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH'.log'");

    /**
     * 레디스 서버에서 로그를 읽어서 파일로 저장한다.
     * 프로그램이 종료되기 전까지 무한히 실행한다.
     */
    public void start() {
        Jedis jedis = helper.getConnection();
        while(true){
            String log = jedis.rpop(KEY_WAS_LOG);
            if(log == null) break;
            writeFile(log);
        }
    }

    private void writeFile(String log){
        try{
            if(log == null) return;
            FileWriter writer = new FileWriter(getCurrentFileName(), true);

            writer.write(log);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCurrentFileName(){
        return LOG_FILE_NAME_PREFIX + sdf.format(new Date());
    }
}
