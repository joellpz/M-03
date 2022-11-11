package ThreadsAndThings.FactorialTask.Fibonacci;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask {
    private int n;
    private static final int LLINDAR = 5;

    public FibonacciTask(int n) {
        this.n = n;
    }

    private int fibonacciR() {
        FibonacciTask fibonacciTask = new FibonacciTask(20);
        fibonacciTask.fork();
        return fibonacciTask.join()
    }

    private int fibonacciS() {
        int num1 = 1, num2 = 0;
        for (int i = 1; i < n; i++) {
            if (i >= 2) num2 = num1;
            num1 =  num2 + num1;
        }
        return num1;
    }

    @Override
    protected int compute() {
        if(){
            return fibonacciR();
        }else return fibonacciS();
    }
}
