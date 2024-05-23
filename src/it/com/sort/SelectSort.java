package it.com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SelectSort {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        Iterator<Object> iterator = objects.iterator();

        int[] i = {0, -1, 2, 26, 188, 98};
        selectSort(i);
        System.out.println(Arrays.toString(i));

    }

    public static void selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (min > arr[j]) {
                    index = j;
                    min = arr[j];
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;

            }


        }

    }
}
