package uke10_heap;
import java.math.*;
import java.util.Comparator;

public class MaxHeap<E> {
    private int size;
    private E[] data;
    private int last_pos;
    Comparator<? super E> comp;
    //the heap indexing begin from 0 in this code:
    //right_child = 2*i+1
    //left_child = 2*i+2
    //parent = Math.floor(i-1/2);
    public MaxHeap(int size,Comparator<? super E> comparator){
        this.size = size;
        this.data = (E[])new Object[size];
        last_pos = 0;
        this.comp = comparator;
    }
    public MaxHeap(E[] data){
        this.size = data.length;
        this.last_pos = data.length-1;
        //TODO: making the heap:
    }

    public void add(E value){
        data[++last_pos] = value;
        if(last_pos!=2){

        }
    }
    //coming up: used in add
    public void trickleUp(int position){}
    //going down: used in remove
    public void trickleDown(int position){}
    //swaping:
    private void swap(int from,int to){
        E temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

}
