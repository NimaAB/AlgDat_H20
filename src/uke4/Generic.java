package uke4;

public class Generic{

    static <T extends Comparable<? super  T>> int maksGeneric(T[] a){
        int max_index = 0;
        for(int i = 1; i<a.length;++i){
            if(a[i].compareTo(a[max_index])>0){
                max_index = i;
            }
        }
        return max_index;
    }

    static <T extends Comparable<? super  T>> int minGeneric(T[] a){
        int min_index = 0;
        for(int i = 1; i<a.length;++i){
            if(a[i].compareTo(a[min_index])<0){
                min_index = i;
            }
        }
        return min_index;
    }


}
