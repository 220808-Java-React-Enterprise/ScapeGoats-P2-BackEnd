package com.revature.tarotcards.p2scapegoats;

import com.revature.tarotcards.p2scapegoats.testdummy.StringHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringHelperTest {

    @Test
    public void testTruncateAInFirst2Positions_A_Infirst2Positions() {
        StringHelper helper = new StringHelper();

        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));

    }

    @Test
    public void testTruncateAInFirst2Positions2_A_InFirstPosition() {
        StringHelper helper = new StringHelper();

        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions2_A_NotInAnyPosition() {
        StringHelper helper = new StringHelper();

        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Positions2_A_AtLast2Position() {
        StringHelper helper = new StringHelper();

        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNagative() {
        StringHelper helper = new StringHelper();

        boolean actualValue = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
        boolean expectedValue = false;
        assertEquals(expectedValue, actualValue);
    }


}
