package Carrito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    LocalDate expirationDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = LocalDate.parse(expirationDate, dtf);
    }

    float daysBetween;

    public Food() {
    }

    /*public Food(float initPrice, String name, int barCode, String limitDate) {
        this.expirationDate = LocalDate.parse(limitDate, dtf);
        this.price = priceCalc(initPrice);
        this.name = name;
        this.barCode = barCode;
    }*/

    @Override
    public void setPrice(float price) {
        daysBetween = ChronoUnit.DAYS.between(expirationDate, LocalDateTime.now());
        this.price = (price - price * (1 / (daysBetween + 1)) + (price * 0.1f));

    }
}
