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

public class BitonicArray {

    int[] nums;

    BitonicArray() {
        nums = new int[] { 1, 3, 5, 6, 7, 4, 2 };
    }

    boolean hasInteger(int k) {
        int len = nums.length;
        int max = findMaxIndex(nums);
        if (k == nums[max])
            return true;
        return binarySearch(nums, 0, max, k) || binarySearch(nums, max + 1, len - 1, k);
    }

    int findMaxIndex(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            else if (arr[mid] < arr[mid + 1])
                lo = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                hi = mid - 1;
        }
        return -1;
    }

    boolean binarySearch(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid])
                hi = mid - 1;
            else if (key > arr[mid])
                lo = mid + 1;
            else if (key == arr[mid])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BitonicArray bit = new BitonicArray();
        System.out.println("found " + bit.hasInteger(6));
    }
}
