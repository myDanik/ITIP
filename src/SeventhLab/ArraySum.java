package SeventhLab;

import java.util.concurrent.*;

public class ArraySum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }


        int threadCount = 5;
        int partSize = array.length / threadCount;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        Future<Integer>[] results = new Future[threadCount];
        for (int i = 0; i < threadCount; i++){
            int start = i * partSize;
            int end = start + partSize;
            results[i] = executorService.submit(new SumTask(array, start, end));
        }
        int totalSum = 0;
        for (Future<Integer> result: results){
            totalSum = totalSum+result.get();

        }
        executorService.shutdown();
        System.out.println(totalSum);
    }
}
class SumTask implements Callable<Integer> {
    private int[] array;
    private int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
