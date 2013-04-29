package other;

import junit.framework.Assert;
import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 26.04.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class OtherTest {
    private Other service;

    public OtherTest() {
        System.out.println("Constructor.");
    }

    @BeforeClass
    public static void start() {
        System.out.println("BeforeClass.");
    }

    @Before
    public void init() {
        System.out.println("before.");
        this.service = new Other();
    }

    @Test
    public void testDividePositive() throws Exception {
        System.out.println("testDividePositive.");
        int actualResult = service.divide(20, 4);
        assertEquals(5, actualResult);
    }

    @Test(expected = RuntimeException.class)
    public void testDivideNegative() throws Exception {
        System.out.println("testDivideNegative.");
        service.divide(20, 4);
    }

    @After
    public void destroy() {
        System.out.println("after.");
    }

    @AfterClass
    public static void end() {
        System.out.println("AfterClass.");
    }

}
