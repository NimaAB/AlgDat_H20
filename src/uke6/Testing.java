package uke6;

import java.util.LinkedList;

public class Testing {
    public static void main(String[] args) {
        LenkedList<Integer> list = new LenkedList<>();
        int n = 14;
        for(int i = 0; i<n;i++){
            list.addLast(i);
        }
        System.out.println(list.size());
        list.removeLast();
        list.removeLast();
        System.out.println(list.size());
        System.out.println(list.contains(13));
    }
}
