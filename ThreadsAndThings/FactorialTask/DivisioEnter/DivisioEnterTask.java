package ThreadsAndThings.FactorialTask.DivisioEnter;

import ThreadsAndThings.FactorialTask.Fibonacci.FibonacciTask;
import com.sun.jdi.Value;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DivisioEnterTask extends RecursiveTask<Long> {

    public int x;
    public final int y;
    private static int LLINDAR = 10;

    public DivisioEnterTask(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Long divisioS() {
        int cont = 0;
        while(x > y){
            cont++;
            x -= y;
        }
        return Long.valueOf(cont);
    }

    public Long divisioR(){
        DivisioEnterTask det = new DivisioEnterTask(x/y,y);
        det.fork();
        return det.join()+1;
    }

    @Override
    protected Long compute() {
        if(x > LLINDAR) {
            return divisioR();
        }else return divisioS();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        DivisioEnterTask def = new DivisioEnterTask(100,5);
        pool.invoke(def);
        Long result2 = def.join();
        System.out.println(result2);
    }
}
