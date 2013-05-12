package other;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTest implements Runnable {

    private static class MyThread extends Thread {
        private MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread() + " finished.");
        }
    }

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
            lock.wait();
            System.out.println(Thread.currentThread());

            Thread thread = new Thread(new ThreadTest(), "my1");
            thread.start();
            Thread thread2 = new MyThread("my2");
            thread2.start();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + " finished.");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread() + " finished.");
    }

    private static class Clazz1 {
        private Object lock = new Object();
        private Object lock2 = new Object();

        private void m1() throws InterruptedException {
            synchronized (lock) {
                lock.wait(500);
            }
        }
        private void m2() {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }
}
