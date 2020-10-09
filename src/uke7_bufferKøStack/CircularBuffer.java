package uke7_bufferKøStack;

public class CircularBuffer<T> {
    private Object [] buffer;
    private int size;
    private int numEl;
    private int head,tail;

    public CircularBuffer(int size){
        this.size = size;
        this.buffer = new Object[size];
        this.numEl = 0;
        this.head = this.tail = 0;
    }

    public void offerBack(T value){
        //edges:
        //we dont want any null values:
        if(value == null)
            return;

        //adding more the size at once.
        innleggingKontrol();

        //adding:
        buffer[tail]=value;
        tail = (tail+1)%size;
        numEl++;
    }

    public T popFront(){
        //edges:
        // poping more than numEl at once!!
        popKontroll();

        //pop:
        Object retValue = buffer[head];
        head = (head + 1) % size;
        numEl--;
        return  (T) retValue;
    }

    public int size() {
        return size;
    }

    public int numEl() {
        return numEl;
    }

    private void innleggingKontrol(){
        if(numEl+1>size)
            throw new IndexOutOfBoundsException("Your can't set in to many valve at once: size= " + size);
    }
    private void popKontroll(){
        if(numEl<=0)
            throw new IndexOutOfBoundsException("Your buffer has no values yet: number of values = " + numEl());
    }
}
