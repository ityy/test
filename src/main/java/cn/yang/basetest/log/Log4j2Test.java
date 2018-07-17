package cn.yang.basetest.log;

/*
需要使用log4j2.xml来配置log4j2, 详细配置方法见log4j2.xml
使用Logging框架写Log基本上就三个步骤
引入loggerg类和logger工厂类
声明logger
记录日志
 */

//1. 引入slf4j接口的Logger和LoggerFactory
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {

    //2. 声明一个Logger，这个是static的方式，我比较习惯这么写。
    private final static Logger logger = LoggerFactory.getLogger(Log4j2Test.class);


    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();

        for(int i = 0; i < 100000; i++) {
            //3. log it
            logger.trace("trace level");
            logger.debug("debug level");
            logger.info("info level");
            logger.warn("warn level");
            logger.error("error level");
        }

        try {
            Thread.sleep(1000 * 61);
        } catch (InterruptedException e) {}


        logger.info("请求处理结束，耗时：{}毫秒", (System.currentTimeMillis() - beginTime));    //第一种用法 参数化信息的方法
        logger.info("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime)  + "毫秒");    //第二种用法 拼接字符串

    }
}