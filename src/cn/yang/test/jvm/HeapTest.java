package cn.yang.test.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆测试
 */
public class HeapTest {


    @Test
    public void demo() {
        //定义大小为10mb
        int max = 1024 * 1024 * 10;
        List<byte[]> bytes = new ArrayList<>();
        //请用debug 单步执行 并在jvisualvm中查看堆内存的情况
        //因为必报OutOfMemoryError
        while (true) {
            bytes.add(new byte[max]);

        }
    }
}
