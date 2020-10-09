package uke6_lenketListe;

public class Extra<E> {
    class Node{
        E value;
        Node next;
        Node prev;
        public Node(E value){
            this.value = value;
            this.next=null;
            this.prev=null;
        }
    }
    /**
     * A method for inserting a value between to other values
     * by moving the pointers form p to q and making a pointer from q to r.
     * And backwards: from r to q and q to p.
     * @param p => The node before.
     * @param q => The node that we want to insert.
     * @param r => The node after.
     *
     */
    void insert(Node p, Node q, Node r){
        p.next = q;
        q.next = r;
        r.prev = q;
        q.prev = p;
    }

    /**
     * A method for removing a node from a list.
     * The method will take the pointer from p to q and land it on r.
     * And the backward pointer from r will land on p. Then, the q node will be useless and free,
     * which allows Java to collect it to the Garbage collection.
     * @param p => The node which is before the q.
     * @param q => The node that we want to remove.
     * @param r => The node which is after the q.
     */
    void remove(Node p,Node q,Node r){
        p.next = r;
        r.prev = p;
    }
}
