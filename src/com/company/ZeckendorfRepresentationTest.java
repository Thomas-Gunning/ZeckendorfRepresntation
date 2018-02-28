package com.company;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ZeckendorfRepresentationTest {

    public ZeckendorfRepresentation ZeckendorfTest;
    public BufferedReader br;
    @Before
    void setUpTests(){
        ZeckendorfTest = new ZeckendorfRepresentation();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Test
    void getFibonacciSequenceTest() {


    }

    @Test
    void getZeckendorfSequenceTest() {
    }

    @Test
    void addBoundsTest() {
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    void lowerBoundTest() throws IOException{
        int lowerBound = 0;
        lowerBound = ZeckendorfTest.getLowerBound(lowerBound, br);

    }
    @Test
    void upperBoundTest(){

    }
}