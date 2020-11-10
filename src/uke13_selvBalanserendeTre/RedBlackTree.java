package uke13_selvBalanserendeTre;

import java.util.Comparator;

public class RedBlackTree<K,V> implements RedBlackI<K,V> {
    Node<K,V> root;
    int size;
    Comparator<? super K> comp;
    public RedBlackTree(Comparator<? super K> c){
        root = null;
        size = 0;
        this.comp = c;
    }
    static class Node<K,V> {
        K key;
        V value;
        Node<K,V> right,left, parent;
        boolean isLeftChild;
        boolean isBlack;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            right = left = parent = null;
            isLeftChild = false;
            isBlack = false;
        }
    }

    @Override
    public void add(K key, V value) {
        Node<K,V> node = new Node<>(key, value);
        if(root==null){
            root = node;
            root.isBlack = true;
            size++;
        }
        add(root, node);
        size++;
    }
    private void add(Node<K,V> parent, Node<K,V> newNode){
        int cmp = comp.compare(newNode.key,parent.key);
        if(cmp > 0){
            //addig to right:
            if(parent.right==null){
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
                return;
            }
            add(parent.right,newNode);
        }
        if(parent.left == null){

        }
    }
}
