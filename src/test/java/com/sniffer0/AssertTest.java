package com.sniffer0;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {

    //@Disabled("Requires verification")
    @DisplayName("Checking the expected result")
    @Test
    public void methodChecked() {
        assertEquals(1, 1);
    }

    @DisplayName("Checking if two numbers are equal")
    @Test
    public void methodBoolean() {
        assertTrue(10 == 10);
    }

    @DisplayName("Checking non expected result")
    @Test
    public void methodOfNonEquality() {
        assertNotEquals(4, 3);
    }
}

