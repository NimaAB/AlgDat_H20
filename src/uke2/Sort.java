package uke2;

public class Sort {

    //Quick sort Algorithme: doesn't work yet!
    static int partition(int []a, int low,int high){

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
        a=b;
        b=temp;
    }
    //Bobble sort:
    static void bobbleSort(int [] a){
        int len = a.length;
        for(int j = len; j>=0;--j){
            for(int i = 0; i<len;++i){
                if(a[i]<a[i+1]){
                    swap(a[i],a[i+1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {10,13,4,2,19,34,11,20};
        quickSort(a,0,a.length-1);
        for(int el:a){
            System.out.print(", " + el);
        }
    }
}
