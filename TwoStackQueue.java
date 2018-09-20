/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Partner Name:    Ada Lovelace
 *  Partner NetID:   alovelace
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;

public class TwoStackQueue {

    Stack<String> head, tail;

    TwoStackQueue() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    boolean isEmpty() {
        return head.isEmpty() && tail.isEmpty();
    }

    void enqueue(String s) {
        while (!head.isEmpty()) {
            tail.push(head.pop());
        }
        head.push(s);
        while (!tail.isEmpty()) {
            head.push(tail.pop());
        }
    }

    String dequeue() {
        return head.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("dequeue " + queue.dequeue());
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("dequeue " + queue.dequeue());
    }
}
