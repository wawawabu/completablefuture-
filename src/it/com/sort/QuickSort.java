package it.com.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class QuickSort {

    public static void main(String[] args) {
        Class<QuickSort> quickSortClass = QuickSort.class;

        //new CopyOnWriteArrayList<>()
        //Thread
        int i = 23457;
        double d = i/100.0;
        System.out.println(d);
        HashMap<Integer, Integer> hashMap = new HashMap<>(8);
        hashMap.put(1,2);
        hashMap.put(2,2);


        //hashMap.put()
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        int[] arr = {5, 3, 7, 2, 9, 8, 1, 4};
        int[] ints = Arrays.copyOf(arr, 9);
        System.arraycopy(arr,0,ints,1,7);
        System.out.println(Arrays.toString(ints));*/
        //System.out.println(partition(arr, 0, arr.length - 1));
        /*quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/

    }


    /**
     * lomuto洛穆托单边循环快排
     */
    public static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int partition = partition2(arr, l, h);
        quickSort(arr, l, partition - 1);//左分区
        quickSort(arr, partition + 1, h);//右分区
    }

    /**
     * 双边循环快排
     *
     * @param arr
     * @param l
     * @param h
     * @return
     */
    public static int partition2(int[] arr, int l, int h) {
        int i = l;
        int j = h;
        int pv = arr[i]; //基准点pv初始最左侧
        while (i < j) {
            while ((i < j) && (arr[j] > pv)) {
                j--;
            }
            while ((i < j) && (arr[i] <= pv)) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[l] = arr[i];
        arr[i] = pv;
        return i;

    }

    /**
     * lomuto洛穆托单边循环快排
     */
    public static int partition(int[] arr, int l, int h) {
        int pv = arr[h];
        int j = l;
        for (int i = l; i < h; i++) {
            int temp = arr[i];
            //int j = i;
            if ((arr[i] < pv)) {
                if ((i != j)) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        arr[h] = arr[j];
        arr[j] = pv;
        return j;


    }
}
