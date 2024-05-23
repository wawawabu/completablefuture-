package it.com.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4,1,2,3};
        bubbleSearch(arr);
        //System.out.println(args[0]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSearch(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            //System.out.println(i);
            for (int j = 0; j < length - i; j++) {
                //System.out.println("j:" + j);
                int temp = arr[j];
                if (arr[j] >= arr[j + 1]) {

                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    temp = arr[j];
                    //System.out.println("j+1"+arr[j+1]);
                } else {
                    temp = arr[j + 1];
                }
            }

        }
/*        for (int i = 0; i < arr.length; i++) {
            System.out.println(args[i]);
        }*/


    }


    /**
     * 通过记录最后一次交换索引位置来减少循环次数
     * @param arr
     */
    public static void bubbleSearch2(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            boolean flag = false;
            //System.out.println(i);
            for (int j = 0; j < length - i; j++) {
                //System.out.println("j:" + j);
                int temp = arr[j];
                if (arr[j] > arr[j + 1]) {
                    //System.out.println("-----------");
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag =true;
                    //System.out.println("j+1"+arr[j+1]);
                }
            }
            System.out.println("-----");
            if (!flag){
                System.out.println("没有发送元素改变，不需要再进行排序");
                break;
            }

        }
/*        for (int i = 0; i < arr.length; i++) {
            System.out.println(args[i]);
        }*/


    }
}
