package it.com.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] i = {2, 6, 88, 98, 102, 200,201};
        int i1 = binarySearch(i, 98);
        System.out.println(i1);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //System.out.println(m);
        while (start <= end) {
            int m = (start + end) >>> 1;

            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                end = m - 1;

            } else {
                start = m + 1;

            }

        }
        return -1;
    }
}
