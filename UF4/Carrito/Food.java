package UF4.Carrito;

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

    //@Override
    private float priceCalc(float initPrice) {
        daysBetween = ChronoUnit.DAYS.between(expirationDate, LocalDateTime.now());
        return (initPrice - initPrice * (1 / (daysBetween + 1)) + (initPrice * 0.1f));
    }


    @Override
    public void setPrice(float price) {
        this.price = priceCalc(price);
    }
}
