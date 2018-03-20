package com.jakewoo.face.search;

/**
 * 广度搜索
 * 判断两点之间最短距离
 */
public class BreadthSearch {
    /*
        获取两个点之间的路径,并求出最短路径是哪个
        思路:
            通过遍历循环,找到所有的路径,并标记步数
            最后以步数排序
     */

    static class Step{
        public static int count = 0;
        int lat;
        int lon;
        Step next;
    }

    int[][] map = initMap(8,8);

    Step minStep = getMinStep(map,8,8);

    Step getMinStep(int[][] map,int lat,int lon) {

        //lat lon 要在 地图范围内
        while(map.length > lat && map[0].length > lon){

        }

        return null;
    }

    int[][] initMap(int width,int hight){
        int[][] result = new int[width][hight];
        return result;
    }

}
