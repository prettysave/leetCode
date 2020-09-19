package demo;

import java.util.concurrent.Callable;

/**
 * @author: heyong
 */
public class CallableDemo {

    public void test(Callable callable) {
        try {
            System.out.println("开始调用");
            Object result = callable.call();
            System.out.println("结束调用,result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CallableDemo instance = new CallableDemo();
        instance.test(()->{
            System.out.println("call方法进入");
            Thread.sleep(3000);
            System.out.println("线程停顿之后");
            return null;
        });
    }
}
