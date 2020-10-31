package uke10_heap;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer [] arr = {7,10,3,2,4,6,19,2};
        MaxHeap<Integer> heap1 = new MaxHeap<>(arr, Comparator.naturalOrder());
        System.out.println(heap1.toString());
        System.out.println("Sorted: " + Arrays.toString(heap1.sort()));

    }
}
