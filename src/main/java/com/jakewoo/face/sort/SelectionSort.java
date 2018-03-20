package com.jakewoo.face.sort;

/**
 * 选择排序
 *
 */
public class SelectionSort {

    /**
     * 选择排序
     * 将当前元素挨个和其它所有元素对比 然后交换,继续对比
     * T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {

                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,4,2,1,6,9,3,8};

        long start = System.currentTimeMillis();
        selectionSort(arr);

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(arr);

    }
}
