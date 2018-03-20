package com.jakewoo.face.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    /**
     * 假定前边数组有序,将后边数据插入到有序数组中
     * <p>
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int preIdx = i - 1;
            //保存当前值,不然会被覆盖掉
            int current = arr[i];
            // 当前位置,比它前边的小. 换位置
            while (preIdx >= 0 && current < arr[preIdx]) {
                arr[preIdx+1] = arr[preIdx];
                preIdx --;
            }
            //跳出 while 循环的条件是 上一个位置,比 arr[i] 小,所以加1
            arr[preIdx+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,4,9,8,2,7,6};
        insertionSort(arr);
        System.out.println(arr);
    }
}
