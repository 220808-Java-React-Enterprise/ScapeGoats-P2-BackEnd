package com.revature.tarotcards.p2scapegoats;

import com.revature.tarotcards.p2scapegoats.testdummy.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    String input;
    String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs [][] = {{"AACD", "CD"},{"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Positions_A_Infirst2Positions() {
        StringHelper helper = new StringHelper();

        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));

    }

    @Test
    public void testTruncateAInFirst2Positions2_A_InFirstPosition() {
        StringHelper helper = new StringHelper();

        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

}
