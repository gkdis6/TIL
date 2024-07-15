package hello.core.chapter7;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UniqueVisitV2Test {
    static JedisHelper helper;
    private UniqueVisitV2 uniqueVisit;
    private static final int TOTAL_USER = 10000000;

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
        uniqueVisit = new UniqueVisitV2(helper);
        assertNotNull(uniqueVisit);

        this.uniqueVisit.visit(7, "20130510");
        this.uniqueVisit.visit(11, "20130510");
        this.uniqueVisit.visit(15, "20130510");
        this.uniqueVisit.visit(TOTAL_USER, "20130510");

        this.uniqueVisit.visit(3, "20130511");
        this.uniqueVisit.visit(7, "20130511");
        this.uniqueVisit.visit(9, "20130511");
        this.uniqueVisit.visit(11, "20130511");
        this.uniqueVisit.visit(15, "20130511");
        this.uniqueVisit.visit(TOTAL_USER, "20130511");

        this.uniqueVisit.visit(7, "20130512");
        this.uniqueVisit.visit(12, "20130512");
        this.uniqueVisit.visit(13, "20130512");
        this.uniqueVisit.visit(5, "20130512");
        this.uniqueVisit.visit(TOTAL_USER, "20130512");
    }

    @Test
    public void testUVSum() {
        String[] dateList1 = {"20130510", "20130511", "20130512"};
        assertEquals(new Long(3), this.uniqueVisit.getUVSum(dateList1));

        String[] dateList2 = {"20130510", "20130511", "20130512", "20110512"};
        assertEquals(new Long(3), this.uniqueVisit.getUVSum(dateList2));
    }

}
