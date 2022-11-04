package ThreadsAndThings.JocScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Joc {
    public static void main(String[] args) {
        int numJugadors = 2;
        Map<Jugador, MonitorJugador> jugadorsList = new HashMap<>();
        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        for (int i = 1; i <= numJugadors; i++) {
            Jugador j = new Jugador("Jugador"+i);
            jugadorsList.put(j, new MonitorJugador(j));
        }

        jugadorsList.forEach((j,m) -> {
            schExService.scheduleWithFixedDelay(j,(long) (Math.random() * 5), (long) (Math.random()*5), TimeUnit.SECONDS);
            schExService.scheduleWithFixedDelay(m,(long) (Math.random() * 5),(long) (Math.random() * 5),TimeUnit.SECONDS);
        });

        try {
            schExService.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schExService.shutdownNow();

        jugadorsList.values().stream().sorted().forEach(System.out::println);


    }
}
