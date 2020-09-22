package uke6;

public class LenkedList<E extends Comparable<? super E>>{
    private class Node{
        E value;
        Node next;
        Node prev;
        public Node(E value){
            this.next = null;
            this.prev = null;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int currentSize;

    public LenkedList(){
        this.head = null;
        this.tail = null;
        this.currentSize=0;
    }
    public void addFirst(E obj){
        Node newNode = new Node(obj);
        if(currentSize !=0){
            newNode.next = head;
            head = newNode;
            head.prev = null;
            head.next.prev = newNode;
        }else{
            newNode.next = head;
            head = newNode;
            tail = newNode;
            tail.next=null;
            head.prev = null;
        }
        currentSize ++;
    }
    public void addLast(E obj){
        Node newNode = new Node(obj);
        if(head==null){
            head = tail = newNode;
            currentSize++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail = newNode;
        newNode.next=null;
        currentSize++;
    }


    public E removeFirst(){
        if(head==null){
            return null;
        }
        E temp = head.value;
        if(head==tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev=null;
        }
        currentSize--;
        return temp;
    }
    public E removeLast(){
        if(head==null){
            return null;
        }
        E temp = tail.value;
        if(head==tail){
            return removeFirst();//head=tail=null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        currentSize--;
        return temp;
    }
    public E remove(E obj){
        Node current = head;
        Node previos = null;

        while(current != null){
            if(obj.compareTo(current.value)==0){
                if(current == head){
                    return removeFirst();
                }
                currentSize--;
                previos.next = current.next;
                current.next.prev = previos;
                return current.value;
            }
            previos = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E obj){
        Node current = head;
        while(current != null){
            if(obj.compareTo(current.value)==0){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    Node get(Node head, Node tail, int index){
        return null;
    }

    public int size(){
        return currentSize;
    }

}
