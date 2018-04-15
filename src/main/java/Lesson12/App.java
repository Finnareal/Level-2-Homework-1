package Lesson12;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread increment = new Thread(new Increment());
        increment.setDaemon(true);
        increment.start();

        Thread thread = new MyFirstThread();
        thread.setDaemon(true);
        thread.start();

        System.out.println(thread.isDaemon());

        Thread.sleep(2000);
        System.out.println("Hello main!");
        System.out.println("Hello main!");
        System.out.println("Hello main!");
        System.out.println("Hello main!");
    }

    private static class MyFirstThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                System.out.println("Hello thread!");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Increment implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i >= 0){
                System.out.println(i++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
