package demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: heyong
 * @Date: 2019-11-25 16:52
 * @Description:
 */
public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}

