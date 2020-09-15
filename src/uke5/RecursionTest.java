package uke5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @Test
    void rBinSearch() {
        int [] a = {1,3,4,6,9,10};
        int index =Recursion.rBinSearch(a,0,a.length,5);
        if(index == -1){
            System.out.println("element not found!");
            return;
        }
        assertEquals(2,index);
        assertEquals(a[2],a[index]);
    }
    @Test
    void fakulitet(){
        int y = randomTall();
        int ans= switch (y){
            case 2 -> 2;
            case 3 -> 6;
            case 4 -> 24;
            case 5 -> 120;
            case 6 -> 720;
            case 7 -> 5040;
            default -> 1;
        };
        try{
            int w = Recursion.fakulitet(y);
            assertEquals(ans,w);
        }catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }

    }
    //help methode:
    int randomTall(){
        int [] a = {-100,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7};
        Random rd = new Random();
        int x = rd.nextInt(16);
        return a[x];
    }
}