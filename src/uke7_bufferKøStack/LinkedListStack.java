package uke7_bufferKøStack;

import java.util.StringJoiner;

public class LinkedListStack<T> implements Stack<T> {


    private class Node<T> {
        Node<T> next;
        T value;
        public Node(T val){
            this.next = null;
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
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
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