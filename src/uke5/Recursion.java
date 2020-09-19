package uke5;

import java.util.NoSuchElementException;

public class Recursion {
    static int rBinSearch(int [] a, int low,int high,int key){
        if(low==high){
            return high;
        }else if(low>high){
           return -1;
        } else{
            int mid = (low+high)/2;
            if(a[mid]>key){
                return rBinSearch(a,low,mid-1,key);
            }else if(a[mid]<key){
                return rBinSearch(a,mid+1,high,key);
            }else {
                return mid;
            }
        }
    }
    static int fakulitet(int x){
        if(x>=0) {
            return (x == 1 || x == 0) ? 1 : x * fakulitet(x - 1);
        }else{
            throw new NoSuchElementException("Error: Fakulitet av negative tall!");
        }
    }
}
