package uke1;

public class MaxAndMin {
    static int max(int[] a){
        int index = 0;

        for(int i = 1; i<a.length; ++i){
            if(a[index]<a[i]){
                index = i;
            }
        }
        return index;
    }


    static int min(int[] a){
        int index = 0;

        for(int i = 1; i<a.length; ++i){
            if(a[index]>a[i]){
                index = i;
            }
        }
        return index;
    }

}
