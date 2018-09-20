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

import java.util.ArrayList;
import java.util.List;

public class Interview {
    static int findMaxLength(int[] arr) {
        int max = 0;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            int count = 1;
            visited.add(i);
            visited.add(j);
            while (!visited.contains(i) && i != arr[j]) {
                j = arr[j];
                visited.add(j);
                count++;
            }
            if (i == arr[j]) {
                count++;
            }
            if (count > max)
                max = count;
        }
        return max;
    }

    static int fabinacci(int n) {
        int[] arr = new int[n];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1];
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryover = 0;
        ListNode node = null, oldNode = null;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (carryover == 1) {
                sum += carryover;
                carryover = 0;
            }
            if (sum > 9) {
                carryover = 1;
                sum = sum % 10;
            }
            ListNode sumnode = new ListNode(sum);
            if (node == null) {
                node = sumnode;
                oldNode = node;
            }
            else {
                node.next = sumnode;
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        return oldNode;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static int reverse(int x) {
        int y = 0;
        while (Math.abs(x) > 9) {
            int dig = x % 10;
            y = y * 10 + dig * 10;
            x /= 10;
        }
        y += x;
        return y;
    }

    static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isPair((char) stack.pop(), c))
                    return false;
            }
        }
        return true;
    }

    static boolean isPair(char left, char right) {
        if ((left == '{' && right == '}')
                || (left == '(' && right == ')')
                || (left == '[' && right == ']'))
            return true;
        return false;
    }

    static ListNode mergeSortedList(ListNode l1, ListNode l2) {

        ListNode node = null, oldNode = null;
        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode(l1.val);
            newNode.next = new ListNode(l2.val);
            if (node == null) {
                node = newNode;
                oldNode = node;
            }
            else {
                node.next.next = newNode;
                node = node.next.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return oldNode;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 0, 3, 4, 8, 1, 7, 6, 2 };
        //System.out.println("Found max " + findMaxLength(arr));
        //System.out.println("fabinacci " + fabinacci(36));
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        //ListNode node = addTwoNumbers(l1, l2);
        ListNode node = mergeSortedList(l1, l2);
        while (node != null) {
            System.out.println("sum " + node.val);
            node = node.next;
        }
        //System.out.println("reverse " + reverse(120));
        //String s = "{[()]}()";
        //System.out.println("is Valid " + isValid(s));

    }
}
