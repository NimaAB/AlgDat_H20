package uke5_recursioMatrices;

import java.util.Arrays;

public class Permutasjoner {

    public static void main(String[] args) {
        int [] a = {1,2};
        permutasjoner(a,0);
    }

    static void permutasjoner(int[] a, int k){
        if(k==a.length-1){
            System.out.println(Arrays.toString(a));
        }
        for(int i =k;i<a.length;++i){
            swap(a,i,k);
            permutasjoner(a,k+1);
            swap(a,k,i);
        }
    }

    static void swap(int [] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
