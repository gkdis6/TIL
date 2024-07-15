package hello.core.chapter8;

import hello.core.chapter7.KeyMaker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.jupiter.api.Assertions.fail;

public class ReplicationTest {
    private static final int TEST_COUNT = 100000;
    static Jedis master;
    static Jedis slave;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        master = new Jedis("127.0.0.1", 6300);
        slave = new Jedis("127.0.0.1", 6301);
    }

//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        master.disconnect();
//        slave.disconnect();
//    }

    @Test
    public void replicationTest() {
        DataWriter writer = new DataWriter(master);
        DataReader reader = new DataReader(slave);

        for(int i = 0; i < TEST_COUNT; i++) {
            KeyMaker keyMaker = new ReplicationKeyMaker(i);
            String value = "test value" + i;
            writer.set(keyMaker.getKey(), value);
            String result = reader.get(keyMaker.getKey());

            if(value.equals(result)) {
                //sucess case
            } else {
                fail("The value Not match with a result. [" + value + "][" + result + "]");
            }
        }
    }
}
