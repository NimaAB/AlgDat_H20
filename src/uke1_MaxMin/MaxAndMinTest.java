package uke1_MaxMin;

import static org.junit.jupiter.api.Assertions.*;

class MaxAndMinTest {

    @org.junit.jupiter.api.Test
    void max() {
        int [] a = {3,5,6,1,7,10,100,11,20};
        int index = MaxAndMin.max(a);
        assertEquals(6,index);
        assertEquals(100,a[index]);

        //array with length of 4 all combinations:
        {
            int [][] a4 = allCombinations();
            int [] indexes ={
                   3, 2, 3, 2, 1, 1,
                   3, 2, 3, 2, 1, 1,
                   3, 2, 3, 2, 1, 1,
                   0, 0, 0, 0, 0, 0
           };
           for(int i = 0; i<a4.length; ++i){
               assertEquals(indexes[i], MaxAndMin.max(a4[i]));
           }
        }

        //Spesial tilfeller eller corner cases:
        int [] b = {100,3,5,6,1,7,10,11,20};
        int index1 = MaxAndMin.max(b);
        assertEquals(0,index1);
        assertEquals(100,b[index1]);

        int [] c = {3,5,6,1,7,10,11,20,100};
        int index2 = MaxAndMin.max(c);
        assertEquals(8,index2);
        assertEquals(100,c[index2]);
    }

    @org.junit.jupiter.api.Test
    void min() {
        int [] a = {3,5,6,1,7,10,100,11,20};
        int index = MaxAndMin.min(a);
        assertEquals(3,index);
        assertEquals(1,a[index]);

        //array with length of 4 all combinations:
        {
            int[][] a4 = allCombinations();
            int [] indexes = {
                    0, 0, 0, 0, 0, 0,
                    1, 1, 2, 3, 2, 3,
                    1, 1, 2, 3, 2, 3,
                    1, 1, 2, 3, 2, 3
            };
            for(int i = 0; i<a4.length; ++i){
                assertEquals(indexes[i],MaxAndMin.min(a4[i]));
            }
        }

        //Spesial tilfeller eller corner cases:
        int [] b = {1,3,5,6,100,7,10,11,20};
        int index1 = MaxAndMin.min(b);
        assertEquals(0,index1);
        assertEquals(1,b[index1]);

        int [] c = {3,5,6,100,7,10,11,20,1};
        int index2 = MaxAndMin.min(c);
        assertEquals(8,index2);
        assertEquals(1,c[index2]);

    }

    private int[][] allCombinations() {
        return new int[][]{
                {1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2, 3}, {1, 4, 3, 2},
                {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1},
                {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1},
                {4, 1, 2, 3}, {4, 1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}
        };
    }
}