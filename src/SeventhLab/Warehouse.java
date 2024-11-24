package SeventhLab;
import java.util.concurrent.Semaphore;
public class Warehouse {
    static int MAX_WEIGHT = 150;

    public static void main(String[] args) {
        int[] weights = new int[100];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = (int) (Math.random()*100)+1;
        }
        Semaphore semaphore = new Semaphore(3);
        new Thread(new Worker(weights, semaphore)).start();
        new Thread(new Worker(weights, semaphore)).start();
        new Thread(new Worker(weights, semaphore)).start();
    }
}
class Worker implements Runnable{
    private static int currentIndex = 0;
    private final int[] weights;
    private final Semaphore semaphore;

    public Worker(int[] weights, Semaphore semaphore) {
        this.weights = weights;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        while (currentIndex < weights.length){
            try {
                semaphore.acquire();
                int totalWeight = 0;
                synchronized (Worker.class){
                    while (currentIndex < weights.length && totalWeight + weights[currentIndex] <= Warehouse.MAX_WEIGHT) {
                        totalWeight += weights[currentIndex];
                        System.out.println(Thread.currentThread().getName() + " взял товар весом " + weights[currentIndex]);
                        currentIndex++;
                    }
                }
                System.out.println("Следующий:");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }
    }
}