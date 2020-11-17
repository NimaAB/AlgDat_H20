package eksamen_2019;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Oppgave1 {
    private static void del1() {
        /*** Del 1: Verdier vi skal legge inn*/
        char[] values_1 = "ALFABET".toCharArray();
        char[] values_2 = "FISK".toCharArray();
        /*** Del 2: Queue her*/
        System.out.println("Del2");
        Queue queue = new LinkedList<Character>();
        for (char value : values_1) {
            queue.add(value);
        }
        System.out.print("Queue first: " + queue.remove());
        for (int i = 0; i < 4; ++i) {
            System.out.print(", " + queue.remove());
        }
        System.out.println();
        for (char value : values_2) {
            queue.add(value);
        }
        System.out.print("Queue second: " + queue.remove());
        while (!queue.isEmpty()) {
            System.out.print(", " + queue.remove());
        }
        System.out.println();
        /***Del 3:Stack her*/
        System.out.println("Del 3");
        Stack stack = new Stack<Character>();
        for (char value : values_1) {
            stack.push(value);
        }
        System.out.print("Stack first: " + stack.pop());
        for (int i = 0; i < 4; ++i) {
            System.out.print(", " + stack.pop());
        }
        System.out.println();
        for (char value : values_2) {
            stack.push(value);
        }
        System.out.print("Stack second: " + stack.pop());
        while (!stack.isEmpty()) {
            System.out.print(", " + stack.pop());
        }
        System.out.println();
        /***Del 4:PriorityQueue her*/
        System.out.println("Del 4");
        Queue pri_queue = new PriorityQueue();
        for (char value : values_1) {
            pri_queue.add(value);
        }
        System.out.print("Priority queue first: " + pri_queue.remove());
        for (int i = 0; i < 4; ++i) {
            System.out.print(", " + pri_queue.remove());
        }
        System.out.println();
        for (char value : values_2) {
            pri_queue.add(value);
        }
        System.out.print("Priority queue second: " + pri_queue.remove());
        while (!pri_queue.isEmpty()) {
            System.out.print(", " + pri_queue.remove());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        del1();
    }
}
