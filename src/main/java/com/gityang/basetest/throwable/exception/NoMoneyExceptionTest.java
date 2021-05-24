package com.gityang.basetest.throwable.exception;

/**
 * 测试自定义异常
 */
public class NoMoneyExceptionTest {
    //这里不捕获异常, 将其抛给虚拟机直接中断程序
    public static void main(String[] args) throws NoMoneyException{

        NoMoneyExceptionTest noMoneyExceptionTest = new NoMoneyExceptionTest();
        //支付999 钱不够
        noMoneyExceptionTest.payMoney(999);
    }

    //抛出方法体内部产生的异常,多个用逗号隔开
    public void payMoney(int money) throws NoMoneyException{
        if (money < 1000) {
            //new一个异常类 然后抛出
            throw new NoMoneyException("钱不够1000, 支付失败!");
        } else {
            System.out.println("支付成功, 金额1000元!");

        }
    }
}
