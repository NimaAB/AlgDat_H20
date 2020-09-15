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
        int ans =0;
        switch (y){
            case 2: ans=2; break;
            case 3: ans=6; break;
            case 4: ans=24; break;
            case 5: ans=120; break;
            case 6: ans=720; break;
            case 7: ans=5040; break;
            default:ans=1;break;
        }
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