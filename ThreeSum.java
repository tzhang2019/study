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

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    int[] nums;
    List<String> list;

    ThreeSum() {
        nums = new int[] { 2, -3, 4, 5, -1, -2, 7, 8, -4, -6, 3 };
        list = new ArrayList<>();
    }

    void insertionSort() {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int k = i - 1;
            while (k >= 0 && nums[k] > key) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k + 1] = key;
        }
    }

    void findSum() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                if (key + binarySearch(nums, key) == 0)
                    list.add(nums[i] + "," + nums[j]);
            }
        }
    }

    int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            }
            else if (key > arr[mid]) {
                lo = mid + 1;
            }
            else return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();

        sum.findSum();
        for (String str : sum.list)
            System.out.println("Pairs are " + str);
    }
}
