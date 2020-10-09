package uke6;

import java.util.*;

public class LenkedList<E> implements Liste<E>{


    private class LinkedListIterator implements Iterator<E>{
        private Node<E> thisNode;
        private boolean deleted;
        private int iteratorChanges;

        private LinkedListIterator(){
            thisNode = head;
            deleted = false;
            iteratorChanges = changes;
        }
        private LinkedListIterator(int index){
            thisNode = findNode(index);
            deleted = false;
            iteratorChanges = changes;
        }


        @Override
        public boolean hasNext() {
            return thisNode!=null;
        }

        @Override
        public E next() {
            if(changes!=iteratorChanges)
                throw new ConcurrentModificationException("Changes are"+
                        " not equal.");
            if(!hasNext())
                throw new NoSuchElementException("The list has reached the end!.");

            deleted = true;
            E returnValue = thisNode.value;
            thisNode = thisNode.next;
            return returnValue;
        }

        @Override
        public void remove() {
            if(currentSize==0 || !deleted)
                throw new IllegalStateException("The list i empty");
            if(changes!=iteratorChanges)
                throw new ConcurrentModificationException("Changes are"+
                        " not equal.");

            deleted = false;
            //listen har et element:
            if (head == tail) {
                head = tail = null;
            }
            //denne har gaatt over hale:
            else if (thisNode==null) {
                tail.prev.next = null;
                tail = tail.prev;
            }
            //hvis pekeren er hode eller hode sin neste node:
            else if (thisNode == head.next) {
                thisNode.prev = null;
                head = thisNode;
            }else if(thisNode==head){
                head = thisNode.next;
                thisNode.next.prev=null;
                thisNode = null;

            }
            //ellers saa hode er ingen av tilfellene over og denne peker paa et
            //tilfeldig node i midten:
            else {
                thisNode.prev.prev.next = thisNode;
                thisNode.prev = thisNode.prev.prev;
            }

            iteratorChanges++;
            changes++;
            currentSize--;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Iterator<E> iterator(int index) {
        indexControll(index,currentSize);
        return new LinkedListIterator(index);
    }


    private static final class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
        public Node(E value){
            this.next = null;
            this.prev = null;
            this.value = value;
        }
        public Node(E value,Node<E> prev,Node<E> next){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;
    private int changes;

    public LenkedList(){
        this.head = null;
        this.tail = null;
        this.currentSize=0;
    }

    //adding nodes:
    @Override
    public boolean addFirst(E value){
        return add(0,value);
    }
    @Override
    public boolean addLast(E value){
        return add(currentSize,value);
    }

    @Override
    public boolean add(E value){
        return addLast(value);
    }

    @Override
    public boolean add(int index, E value){
        //IndexOutOfBounds and NullPointer:
        if(index<0||index>=currentSize+1)
            throw new IndexOutOfBoundsException("Index: " + index+ "current size: " + currentSize);
        valueControll(value);

        Node<E> newNode = new Node<>(value);

        if(head == null){
            head=tail=newNode;
        }
        else if(currentSize==1){
            head.next = newNode;
            tail = newNode;
            tail.next = null;
            tail.prev=head;
        }
        else if(index==0){
            newNode.prev=null;
            newNode.next=head;
            head.prev = newNode;
            head = newNode;
        }
        else{
            Node<E> curr = findNode(index-1);
            //valueControll(curr);
            if(curr == tail){
                tail.next = newNode;
                newNode.prev=tail;
                newNode.next = null;
                tail = newNode;
            }
            else{
                newNode.next=curr.next;
                newNode.prev=curr;
                curr.next.prev=newNode;
                curr.next=newNode;
            }
        }
        currentSize++;
        changes++;

        return true;
    }

    //removing nodes:
    @Override
    public E removeFirst(){
        return remove(0);
    }

    @Override
    public E removeLast(){
        return remove(currentSize-1);
    }

    @Override
    public boolean remove(E value){
        //Nullpointer:
        valueControll(value);

        int index = indexOf(value);
        remove(index);
        return true;

    }

    @Override
    public E remove(int index){
        //IndexOutOfBound:
        indexControll(index,currentSize);
        E removedValue; //The value of the targeted node.
        if(currentSize==1){
            removedValue = head.value;
            head=tail=null;
        }else if(index==currentSize-1){
            //remove tail and declare a new tail:
            removedValue = tail.value;
            tail.prev.next=null;
            tail = tail.prev;
        }else if(index==0){
            removedValue = head.value;
            head.next.prev=null;
            head=head.next;
        }else{
            //index>0||index<currentSize:
            Node<E> nodeToRemove = findNode(index);
            removedValue = nodeToRemove.value;
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        currentSize--;
        changes++;
        return removedValue;
    }

    @Override
    public void clear(){
        while(head!=tail){
            head.next.prev=null;
            head=head.next;
            changes++;
        }
        head=tail=null;
        currentSize=0;
    }

    @Override
    public int indexOf(E value){
        //Nullpointer:
        valueControll(value);

        int index = 0;
        while(index<currentSize){
            if(get(index).equals(value))
                return index;
        }
        return -1;
    }
    @Override
    public boolean contains(E value){
        return indexOf(value)!=-1;
    }
    @Override
    public E get(int index){
        //returning the value:
        return valueControll(findNode(index)).value;
    }

    @Override
    public int size(){
        return currentSize;
    }

    @Override
    public boolean isEmpty(){
        return currentSize==0;
    }
    private static <E> E[] toArray(Liste<E> list){
        Object [] l = new Object[list.size()];
        int i=0;
        for (E el:list) {
            l[i] = el;
            i++;
        }
        return (E[])l;
    }

    public static <E>
    void sort(Liste<E> list, Comparator<E> c){
        //bobble sort:
        E [] l = toArray(list);

        for(int j = l.length; j >= 0; --j){
            for(int k = 0; k < l.length-1;++k){
               if(c.compare(l[k],l[k+1])>0){
                    E temp = l[k];
                    l[k] = l[k+1];
                    l[k+1] = temp;
               }
            }
        }
    }

    //hjelpe metode:
    private Node<E> findNode(int index){
        indexControll(index,currentSize);

        int middle = currentSize/2;
        Node<E> begin = ( index > middle ) ? tail : head;
        int i=0;
        while (i<currentSize){
            if(i==index)
                return begin;
            if(begin==tail)
                begin=begin.prev;

            begin = begin.next;
            i++;
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ","[","]");
        Node<E> curr = head;
        while(curr!=null){
            sj.add(curr.value.toString());
            curr = curr.next;
        }
        return sj.toString();
    }
}
