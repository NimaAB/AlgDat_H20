package uke9_MoreAboutBineryTree;

import java.util.ArrayDeque;
import java.util.Objects;

public class BineryTree<E> {
    static class BTNode<E>{
        E value;
        BTNode<E> leftChild;
        BTNode<E> rightChild;

        BTNode(E value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        BTNode<E> addLeftChild(E value){
            Objects.requireNonNull(value);
            this.leftChild = new BTNode<>(value);
            return this.leftChild;
        }
        BTNode<E> addRightChild(E value){
            Objects.requireNonNull(value);
            this.rightChild = new BTNode<>(value);
            return this.rightChild;
        }
    }

    public static void main(String[] args) {
        //lager root noden:
        BTNode<Character> root = new BTNode<>('A');

        //legger til barna til A på nivå 1:
        BTNode<Character> b = root.addLeftChild('B');
        BTNode<Character> c = root.addRightChild('C');

        //legger til nodene på nivå 2:
        //barna til b:
        BTNode<Character> d = b.addLeftChild('D');
        BTNode<Character> e = b.addRightChild('E');

        //barna til c:
        BTNode<Character> f = c.addLeftChild('F');
        BTNode<Character> g = c.addRightChild('G');

        //skriver ut i nivå-orden:
        System.out.print("level order: ");
        printLevelOrder(root);

        System.out.println("\n============");
        System.out.print("pre order: ");
        printPreOrder(root);

        System.out.println("\n============");
        System.out.print("in order: ");
        printInOrder(root);

        System.out.println("\n============");
        System.out.print("post order: ");
        printPostOrder(root);
    }

    static <E> void  printPreOrder(BTNode<E> node){
        if(node==null) return;

        System.out.print(node.value + " ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }
    static <E> void  printInOrder(BTNode<E> node){
        if(node==null) return;

        printInOrder(node.leftChild);
        System.out.print(node.value + " ");
        printInOrder(node.rightChild);
    }

    static <E> void  printPostOrder(BTNode<E> node){
        if(node==null) return;

        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    static <E> void printLevelOrder(BTNode<E> root){
        ArrayDeque<BTNode<E>> queue = new ArrayDeque<>();
        //legger  inn roten i arrayet:
        queue.addLast(root);

        //går gjennom arraryet så lenge den er ikke tom:
        while(!queue.isEmpty()){
            //sletter den første i arrayet og beholder verdien:
            BTNode<E> current = queue.removeFirst();
            //legger inn barna til ned slettede parent noden:
            if(current.leftChild!=null){
                queue.addLast(current.leftChild);
            }
            if(current.rightChild!=null){
                queue.addLast(current.rightChild);
            }
            //skriver ut parent noden:
            System.out.print(current.value + " ");
        }

    }
}
