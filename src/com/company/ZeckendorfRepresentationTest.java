package com.company;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

class ZeckendorfRepresentationTest {

    public ZeckendorfRepresentation zeckendorfTest;
    public BufferedReader br;
    public static final List<Integer> ZECKENDORF_1 = Arrays.asList(0, 0, 0, 0, 1);
    public static final List<Integer> ZECKENDORF_2 = Arrays.asList(0, 0, 0, 1, 0);
    public static final List<Integer> ZECKENDORF_3 = Arrays.asList(0, 0, 1, 0, 0);
    public static final List<Integer> ZECKENDORF_4 = Arrays.asList(0, 0, 1, 0, 1);
    public static final List<Integer> ZECKENDORF_5 = Arrays.asList(0, 1, 0, 0, 0);
    public static final List<Integer> ZECKENDORF_6 = Arrays.asList(0, 1, 0, 0, 1);
    public static final List<Integer> ZECKENDORF_7 = Arrays.asList(0, 1, 0, 1, 0);
    public static final List<Integer> ZECKENDORF_8 = Arrays.asList(1, 0, 0, 0, 0);
    public static final List<Integer> ZECKENDORF_9 = Arrays.asList(1, 0, 0, 0, 1);
    public static final List<Integer> ZECKENDORF_10 = Arrays.asList(1, 0, 0, 1, 0);


    @Test
    void testFibonacciSequenceTest() {
        zeckendorfTest = new ZeckendorfRepresentation();
        zeckendorfTest.setLowerbound(1);
        zeckendorfTest.setUpperBount(10);
        zeckendorfTest.setFibonacciSequence();
        assertEquals("The first number in Fibonnaci sequence is incorrect", new Integer(1), zeckendorfTest.getFibonacci().get(0));
        assertEquals("The second number in Fibonnaci sequence is incorrect", new Integer(2), zeckendorfTest.getFibonacci().get(1));
        assertEquals("The third number in Fibonnaci sequence is incorrect", new Integer(3), zeckendorfTest.getFibonacci().get(2));
        assertEquals("The fourth number in Fibonnaci sequence is incorrect", new Integer(5), zeckendorfTest.getFibonacci().get(3));
        assertEquals("The fifth number in Fibonnaci sequence is incorrect", new Integer(8), zeckendorfTest.getFibonacci().get(4));
    }

    @Test
    void testZeckendorfSequenceBound1to1() {
        zeckendorfTest = new ZeckendorfRepresentation();
        zeckendorfTest.setLowerbound(1);
        zeckendorfTest.setUpperBount(1);
        zeckendorfTest.setFibonacciSequence();
        zeckendorfTest.getZeckendorfSequence();
        assertEquals("The first number in the Zeckendford sequence is incorret", new Integer(1), zeckendorfTest.getAllZeckendorfs().get(0).get(0));
    }


    @Test
    void testBound1To10InZeckendorf() throws IOException {
        zeckendorfTest = new ZeckendorfRepresentation();
        zeckendorfTest.setLowerbound(1);
        zeckendorfTest.setUpperBount(10);
        zeckendorfTest.setFibonacciSequence();
        zeckendorfTest.getZeckendorfSequence();
        assertEquals("The Sequence should match 00001", ZECKENDORF_1, zeckendorfTest.getAllZeckendorfs().get(0));
        assertEquals("The Sequence should match 00010", ZECKENDORF_2, zeckendorfTest.getAllZeckendorfs().get(1));
        assertEquals("The Sequence should match 00100", ZECKENDORF_3, zeckendorfTest.getAllZeckendorfs().get(2));
        assertEquals("The Sequence should match 00101", ZECKENDORF_4, zeckendorfTest.getAllZeckendorfs().get(3));
        assertEquals("The Sequence should match 01000", ZECKENDORF_5, zeckendorfTest.getAllZeckendorfs().get(4));
        assertEquals("The Sequence should match 01001", ZECKENDORF_6, zeckendorfTest.getAllZeckendorfs().get(5));
        assertEquals("The Sequence should match 01010", ZECKENDORF_7, zeckendorfTest.getAllZeckendorfs().get(6));
        assertEquals("The Sequence should match 10000", ZECKENDORF_8, zeckendorfTest.getAllZeckendorfs().get(7));
        assertEquals("The Sequence should match 10001", ZECKENDORF_9, zeckendorfTest.getAllZeckendorfs().get(8));
        assertEquals("The Sequence should match 10010", ZECKENDORF_10, zeckendorfTest.getAllZeckendorfs().get(9));

    }

}