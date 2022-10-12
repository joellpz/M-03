package Carrito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    LocalDate expirationDate;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Food(int price, int name, int barCode, String limitDate) {
        this.expirationDate = LocalDate.parse(limitDate,dtf);
        long daysBetween = ChronoUnit.DAYS.between(expirationDate, LocalDateTime.now());
        this.price = (int) (price - price*(1/(daysBetween+1)) + (price * 0.1));
        this.name = name;
        this.barCode = barCode;
    }

    /*public static void main(String[] args) {
        String inputString1 = "23 01 1997";

        LocalDate date1 = LocalDate.parse(inputString1, dtf);
        LocalDateTime date2 = LocalDateTime.now();
        long daysBetweSystem.out.println ("Days: " + daysBetween);
    }en = ChronoUnit.DAYS.between(date1, date2);*/

}
