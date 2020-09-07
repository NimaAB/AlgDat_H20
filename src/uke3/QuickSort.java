package uke3;

import java.util.Arrays;

public class QuickSort {

    static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    //Quick Sort implementation:
    static int partisjon(int [] a,int begin,int end) {
        int pi = begin;
        for (int i = begin; i < end; i++){
            if (a[i] < a[end]) {
                int temp = a[pi];
                a[pi] = a[i];
                a[i] = temp;
                pi++;
            }
        }
        int temp = a[end];
        a[end] = a[pi];
        a[pi] = temp;
        return pi;
    }
    static void quickSort(int [] a,int begin,int end){
        if(end <= begin) return;

        int pP = partisjon(a, begin, end);
        quickSort(a, begin, pP-1);
        quickSort(a,pP+1, end);
    }

}

