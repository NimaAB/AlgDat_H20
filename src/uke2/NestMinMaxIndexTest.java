package uke2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NestMinMaxIndexTest {

    @Test
    void nestMaxIndex() {
        int [] a = {3,30,9,1,14,2};
        int [] expected= {1,4};
        assertArrayEquals(expected,NestMinMaxIndex.nestMaxIndex(a));
    }
    @Test
    void nestMinIndex() {
        int [] a = {3,30,9,1,14,2};
        int [] expected= {3,5};
        assertArrayEquals(expected,NestMinMaxIndex.nestMinIndex(a));

        int [] b = {1,2,3,4,5};
        int [] expected1 = {0,1};
        assertArrayEquals(expected1,NestMinMaxIndex.nestMinIndex(b));


    }
}