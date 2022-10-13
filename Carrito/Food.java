package Carrito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    LocalDate expirationDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = LocalDate.parse(expirationDate,dtf);;
    }

    long daysBetween;

    public Food(){};
    public Food(float initPrice, String name, int barCode, String limitDate) {
        this.expirationDate = LocalDate.parse(limitDate,dtf);
        this.price = priceCalc(initPrice);
        this.name = name;
        this.barCode = barCode;
    }

    //@Override
    private float priceCalc(float initPrice) {
        daysBetween = ChronoUnit.DAYS.between(expirationDate, LocalDateTime.now());
        return (initPrice - initPrice*(1/(daysBetween+1)) + (initPrice * 0.1f));
    }

    /*public static void main(String[] args) {
        String inputString1 = "23 01 1997";

        LocalDate date1 = LocalDate.parse(inputString1, dtf);
        LocalDateTime date2 = LocalDateTime.now();
        long daysBetweSystem.out.println ("Days: " + daysBetween);
    }en = ChronoUnit.DAYS.between(date1, date2);*/

}
