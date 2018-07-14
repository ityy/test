package cn.yang.test.sorting;

/**
 * 排序算法集合
 */
public class SortUtils {
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

    /**
     * 快速排序 方法1 适合基准点取最左或取最右的情形
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort1(int[] array, int start, int end) {
        System.out.println("----快速排序_方法1_开始----");
        System.out.println(ArrayInfo.arrayToString(array));
        //递归返回条件 因为存在end击穿的情况 所以不能用==判断
        if (start >= end) return;
        int i = start, j = end;
        //atLeft初始状态用来指定基准点为start还是end true为start false为end 标识基准点在交换过程中的位置 在左面则j-- 在右面则i++
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

    /**
     * 快速排序 方法2  高效的快速排序 交换次数更少 基准点可取任意位置
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort2(int[] array, int start, int end) {
        System.out.println("----快速排序_方法2_开始----");
        System.out.println(ArrayInfo.arrayToString(array));
        //击穿返回
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        //定义基准点
        int p = start;

        while (i < j) {
            /*
                注意下面两个while中的判断必须带=号,这样可以略过基准点
                如果不带等号,相当于递归实现了选择排序,每次递归都排好最左边的那个元素,这一点由打印结果可知
                也正好对比了快排和选择排序的速度,快排打印的行数比选择排序要少,即选择排序的次数跟元素个数一样,快排则省略了不确定的次数
            */
            //在i和j交汇前 找到比p小的为止
            while (array[j] >= array[p] && i < j) {
                j--;
            }
            //在i和j交汇前 找到比p大的为止
            while (array[i] <= array[p] && i < j) {
                i++;
            }
            //直接交换这两个数 省去了基准点挪来挪去的步骤
            if (i < j) {
                swap(array, i, j);
            }
        }
        System.out.println("排好序的元素位置:" + i);
        //当i和j交汇时 不管i在p的左边还是右边 i就是基准点最终的位置 直接将其交换
        //如果i==p表示p的位置一开始就是对的 无需交换
        if (i != p) {
            swap(array, i, p);
        }
        quickSort2(array, start, i - 1);
        quickSort2(array, i + 1, end);
        System.out.println(ArrayInfo.arrayToString(array));
        System.out.println("----快速排序_方法2_结束----");
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
