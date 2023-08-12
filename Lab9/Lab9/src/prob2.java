
import java.util.Random;
import java.util.concurrent.TimeUnit;

class RandomNumberGenerator implements Runnable {
    private Random random;
    private Thread calculationThread;

    public RandomNumberGenerator() {
        random = new Random();
        calculationThread = new Thread(new CircleAreaCalculator());
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            int raza = random.nextInt(31);
            System.out.println("Raza generata: " + raza);

            if (raza % 3 == 0) {
                calculationThread = new Thread(new CircleAreaCalculator(raza));
                calculationThread.start();
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CircleAreaCalculator implements Runnable {
    private int raza;

    public CircleAreaCalculator() {
        this.raza = 0;
    }

    public CircleAreaCalculator(int raza) {
        this.raza = raza;
    }

    @Override
    public void run() {
        double area = Math.PI * raza * raza;
        System.out.println("Circle area for radius " + raza + ": " + area);
    }
}

public class prob2 {
    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Thread generatorThread = new Thread(generator);
        generatorThread.start();

        try {
            generatorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
