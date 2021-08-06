package bishi;

public class TwoThread {
    private static int alt=0;
    public static void main(String[] args) {
        Runnable r=()->{
            for (int i = 0; i < 100; i++) {
                alt+=1;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(alt);
        };
        Thread thread1 = new Thread(r, "thread1");
        Thread thread2 = new Thread(r, "thread2");
        thread1.start();
        thread2.start();
    }
}
