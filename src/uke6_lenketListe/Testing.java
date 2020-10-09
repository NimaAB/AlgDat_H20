package uke6_lenketListe;

public class Testing {
    public static void main(String[] args) {
        LenkedList<Integer> list = new LenkedList<>();
        int[] n = {0,1,2,3};
        for(int i: n){
            list.add(i);
        }
        list.addFirst(-1);
        list.addLast(4);
        System.out.println(list.size());
        System.out.println(list.toString());

        list.removeFirst();
        list.removeLast();
        list.remove((1));
        list.remove(1);
        list.removeFirst();
        list.clear();

        System.out.println(list.size());
        System.out.println(list.toString());


    }
}
