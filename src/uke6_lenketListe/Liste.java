package uke6_lenketListe;

public interface Liste<E> extends Container<E> {
    boolean addFirst(E value);//done
    boolean addLast(E value);//done
    boolean add(int index,E value);//done
    boolean add(E value);//done
    E removeFirst();//done
    E removeLast();//done
    boolean remove(E value);//done
    E remove(int index);//done
    void clear();

    E get(int index);//done
    int indexOf(E value);//done
    boolean contains(E value);//done
    int size();//done
    boolean isEmpty();//done

    //iterator:


    //default methods:

    default void indexControll(int index,int size){
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException("The posisjon: " + index+
                    " is not excepted!");
    }
    default <E> E valueControll(E value){
        if(value==null)
            throw new NullPointerException("The value is null");
        return value;
    }
}
