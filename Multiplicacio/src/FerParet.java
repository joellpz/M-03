import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FerParet {
    public static final int numMaons = 5;
    public static final int numPaletas = 10;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Paleta> llistaPaletas = new ArrayList<Paleta>();
        long temp1 = System.currentTimeMillis(); //agafem els milisegons de la data

        for (int i = 0; i < numPaletas; i++) {
            Paleta p = new Paleta("paleta"+i, numMaons);
            llistaPaletas.add(p);
            executor.execute(p);
        }
        executor.shutdown();
        long temp2 = System.currentTimeMillis(); //agafem els milisegons de la data
        executor.awaitTermination(10000,"");
        System.out.println("Han trigat: " + (temp1 - temp2)/1000 + " segons");
    }
}
