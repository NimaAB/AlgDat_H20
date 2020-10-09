package uke4_Generic;

import java.util.NoSuchElementException;

public class GenericSorting <T extends Comparable<? super T>>{
    private T[] a;
    public GenericSorting(T[] a){
        setA(a);
    }
    private void setA(T[] a) {
        if(a.length<=1){
            throw new NoSuchElementException("Tom array??");
        }
        this.a = a;
    }
    private void  quickSort(T[]a,int begin,int end){
        if(begin>=end)return;
        int pi = partition(a,begin,end);
        quickSort(a,begin,pi-1);
        quickSort(a,pi+1,end);
    }

    private int partition(T[]a,int begin,int end){
        int pivot = end;
        int pi = begin;
        for (int i = begin; i < end; i++){
            if (a[i].compareTo(a[end])<0) {
                T temp = a[pi];
                a[pi] = a[i];
                a[i] = temp;
                pi++;
            }
        }
        T temp = a[pivot];
        a[pivot] = a[pi];
        a[pi] = temp;
        return pi;
    }
    void sort(){
        int begin = 0;
        int end = a.length;
        quickSort(a, begin,end-1);
    }
}
