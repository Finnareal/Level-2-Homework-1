package Lesson12;

public class SharedMemory {

    private static int value = 10;
    private static final Object MUTEX = new Object();

    public static void main(String[] args) {
        new Thread(new Increment()).start();
        new Thread(new Decrement()).start();
    }

    private static class Increment implements Runnable {

        @Override
        public void run() {
            while (value < 20){
                synchronized (MUTEX) {
                    System.out.println("inc: " + ++value);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Decrement implements Runnable {

        @Override
        public void run() {
            while (value > 0){
                synchronized (MUTEX) {
                    System.out.println("inc: " + --value);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
