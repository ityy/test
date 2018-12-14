package cn.yang.lambda;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");
        Collections.sort(names, (a, b) -> a.length() - b.length());
//        Comparator<String> comparator = (first, second) -> first.length() - second.length();

        System.out.println(names);
    }

}
