package com.jakewoo.face.search;

/**
 * 二分查找法
 */
public class BinarySearch {

    /**
     * 对升序排列数组进行二分查找
     * @param source
     * @param sData
     * @return
     * @throws Exception
     */
    public static int binarySearch(int[] source, int sData) throws Exception {

        //错误数据过滤
        if (source == null || source.length == 0) {
            return -1;
        }

        // 只有一个的数组
        if (source.length == 1) {
            return source[0] == sData ? 0 : -1;
        }


        int sIdx, eIdx, mIdx;
        sIdx = 0;
        eIdx = source.length - 1;

        // 跳出条件：start index > end index
        // 标示已经循环完一遍。要查找的数据不存在
        while (sIdx <= eIdx) {

            // 通过修改 start index 和 end index 所在位置，确定mind index 的大小
            mIdx = (sIdx+eIdx)/2;
            System.out.println("sIdx:"+sIdx+" ,mIdx:"+mIdx+" ,eIdx:"+eIdx);
            if (source[mIdx] == sData) {
                return mIdx;
            }
            if (source[mIdx] > sData) {
                // 减1 的目的是排除当前判断的点，
                // 如果当前值大于要查询的值，表示要查找的值在当前值得前边。
                // 所以end index 应该是当前值前边那个值
                eIdx = mIdx-1;
            }else {
                // 原理同上
                sIdx = mIdx+1;
            }
        }

        //没有找到
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int search = 1;
        try {
            int result = BinarySearch.binarySearch(arr,search);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
