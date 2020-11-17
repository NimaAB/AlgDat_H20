package uke7_bufferKøStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @Test
    void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(9);
        assertEquals(3,stack.getSize());
        String str1 = stack.toString();
        String forvented = "[9, 3, 2]";
        assertEquals(forvented,str1);

        Integer [] array = {1,2,4,5,7,8,9,11};
        LinkedListStack<Integer> stack1 = new LinkedListStack<>(array);
        int expectedSize = array.length;
        int actualSize =stack1.getSize();
        String expStr = "[11, 9, 8, 7, 5, 4, 2, 1]";
        String actualStr = stack1.toString();

        int antFeil = 0;
        if(expectedSize!=actualSize){
            antFeil++;
            System.out.println("Size isn't right!");
        }
        if(!expStr.equals(actualStr)){
            antFeil++;
            System.out.println("toString() is wrong");
        }
        LinkedListStack<Integer> st2 = new LinkedListStack<>();
        if(!st2.toString().equals("[]")){
            antFeil++;
            System.out.println("toString() is wrong, when size is 0");
        }
        assertEquals(0,antFeil);
    }

    @Test
    void pop() {
        Integer [] array = {1,2,4,5,7,8,9,11};
        LinkedListStack<Integer> stack1 = new LinkedListStack<>(array);
        int actualVal = stack1.pop();
        int expectedVal = 11;
        int expectedSize = array.length-1;
        int actualSize =stack1.getSize();
        String expStr = "[9, 8, 7, 5, 4, 2, 1]";
        String actualStr = stack1.toString();

        int antFeil = 0;
        if(actualVal!=expectedVal){
            antFeil++;
            System.out.println("It pop a wrong item from the stack" + actualVal);
        }
        if(expectedSize!=actualSize){
            antFeil++;
            System.out.println("Size isn't right!");
        }
        if(!expStr.equals(actualStr)){
            antFeil++;
            System.out.println("toString() is wrong");
        }
        assertEquals(0,antFeil);
    }

}