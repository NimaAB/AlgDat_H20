package uke2_BineryTree;

public class BinæreTre {
    public static class Node{
        char value;
        Node rightChild;
        Node leftChild;
        Node parent;

        public Node(Node parent,char value){
            this.value=value;
            this.parent=parent;
            this.rightChild = null;
            this.leftChild = null;
        }

        void addLeftChild(char value){
            this.leftChild = new Node(this,value);
        }

        void addRightChild(char value){
            this.rightChild = new Node(this,value);
        }
        void print(){
            System.out.println(this.value);
            if(this.leftChild != null){
                this.leftChild.print();
            }
            if(this.rightChild != null){
                this.rightChild.print();
            }
        }

        Node grandParent(){
            return this.parent.parent;
        }

    }
    public static void main(String[] args) {

        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Node root = new Node(null,a[0]); //'A'
        root.addLeftChild(a[1]); //'B'
        root.addRightChild(a[2]); //'C'
        root.addLeftChild(a[3]); //'D'
        root.addRightChild(a[4]);//'E'
        root.addLeftChild(a[5]);//'F'
        root.addRightChild(a[6]);//'G'

        root.print();

    }
}

