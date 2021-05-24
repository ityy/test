package cn.yang.basetest.type;

import java.io.UnsupportedEncodingException;

/**
 * @author yangyang
 * @date 2019-12-24
 */
public class StringTest {

    //16进制字符
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    /**
     * 字节数组与字符串互相转换
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //字符串 编码为指定格式的字节数组:
            byte[] zhong_default = "中".getBytes(); //3字节 默认的编码，以ide设置为准，一般为UTF-8
            byte[] zhong_gbk = "中".getBytes("GBK"); //2字节
            byte[] zhong_utf8 = "中".getBytes("UTF-8"); //3字节
            byte[] zhong_iso88591 = "中".getBytes("ISO8859-1"); //1字节 信息受损。此编码表中没有此字符的对应编码, 无法完成编码。这种情况都是3f。

            //以十六进制打印字节:
            System.out.println("默认编码:\t\t\t" + bytesToHex(zhong_default)); //	E4B8AD
            System.out.println("gbk编码:\t\t\t" + bytesToHex(zhong_gbk)); //	D6D0
            System.out.println("utf8编码:\t\t" + bytesToHex(zhong_utf8)); // E4B8AD
            System.out.println("iso88591编码:\t" + bytesToHex(zhong_iso88591)); // 3F

            System.out.println();

            //字节数组 解码为字符串 并打印
            System.out.println("默认解码:\t\t\t" + new String(zhong_default)); //中
            System.out.println("gbk解码:\t\t\t" + new String(zhong_gbk, "GBK")); //中
            System.out.println("utf8解码:\t\t" + new String(zhong_utf8, "UTF-8")); //中
            System.out.println("iso88591解码:\t" + new String(zhong_iso88591, "ISO8859-1")); //? 信息受损，无法还原

            System.out.println();

            //利用其它编码中转的方式, 使ISO8859-1可以传输中文
            System.out.println("将字符按UTF-8编码获取字节数组，再按ISO8859-1解码获取字符。会获得若干个ISO8859-1字符。避免了信息受损。");
            String s_iso88591 = new String("中".getBytes("UTF-8"), "ISO8859-1");
            System.out.println(s_iso88591);//3个符号 对应3个字节。在支持ISO8859-1的网络中可以传递这些字符，相当于把3个字节传递过去了。
            System.out.println("将字符按ISO8859-1编码获取字节数组，再按UTF-8解码获取字符。");
            String s_utf8 = new String(s_iso88591.getBytes("ISO8859-1"), "utf-8");
            System.out.println(s_utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 字节可视化
     * 字节数组 转 16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制符号展示
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for (byte b : bytes) { // 使用除与取余进行转换
            if (b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }

        return new String(buf);
    }

}




