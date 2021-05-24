package com.gityang.basetest.throwable.exception;

/**
 * 自定义异常
 */
//1 第一步 继承Exception类
public class NoMoneyException extends Exception {

    //2 第二步 两个构造方法 一个有参  一个无参
    public NoMoneyException() {
        super();
    }
    public NoMoneyException(String message) {
        super(message);
    }
}
