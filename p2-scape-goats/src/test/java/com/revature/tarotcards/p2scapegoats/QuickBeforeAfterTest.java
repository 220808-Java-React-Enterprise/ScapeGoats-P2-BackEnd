package com.revature.tarotcards.p2scapegoats;

import com.revature.tarotcards.p2scapegoats.testdummy.StringHelper;
import org.junit.*;


public class QuickBeforeAfterTest {

    StringHelper helper;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }
    @Before
    public void setup() {
        System.out.println("Before Test");
        helper = new StringHelper();
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @After
    public void teardown() {
        System.out.println("After test");
    }
    @AfterClass
    public static  void afterClass() {
        System.out.println("After Class");
    }
}
