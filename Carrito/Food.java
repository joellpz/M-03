package Carrito;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Food extends Product {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = LocalDateTime.parse();
        System.out.println(now);
        long daysBetween = ChronoUnit.DAYS.between(now, expiration);

        System.out.println(daysBetween);
    }
}
