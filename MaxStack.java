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

public class MaxStack {

    int[] stack;
    int size;

    MaxStack() {
        stack = new int[1];
        size = 0;
    }

    void push(int number) {
        stack[size++] = number;
        if (size == stack.length)
            resize(2 * stack.length);
    }

    int pop() {
        int num = stack[--size];
        stack[size] = 0;
        return num;
    }

    void resize(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < stack.length; i++) {
            arr[i] = stack[i];
        }
        stack = arr;
    }

    int findMax() {
        int max = stack[0];
        for (int i = 1; i < stack.length; i++) {
            if (stack[i] > max)
                max = stack[i];
        }
        return max;
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(2);
        stack.push(6);
        stack.push(9);
        System.out.println("poped" + stack.pop());
        System.out.println("Max is " + stack.findMax());
    }
}
