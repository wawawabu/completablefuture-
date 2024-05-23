package it.com.sort;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, 26, 188, 98};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0) {
                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                }else {
                    break;
                }
                j--;
            }
            arr[j+1] = temp;
        }

    }
}
