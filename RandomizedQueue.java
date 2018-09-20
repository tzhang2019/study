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

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] items;
    int size;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }                 // construct an empty randomized queue

    public boolean isEmpty() {
        return size == 0;
    }                 // is the randomized queue empty?

    public int size() {
        return size;
    }                        // return the number of items on the randomized queue

    public void enqueue(Item item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }           // add the item

    public Item dequeue() {
        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = null;
        return item;
    }                  // remove and return a random item

    public Item sample() {
        int index = StdRandom.uniform(size);
        return items[index];
    }                  // return a random item (but do not remove it)

    private void resize(int len) {
        Item[] arr = (Item[]) new Object[len];
        for (int j = 0; j < size; j++) {
            arr[j] = items[j];
        }
        items = arr;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }        // return an independent iterator over items in random order

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i = size;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }

        public Item next() {
            if (i == 0)
                throw new NoSuchElementException("No item is found");
            int index = StdRandom.uniform(size);
            i--;
            return items[index];
        }

    }

    public static void main(String[] args) {
        RandomizedQueue queue = new RandomizedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("deque " + queue.dequeue());
        System.out.println("deque " + queue.dequeue());

    }  // unit testing (optional)


}
