
import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    private String name;
    private static int instanceCount = 0;

    public MyRunnable(String name) {
        this.name = name;
        instanceCount++;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < instanceCount; i++) {
            System.out.println(name);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class prob1 {
    public static void main(String[] args) {
        MyRunnable obj1 = new MyRunnable("1");
        MyRunnable obj2 = new MyRunnable("2");
        MyRunnable obj3 = new MyRunnable("3");

        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);
        Thread thread3 = new Thread(obj3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Obiecte create: " + MyRunnable.getInstanceCount());
    }
}