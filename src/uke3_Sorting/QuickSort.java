package uke3_Sorting;

import java.util.Arrays;

public class QuickSort {

    //Takes the last element as pivot:
    static int partisjon1(int [] a,int begin,int end) {
        int pivot = end;
        int pi = begin;
        for (int i = begin; i < end; i++){
            if (a[i] < a[end]) {
                int temp = a[pi];
                a[pi] = a[i];
                a[i] = temp;
                pi++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[pi];
        a[pi] = temp;
        return pi;
    }
    static void quickSort(int [] a,int begin,int end){
        if(end <= begin) return;
        int pP = partisjon1(a, begin, end);
        quickSort(a, begin, pP-1);
        quickSort(a,pP+1, end);
    }
    //Takes the middle element of the array as a pivot:
    static int partition2(int[] a,int begin,int end){
        int pivot = begin + (end - begin)/2;
        int temp = end;
        end = pivot;
        pivot = temp;
        int left = begin;

        for(int i =begin; i<end;++i){
            if(a[i]<a[pivot]){
                int temp1 = a[left];
                a[left]=a[i];
                a[i] = temp1;
                left++;
            }
        }
        int temp2 = a[pivot];
        a[pivot] = a[left];
        a[left] = temp2;
        return left;
    }
    static void quickSort2(int [] a,int begin,int end){
        if(end <= begin) return;
        int pP = partition2(a, begin, end);
        quickSort(a, begin, pP-1);
        quickSort(a,pP+1, end);
    }

    public static void main(String[] args) {
        int []a={3,4,5,1,-6,10,9,12,2,40,0};
        quickSort2(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

}

