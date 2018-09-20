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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    Node first, last, previous;
    int size;

    private class Node {
        Item item;
        Node next;

        Node(Item gitem) {
            item = gitem;
            next = null;
        }
    }

    public Deque() {
        first = null;
        last = null;
        previous = null;
        size = 0;
    }                          // construct an empty deque

    public boolean isEmpty() {
        return first == null && last == null;
    }                 // is the deque empty?

    public int size() {
        return size;
    }                      // return the number of items on the deque

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item can not be null");

        Node node = new Node(item);
        if (isEmpty()) {
            first = node;
            first.next = null;
            last = node;
            last.next = null;
        }
        else {
            Node oldFirst = first;
            first = node;
            first.next = oldFirst;
        }
        size++;
    }          // add the item to the front

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item can not be null");

        Node node = new Node(item);

        if (isEmpty()) {
            last = node;
            last.next = null;
            first = node;
            first.next = null;
        }
        else if (last != null) {
            previous = last;
            last.next = node;
            last = node;
        }
        size++;
    }           // add the item to the end

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Item item = first.item;
        first = first.next;
        size--;
        return item;

    }                // remove and return the item from the front

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Item item = last.item;
        last = previous;
        size--;
        return item;
    }                 // remove and return the item from the end

    public Iterator<Item> iterator() {
        return new DequeIterator();

    }         // return an iterator over items in order from front to end

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }

        public Item next() {
            if (current == null)
                throw new NoSuchElementException("No item is found");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.addLast(6);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);

        System.out.println("queue " + deque.removeLast());
        System.out.println("queue " + deque.removeFirst());
        System.out.println("queue " + deque.removeLast());
        System.out.println("next " + deque.iterator().next());
        System.out.println("has next " + deque.iterator().hasNext());
        System.out.println("size " + deque.size());
    }  // unit testing (optional)


}
