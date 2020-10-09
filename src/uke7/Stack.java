package uke7;

public class Stack {
    public static void main(String[] args) {

        updateA();
        System.out.println("main");
    }

    static void updateA(){
        updateB();
        updateC();
        System.out.println("A");

    }

    static void updateB(){
        updateC();
        System.out.println("B");

    }
    static void updateC(){
        System.out.println("C");
    }
}
