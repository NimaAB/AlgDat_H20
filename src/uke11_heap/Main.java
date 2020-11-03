package uke11_heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer [] arr = {7,10,3,2,4,6,19,2};
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(arr));

        MaxHeap<Integer> heap1 = new MaxHeap<>(ar, Comparator.naturalOrder());
        System.out.println(heap1.toString());
        //max number in a collection with complexity O(logn):
        int maximum = heap1.max();
        System.out.println("Highest priority in the max heap: " + maximum);

        heap1.sort(); //we don't get the right resulte with max after sorting.
        System.out.println(heap1.toString());

        ArrayList<Integer> ar2 = heap1.getData();
        MaxHeap<Integer> heap2 = new MaxHeap<>(Comparator.naturalOrder());
        for(Integer el: ar2){
            heap2.add(el);
        }
        System.out.println(heap2.toString());
    }
}
