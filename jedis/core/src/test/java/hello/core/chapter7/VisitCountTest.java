package hello.core.chapter7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VisitCountTest {

    static JedisHelper helper;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        helper = JedisHelper.getInstance();
    }

//    @AfterAll
//    public static void tearDownAfterClass() throws Exception {
//        helper.destroyPool();
//    }

    @Test
    public void testAddVisit(){
        VisitCount visitCount = new VisitCount(helper);
        assertNotNull(visitCount);

        assertTrue(visitCount.addVisit("52") > 0);
        assertTrue(visitCount.addVisit("180") > 0);
        assertTrue(visitCount.addVisit("554") > 0);
    }

    @Test
    public void testGetVisitCount() {
        VisitCount visitCount = new VisitCount(helper);
        assertNotNull(visitCount);

        List<String> result = visitCount.getVisitCount("52", "180", "554");
        assertNotNull(result);
        assertTrue(result.size() == 3);

        long sum = 0;
        for (String count : result){
            sum = sum + Long.parseLong(count);
        }

        String totalCount = visitCount.getVisitTotalCount();
        assertEquals(String.valueOf(sum), totalCount);
    }
}
