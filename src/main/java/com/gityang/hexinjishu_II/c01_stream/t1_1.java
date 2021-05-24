package com.gityang.hexinjishu_II.c01_stream;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class t1_1 {

    public static void main(String[] args) {

        String collect = Stream
                //使用给定方法生成流
                .generate(Math::random)
                //复制一个流，每个元素交给action处理。适用于debug，打印等
                .peek(System.out::println).limit(20)
                //列处理模式
                .map(Objects::toString)
                //消费器：收集 以上的处理都是对流的包装和增强 只有消费器才会触发流的迭代进行消费
                .collect(
                        //收集成字符串 并按，号间隔
                        Collectors.joining(",")
                );
        System.out.println(collect);
    }

}
