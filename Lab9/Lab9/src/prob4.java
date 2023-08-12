
class Numarator {
    private int nr;

    public synchronized void increment() {
        nr++;
    }

    public synchronized void decrement() {
        nr--;
    }

    public int getCount() {
        return nr;
    }
}

public class prob4 {
    public static void main(String[] args) {
        Numarator numarator = new Numarator();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 100000; i++) {
                numarator.increment();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 100000; i++) {
                 numarator.decrement();
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(decrementTask);
        Thread thread3 = new Thread(incrementTask);

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

        System.out.println("Numaratoare finala : " + numarator.getCount());
    }
}
