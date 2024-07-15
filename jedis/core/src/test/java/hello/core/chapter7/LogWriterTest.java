package hello.core.chapter7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogWriterTest {
    static JedisHelper helper;
    static LogWriter logger;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        helper = JedisHelper.getInstance();
        logger = new LogWriter(helper);
    }

//    @AfterAll
//    public static void tearDownAfterClass() throws Exception {
//        helper.destroyPool();
//    }

    @Test
    public void testLogger() {
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i<100; i++){
            assertTrue(logger.log("this is test log message 1") > 0);
            try{
                Thread.sleep(random.nextInt(50));
            }catch (InterruptedException e){
                //do nothing
            }
        }
    }
}
