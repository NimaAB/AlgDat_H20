package uke13_selvBalanserendeTre;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class RedBlackTree<K, V> implements RedBlackI<K, V> {
    Node<K, V> root;
    int size;
    Comparator<? super K> comp;

    public RedBlackTree(Comparator<? super K> c) {
        root = null;
        size = 0;
        this.comp = c;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> right, left, parent;
        boolean isLeftChild;
        boolean isBlack;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            right = left = parent = null;
            isLeftChild = false;
            isBlack = false;
        }
    }

    @Override
    public void add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
            root.isBlack = true;
            size++;
        }
        add(root, node);
        size++;
    }

    private void add(Node<K, V> parent, Node<K, V> newNode) {
        int cmp = comp.compare(newNode.key, parent.key);
        if (cmp >= 0) {
            //addig to right:
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
                return;
            }
            add(parent.right, newNode);
        }
        if (parent.left == null) {
            parent.left = newNode;
            newNode.parent = parent;
            newNode.isLeftChild = true;
            return;
        }
        add(parent.left, newNode);

        checkColor(newNode);
    }

    private void checkColor(Node<K, V> node) {
        if (node == null) return;
        if (!node.isBlack && !node.parent.isBlack) {
            correctTree(node);
        }
        //if we have made a new violation:
        checkColor(node.parent);
    }

    private void correctTree(Node<K, V> node) {
        Node<K, V> aunt = node.parent.isLeftChild ? node.parent.parent.right
                : node.parent.parent.left;
        if (aunt == null || aunt.isBlack) {
            rotate(node);
        }
        if (node.parent.isLeftChild) {
            if (aunt != null) {
                aunt.isBlack = true;
            }
            node.parent.parent.isBlack = false;
            node.parent.isBlack = true;
        } else {
            if (aunt != null) {
                aunt.isBlack = true;
            }
            node.parent.parent.isBlack = false;
            node.parent.isBlack = true;
        }
    }

    private void rotate(Node<K, V> node) {
        Node<K, V> grandparent = node.parent.parent;
        Node<K, V> temp = null;
        if (node.isLeftChild && node.parent.isLeftChild) {
            //right rotation:
            temp = grandparent.left;
            grandparent.left = temp.right;
            temp.right = grandparent;
        }
        if (!node.isLeftChild && !node.parent.isLeftChild) {
            //left rotation:
            temp = grandparent.right;
            grandparent.right = temp.left;
            temp.left = grandparent;
        }
        if (node.isLeftChild && !node.parent.isLeftChild) {
            //right-left rotation:

        }
        if (!node.isLeftChild && node.parent.isLeftChild) {
            //left-right rotation:
        }

    }

    private Node<K, V> leftRotation(Node<K, V> node) {
        Node<K, V> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private Node<K, V> rightRotation(Node<K, V> node) {
        Node<K, V> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }
}
