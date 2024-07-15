package hello.core.chapter7;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventUserListTest {
    static JedisHelper helper;
    private static EventUserList eventUserList;
    private static UniqueVisitV2 uniqueVisitV2;
    private static final int TOTAL_USER = 10000000;
    private static final int DEST_USER = 1000;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        helper = JedisHelper.getInstance();
        EventUserListTest.eventUserList = new EventUserList(helper);
        uniqueVisitV2 = new UniqueVisitV2(helper);
    }

//    @AfterAll
//    public static void tearDownAfterClass() throws Exception {
//        helper.destroyPool();
//    }

    @Before
    public void setUp() throws Exception {
        assertNotNull(EventUserListTest.eventUserList);
    }

    @Test
    public void testSetup() {
        Random rand = new Random();
        for(int i = 0; i< DEST_USER; i++) {
            int tempuser = rand.nextInt(TOTAL_USER);
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110508");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110509");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110510");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110511");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110512");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110513");
            EventUserListTest.uniqueVisitV2.visit(tempuser, "20110514");
        }
    }

    @Test
    public void initLuaScript() {
        assertEquals("0a987c7b189edad3abc0fdd9b9fac03b15b77a4b", eventUserList.initLuaScript());
    }

    @Test
    public void runLuaScript() {
        String[] dateList1 = {"20110508", "20110509", "20110510", "20110511", "20110512", "20110513", "20110514"};
        Long count = EventUserListTest.uniqueVisitV2.getUVSum(dateList1);

        List<String> list = (List<String>) EventUserListTest.eventUserList.getEventUserList();

        assertEquals(count, new Long(list.size()));

        for(String item : list) {
            System.out.println(item);
        }
    }
}
