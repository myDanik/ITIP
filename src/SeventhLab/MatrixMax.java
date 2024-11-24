package SeventhLab;

import java.util.concurrent.*;

public class MatrixMax {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] matrix = new int[10][10];
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int) (Math.random()*1000);
            }
        }
        int threadCount = 5;
        int partSize = matrix.length/threadCount;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Future<Integer>[] results = new Future[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? matrix.length : start + partSize;
            results[i] = executorService.submit(new MaxTask(matrix, start, end));
        }
        int max = 0;
        for (Future<Integer> result: results){
            max = Math.max(result.get(), max);
        }
        executorService.shutdown();
        System.out.println(max);

    }
    static class MaxTask implements Callable<Integer>{
        private final int[][] matrix;
        private final int start;
        private final int end;
        public MaxTask(int[][] matrix, int start,int end){
            this.matrix = matrix;
            this.start = start;
            this.end = end;
        }
        @Override
        public Integer call() throws Exception {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i< matrix.length; i++){
                for (int value: matrix[i]){
                    max = Math.max(value, max);
                }
            }
            return max;
        }
    }
}
