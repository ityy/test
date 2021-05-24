package com.gityang.basetest.sorting;

/**
 * 自定义数组信息及展示方法
 */
public class ArrayInfo {

    public static int[] array = {3, 2, 5, 4, 6, 1, 7, 9, 8, 0};


    /**
     * 将int型数组转为字符串形式
     * @param array
     * @return
     */
    public static String arrayToString(int[] array) {
        StringBuilder s = new StringBuilder("{ ");

        for (int i : array) {
            s.append(i + ", ");
        }
        int index = s.lastIndexOf(",");
        s.delete(index, index + 1);
        s.append("}");
        return s.toString();
    }


    /**
     * 重置数组到乱序状态
     */
    public static void resetArray() {
        array=new int[] {3, 2, 5, 4, 6, 1, 7, 9, 8, 0};
    }

}
