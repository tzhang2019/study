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
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    int[][] sites;
    WeightedQuickUnionUF uf;

    //
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Number is negative or zero");
        sites = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = -1;
            }
        }
        uf = new WeightedQuickUnionUF(n * n);
    }

    //
    public void open(int row, int col) {
        int size = sites.length;
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new IllegalArgumentException("Number is not in range");
        sites[row][col] = 0;

    }

    //
    public boolean isOpen(int row, int col) {
        int size = sites.length;
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new IllegalArgumentException("Number is not in range");
        if (sites[row][col] >= 0)
            return true;
        return false;
    }

    //
    public boolean isFull(int row, int col) {
        int size = sites.length;
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new IllegalArgumentException("Number is not in range");

        if (isOpen(row, col)) {
            for (int i = 0; i < size; i++) {
                if (isOpen(0, i) && uf.connected(sites[0][i], sites[row][col]))
                    return true;
            }
        }
        return false;
    }

    //
    public int numberOfOpenSites() {
        int size = sites.length;
        int num = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (sites[i][j] >= 0)
                    num++;
            }
        }
        return num;
    }

    //
    public boolean percolates() {
        int size = sites.length;
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isFull(i, j)) {
                    System.out.println("isFull row " + i + " col " + j + " index " + index);
                    if (i == size - 1)
                        return true;
                    sites[i][j] = index;
                    index++;

                    if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < size && j + 1 < size) {
                        if (isFull(i - 1, j))
                            uf.union(sites[i][j], sites[i - 1][j]);
                        if (isFull(i, j - 1))
                            uf.union(sites[i][j], sites[i][j - 1]);
                        if (isFull(i, j + 1))
                            uf.union(sites[i][j], sites[i][j + 1]);
                        if (isFull(i + 1, j))
                            uf.union(sites[i][j], sites[i + 1][j]);
                    }

                }

            }
        }
        return false;
    }

    //
    public static void main(String[] args) {
        int n = 20, m = 50;
        Percolation perco = new Percolation(n);
        while (perco.numberOfOpenSites() < m) {
            int row = StdRandom.uniform(0, n);
            int col = StdRandom.uniform(0, n);
            if (!perco.isOpen(row, col))
                perco.open(row, col);
        }
        System.out.println("number of open sites " + perco.numberOfOpenSites());
        System.out.println("is Percolation " + perco.percolates());
    }

}
