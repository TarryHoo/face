package com.jakewoo.face.sort;

/**
 * 冒泡排序
 */
public class BubboSort {

    /**
     * 冒泡排序
     *
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * @param arr
     */
    public static void bubboSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1 ; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,8,5,3,4,6,2,1,9};
        bubboSort(arr);
        System.out.println(arr);
    }
}
