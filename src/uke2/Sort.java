package uke2;

import java.util.Arrays;

public class Sort {

    //Quick sort Algorithme: doesn't work yet!
    static int partition(int []a, int low,int high){ //TODO:jobb med det.

        int pivot = a[low];
        int i = low, j = high;
        while(i<j){
            do{
                i++;
            }while(a[i]<=pivot);
            do{
                j--;
            }while (a[j]>pivot);
            if(i<j){
                swap(a[i],a[j]);
            }
        }
        swap(a[low],a[j]);
        return j;
    }
    static void quickSort(int [] a, int low, int high){
        if(low<high){
            int j = partition(a,low,high);
            quickSort(a,low,j-1);
            quickSort(a,j+1,high);
        }
    }
    ///// Swap:
    static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    //Bobble sort:
    static void bobbleSort(int [] a){
        int len = a.length-1;
        for(int j = len; j>=0;--j){
            for(int i = 0; i<len-1;++i){
                if(a[i]<a[i+1]){
                   swap(a[i],a[i+1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 73, 4, 2, 19, 34, 11, 20};
        //quickSort(a,0,a.length-1);
        delsortert(a);
        System.out.print(Arrays.toString(a));
        System.out.println();
    }
    static void delsortert(int [] a){
        int begin = 0;
        int end = a.length -1;
        for (int i = begin; i < end; i++) {
            if (a[i] % 2 == 0) {
                int temp = a[i];
                a[i] = a[end];
                a[end] = temp;
                end--;
                i--;
            }
        }
        sort(a,begin,end-1);
    }
    static void sort(int [] a,int low, int high){
        //quick sort??
        if(low<high){
            int j = partition(a,low,high);
            sort(a,low,j-1);
            sort(a,j+1,high);
        }
    }



    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(a.length != 0){
            int end = a.length-1;
            char tempt = a[end];
            for(int i = end; i > 0; i--){
                a[i] = a[i-1];
                if(i == 1){
                    a[0] = tempt;
                }
            }
        }
    }
    static void rotate(char [] a, int k){
        if(k < 0){
            k = a.length + k;
        }
        if(a.length != 0){
            for(int i = 0; i < k; i++){
                int n = a.length - 1;
                char tempt = a[n];
                while(n > 0){
                    a[n] = a[n-1];
                    if(n == 1){
                        a[0] = tempt;
                    }
                    n--;
                }
            }
        }
    }
}
