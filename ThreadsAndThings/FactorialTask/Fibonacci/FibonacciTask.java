package ThreadsAndThings.FactorialTask.Fibonacci;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private final int n;
    private static final int LLINDAR = 5;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public Long fibonacciR() {
        FibonacciTask ft = new FibonacciTask(n-1);
        ft.fork();
        return ft.join() * n;
    }

    public Long fibonacciS() {
        long prev1=0, prev2=1;
        for(int i=0; i<n; i++) {
            long savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    @Override
    protected Long compute() {
        if(n > LLINDAR) {
            return fibonacciR();
        }else return fibonacciS();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask ft = new FibonacciTask(14);
        pool.invoke(ft);
        Long result2 = ft.join();
        System.out.println(result2);
    }
}
