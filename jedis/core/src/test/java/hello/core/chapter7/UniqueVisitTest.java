package hello.core.chapter7;

import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueVisitTest {
    static JedisHelper helper;
    private UniqueVisit uniqueVisit;
    private static final int VISIT_COUNT = 1000;
    private static final int TOTAL_USER = 10000000;
    private static final String TEST_DATE = "19500101";
    static Random rand = new Random();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        helper = JedisHelper.getInstance();
    }

//    @AfterAll
//    public static void tearDownAfterClass() throws Exception {
//        helper.destroyPool();
//    }

    @Before
    public void setUp() throws Exception {
        uniqueVisit = new UniqueVisit(helper);
        assertNotNull(uniqueVisit);
    }

    @Test
    public void testRandomPV() {
        int pv = uniqueVisit.getPVCount(getToday());
        for(int i = 0; i< VISIT_COUNT; i++) {
            uniqueVisit.visit(rand.nextInt(TOTAL_USER));
        }
        assertEquals(pv + VISIT_COUNT, uniqueVisit.getPVCount(getToday()));
    }

    @Test
    public void testInvalidPV() {
        assertEquals(0, uniqueVisit.getPVCount(TEST_DATE));
        assertEquals(new Long(0), uniqueVisit.getUVCount(TEST_DATE));
    }

    @Test
    public void testPV() {
        int result = uniqueVisit.getPVCount(getToday());
        uniqueVisit.visit(65487);

        assertEquals(result + 1, uniqueVisit.getPVCount(getToday()));
    }

    @Test
    public void testUV() {
        uniqueVisit.visit(65487);
        Long result = uniqueVisit.getUVCount(getToday());
        uniqueVisit.visit(65487);

        assertEquals(result, uniqueVisit.getUVCount(getToday()));
    }

    private String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }
}
