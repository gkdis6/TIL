package hello.core.chapter7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {
    static JedisHelper helper;
    private static final int WAITING_TERM = 5000;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        helper = JedisHelper.getInstance();
    }

//    @AfterAll
//    public static void tearDownAfterClass() throws Exception {
//        helper.destroyPool();
//    }

    @Test
    public void testWrite() {
        Random random = new Random(System.currentTimeMillis());
        LogWriterV2 logWriter = new LogWriterV2(helper);
        for(int i = 0; i<100; i++){
            assertTrue(logWriter.log("this is test log message 1") > 0);
            try{
                Thread.sleep(random.nextInt(50));
            }catch (InterruptedException e){
                //do nothing
            }
        }
    }

    @Test
    public void testReceiver(){
        LogReceiverV2 logReceiver = new LogReceiverV2();

        for(int i = 0; i<5; i++){
            logReceiver.start();
            try{
                Thread.sleep(WAITING_TERM);
            }catch (InterruptedException e){
                //do nothing
            }
        }
    }
}
