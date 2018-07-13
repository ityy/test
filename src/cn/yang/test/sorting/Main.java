package cn.yang.test.sorting;

public class Main {

    public static void main(String[] args) {

//        directInsertSort1(ArrayInfo.array);
//        ArrayInfo.resetArray();
//        directInsertSort2(ArrayInfo.array);
//        ArrayInfo.resetArray();
//        directSelectionSort1(ArrayInfo.array);
//        ArrayInfo.resetArray();
//        directSelectionSort2(ArrayInfo.array);
//        ArrayInfo.resetArray();
//        bubbleSort(ArrayInfo.array);
        ArrayInfo.resetArray();
        quickSort1(ArrayInfo.array, 0, 9);
//        ArrayInfo.resetArray();
//        quickSort2(ArrayInfo.array, 0, 9);

    }


    /**
     * 直接插入排序 方法1
     *
     * @param array
     */
    private static void directInsertSort1(int[] array) {
        System.out.println("----直接插入排序_方法1_开始----");
        System.out.println(ArrayInfo.arrayToString(array));
        //i为当前处理的元素 j为已排好的元素
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    //将i元素暂存到temp
                    int temp = array[i];
                    //将j之后(包含j) i之前的元素全部后移一位
                    System.arraycopy(array, j, array, j + 1, i - j);
                    //temp赋值给j
                    array[j] = temp;
                }
            }
        }
        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----直接插入排序_方法1_结束----");

    }

    /**
     * 直接插入排序 方法2
     *
     * @param a
     */
    public static void directInsertSort2(int[] a) {
        System.out.println("----直接插入排序_方法2_开始----");
        System.out.println(ArrayInfo.arrayToString(a));

        int len = a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for (int i = 1; i < len; i++) {//因为第一次不用，所以从1开始
            insertNum = a[i];
            int j = i - 1;//序列元素个数
            while (j >= 0 && a[j] > insertNum) {//从后往前循环，将大于insertNum的数向后移动
                a[j + 1] = a[j];//元素向后移动
                j--;
            }
            a[j + 1] = insertNum;//找到位置，插入当前元素
        }
        System.out.println(ArrayInfo.arrayToString(a));
        System.out.println("----直接插入排序_方法2_结束----");

    }


    /**
     * 直接选择排序 方法1
     *
     * @param array
     */
    public static void directSelectionSort1(int[] array) {
        System.out.println("----直接选择排序_方法1_开始----");
        System.out.println(ArrayInfo.arrayToString(array));

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                //只要第i个元素比第j个元素大  就将其交换 确保第i个元素比后面所有的元素都小
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----直接选择排序_方法1_结束----");

    }

    /**
     * 直接选择排序 方法2
     *
     * @param a
     */
    public static void directSelectionSort2(int[] a) {
        System.out.println("----直接选择排序_方法2_开始----");
        System.out.println(ArrayInfo.arrayToString(a));

        int len = a.length;
        for (int i = 0; i < len; i++) {//循环次数
            int value = a[i];
            int position = i;
            for (int j = i + 1; j < len; j++) {//找到最小的值和位置
                if (a[j] < value) {
                    value = a[j];
                    position = j;
                }
            }
            a[position] = a[i];//进行交换
            a[i] = value;
        }
        System.out.println(ArrayInfo.arrayToString(a));
        System.out.println("----直接选择排序_方法2_结束----");

    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        System.out.println("----冒泡排序_开始----");
        System.out.println(ArrayInfo.arrayToString(array));

        //i为 有几个元素就遍历几遍
        for (int i = 0; i < array.length; i++) {
            //j为 每遍历一次就冒泡上来一个最小的元素 遍历的范围就缩小1
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----冒泡排序_结束----");

    }


    public static void quickSort1(int[] array, int start, int end) {
        System.out.println("----快速排序_方法1_开始----");
        System.out.println(ArrayInfo.arrayToString(array));
        //递归返回条件 因为存在end击穿的情况 所以不能用==判断
        if (start > end) return;
        //选定第一个元素为基准
        int i = start, j = end;
        //标识基准元素目前的位置 在左面则j-- 在右面则i++
        boolean atLeft = true;
        //完全按照快排的规则写的
        while (i < j) {
            //满足条件则交换元素 并交替左右位置
            if (array[i] > array[j]) {
                swap(array, i, j);
                atLeft = !atLeft;
            }
            //根据位置来改变变量
            if (atLeft) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("排好序的元素位置:" + i);
        quickSort1(array, start, i - 1);
        quickSort1(array, i + 1, end);
        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----快速排序_方法1_结束----");
    }

    public static void quickSort2(int[] array, int start, int end) {
        System.out.println("----快速排序_方法2_开始----");
        System.out.println(ArrayInfo.arrayToString(array));

        if (start == end)
            return;
        int i = start + 1;
        int j = end;
        while (i < j) {
            for (; array[i] < array[start] && i < j; i++) ;
            for (; array[j] > array[start] && j > i; j--) ;
            swap(array, i, j);
        }
        if (array[i] < array[start])
            swap(array, i, start);
        quickSort2(array, start, i - 1);
        quickSort2(array, i, end);
        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----快速排序_方法2_结束----");

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
