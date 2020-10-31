package uke10_heap;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxHeap<E> {
    private ArrayList<E> data;
    private int last_pos;
    private Comparator<? super E> comp;
    //the heap indexing begin from 0 in this code:
    //right_child = 2*i+1
    //left_child = 2*i+2
    //parent = Math.floor(i-1/2);
    public MaxHeap(Comparator<? super E> comparator){
        this.data = new ArrayList<>();
        last_pos = -1;
        this.comp = comparator;
    }
    public MaxHeap(ArrayList<E> data, Comparator<? super E> comparator){
        this.last_pos = -1;
        this.data = new ArrayList<>();
        this.comp = comparator;
        //making the heap:
        for(E el: data){
            add(el);
        }

    }

    public void add(E value){
        data.add(++last_pos,value);
        trickleUp(last_pos);
    }
    //coming up: used in add
    private void trickleUp(int position){
        if(position==0){
            return;
        }
        int parent_pos = Math.floorDiv(position-1,2);
        int cmp = comp.compare(data.get(position),data.get(parent_pos));
        if(cmp>0){
            swap(position,parent_pos);
            trickleUp(parent_pos);
        }
    }

    public E remove(){
        int root = 0;
        E temp = data.get(root);
        swap(root,last_pos--);
        trickleDown(root);
        return temp;
    }
    //going down: used in remove
    private void trickleDown(int position){
        int right_child = 2*position+2;
        int left_child = 2*position+1;

        if(left_child==last_pos && comp.compare(data.get(left_child),data.get(position))>0){
            swap(position,left_child);
            return;
        }
        if(right_child==last_pos && comp.compare(data.get(right_child),data.get(position))>0){
            swap(position,right_child);
            return;
        }
        if(left_child>=last_pos || right_child>= last_pos){
            return;
        }
        int cmp = comp.compare(data.get(right_child),data.get(left_child));
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
        E temp = data.get(from);
        data.set(from, data.get(to));
        data.set(to,temp);
    }
    //heap sort by removing.
    public void sort(){
        int i = data.size()-1;
        while(i>=0){
            data.set(i,remove());
            i--;
        }
    }

    //highest priority:
    public E max(){
        return data.get(0);
    }

    //getting the data:
    public ArrayList<E> getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "data=" + Arrays.toString(data.toArray());
    }
}
