package cn.yang.test.log;
/*
使用Logging框架写Log基本上就三个步骤
引入loggerg类和logger工厂类
声明logger
记录日志
 */

//1. 引入slf4j接口的Logger和LoggerFactory
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    //2. 声明一个Logger，这个是static的方式，我比较习惯这么写。
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean verifyLoginInfo(String userName, String password) {
        //3. log it，输出的log信息将会是："Start to verify User [Justfly]
        logger.info("Start to verify User [{}]", userName);
        return false;
    }

    public static void main(String[] args) {
        UserService userService=new UserService();
        userService.verifyLoginInfo("yang","123456");
    }
}