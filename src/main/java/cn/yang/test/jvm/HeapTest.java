package cn.yang.test.jvm;

//1. 引入slf4j接口的Logger和LoggerFactory

import cn.yang.test.sorting.SortUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆测试
 */
public class HeapTest {
    //2. 声明一个Logger，这个是static的方式，我比较习惯这么写。
    private final static Logger logger = LoggerFactory.getLogger(HeapTest.class);

    @Test
    public void demo() {
        try {

            //定义大小为10mb
            int max = 1024 * 1024 * 10;
            List<byte[]> bytes = new ArrayList<>();
            //请用debug 单步执行 并在jvisualvm中查看堆内存的情况, 因为必报OutOfMemoryError
            while (true) {
                bytes.add(new byte[max]);

            }
        } catch (OutOfMemoryError error) {
            //使用try catch配合日志 将error捕获并写出日志 再打印error的stack信息
            logger.error("OutOfMemoryError", error);
        }
    }

    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        heapTest.demo();
    }
}
