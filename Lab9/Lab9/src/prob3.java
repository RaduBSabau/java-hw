
class Fibonacci {
    private int n;
    private int result;

    public Fibonacci(int n) {
        this.n = n;
    }

    public synchronized void calculate() {
        if (n <= 0) {
            result = 0;
            return;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Valoare temporara: " + temp);
        }

        result = b;
    }

    public synchronized void displayResult() {
        System.out.println("Fibonacci value for n = " + n + ": " + result);
    }
}

public class prob3 {
    public static void main(String[] args) {
        Fibonacci calculator = new Fibonacci(10);

        Thread calculationThread = new Thread(() -> calculator.calculate());
        Thread displayThread = new Thread(() -> calculator.displayResult());

        calculationThread.start();
        displayThread.start();

        try {
            calculationThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
