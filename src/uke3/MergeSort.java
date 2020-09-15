package uke3;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int [] a, int left, int right){
        if(left<right){
            int mid = left + (right - left)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            flett(a,left,mid,right);
        }

    }
    static void flett(int [] a,int left,int mid, int right){

        int n1 = mid-left+1;
        int n2=right-mid;
        int [] first_half = new int[n1];
        int [] second_half = new int [n2];

        for(int i = 0;i<n1;++i){
            first_half[i]=a[left + i];
        }
        for(int i =0;i<n2;++i){
            second_half[i] = a[mid+1+i];
        }
        int [] merged=new int[first_half.length+second_half.length];
        int j = 0,i=0,k=0;
        while(i<first_half.length&&j<second_half.length){
            if(first_half[i]>second_half[i]){
                merged[k++]=second_half[j++];
                merged[k++] = first_half[i++];
            }else{
                merged[k++] = first_half[i++];
                merged[k++]=second_half[j++];
            }
        }
        while(i<first_half.length) merged[k++]=first_half[i++];
        while (j<second_half.length) merged[k++]=second_half[j++];
    }

    public static void main(String[] args) {
        int [] a = {11,12,13,1,20,3,4};
        mergeSort(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }

    static int [] merge(int [] a,int [] b){
        int [] merged = new int[a.length+b.length];
        int i = 0; int j = 0; //for å telle indeksne til a og b
        int k = 0;//for å holde på indeksene i den nye array-et

        while(i<a.length && j<b.length){
            if(a[i]>b[i]){
                merged[k++] = b[j++];
                merged[k++] = a[i++];
            }else{
                merged[k++] = a[i++];
                merged[k++] = b[j++];
            }
        }
        while(i<a.length){
            merged[k++] = a[i++];
        }

        while(j<b.length){
            merged[k++] = b[j++];
        }
        return merged;
    }


}
