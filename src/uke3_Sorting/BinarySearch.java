package uke3_Sorting;
import java.util.NoSuchElementException;
/*
* The list that we will do the binary search on must be sorted.
*
* */
public class BinarySearch {
    static int search(int [] a,int key,int low, int high){
        int mid;
        while(low<=high){
            mid = (high+low)/2;
            if(a[mid]==key){
                return mid;
            }
            if(a[mid]<key){
               low = mid+1;
            }else{
                high=mid-1;
            }
        }
        throw new NoSuchElementException("Element not found");
    }

    public static void main(String[] args) {
        int [] a = {-10,1,4,5,7,8,9,10,11};
        try{
            int index = search(a,-1,0,a.length);
            System.out.println(index);
            System.out.println(a[index]);
        }catch (NoSuchElementException e){
            System.err.println(e.getMessage());
        }
    }
}
