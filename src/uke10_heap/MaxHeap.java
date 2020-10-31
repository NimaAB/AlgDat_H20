package uke10_heap;
import java.math.*;
import java.util.Arrays;
import java.util.Comparator;

public class MaxHeap<E> {
    private int size;
    private E[] data;
    private int last_pos;
    private Comparator<? super E> comp;
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
    public MaxHeap(E[] data, Comparator<? super E> comparator){
        this.size = data.length;
        this.last_pos = -1;
        this.data = (E[])new Object[size];
        this.comp = comparator;
        //TODO: making the heap:
        for(E el: data){
            add(el);
        }

    }

    public void add(E value){
        data[++last_pos] = value;
        trickleUp(last_pos);
    }
    //coming up: used in add
    private void trickleUp(int position){
        if(position==0){
            return;
        }
        int parent_pos = Math.floorDiv(position-1,2);
        int cmp = comp.compare(data[position],data[parent_pos]); //{0,1,2,3,4} id=0 -> id=1 & 2
        if(cmp>0){
            swap(position,parent_pos);
            trickleUp(parent_pos);
        }
    }

    public E remove(){
        int root = 0;
        E temp = data[root];
        swap(root,last_pos--);
        trickleDown(root);
        return temp;
    }
    //going down: used in remove
    private void trickleDown(int position){
        int right_child = 2*position+2;
        int left_child = 2*position+1;

        if(left_child==last_pos && comp.compare(data[left_child],data[position])>0){
            swap(position,left_child);
            return;
        }
        if(right_child==last_pos && comp.compare(data[right_child],data[position])>0){
            swap(position,right_child);
            return;
        }
        if(left_child>=last_pos || right_child>= last_pos){
            return;
        }
        int cmp = comp.compare(data[right_child],data[left_child]);
        if(cmp>0){
            swap(position,right_child);
            trickleDown(right_child);
        }else if(cmp<0){
            swap(position,left_child);
            trickleDown(right_child);
        }
    }
    //swaping:
    private void swap(int from,int to){
        E temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
    //heap sort by removing.
    public E[] sort(){
        E [] sort = (E[]) new Object[size];
        int i =0;
        while(i<size){
            sort[i] = remove();
            i++;
        }
        return sort;
    }

    @Override
    public String toString() {
        return "data=" + Arrays.toString(data);
    }
}
