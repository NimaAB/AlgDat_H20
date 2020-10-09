package uke3_Sorting;

import java.util.Arrays;

public class BobbleSort {
    public static void bobbleSort(int [] a){
        for(int j = a.length; j >= 0; --j){
            for(int k = 0; k < a.length-1;++k){
                if(a[k]>a[k+1]){
                    int temp = a[k];
                    a[k] = a[k+1];
                    a[k+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {15, 3, 4, 60, 9, 1, 0, -4};
        System.out.println(Arrays.toString(a));
        bobbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
