package cn.yang.basetest.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyang
 * @date 2019-12-24
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("city", "北京");
        map.put("mail", "100021");
        map.put("name", "小明");
        System.out.println(map);
    }

}
