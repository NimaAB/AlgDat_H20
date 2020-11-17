package uke7_bufferKøStack;

import java.util.StringJoiner;

public class LinkedListStack<T> implements Stack<T> {


    private class Node<T> {
        Node<T> next;
        T value;
        public Node(T val,Node<T> next){
            this.next = next;
            this.value = val;
        }
    }

    private Node<T> head;
    private int size;
    public LinkedListStack(){
        this.head = null;
        this.size = 0;
    }
    public LinkedListStack(T[] list){
        for(T el:list){
            push(el);
        }
    }

    @Override
    public void push(T value) {
        //Node<T> newNode =
        new Node<>(value,head);
        size++;
    }

    @Override
    public T pop() {
        T temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ","[","]");
        if(size==0){
            return sj.toString();
        }
        Node<T>current = head;
        while(current!=null){
            sj.add(current.value.toString());
            current = current.next;
        }
        return sj.toString();
    }
}
interface Stack<T>{
    void push(T value);
    T pop();
}