package Carrito;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Electronics extends Product {
    int warrantyDays;

    public void setWarrantyDays(int warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    public Electronics(){};
    public Electronics(int initPrice, int barCode, String name, int warrantyDays) {
        this.warrantyDays = warrantyDays;
        this.price = priceCalc(initPrice);
        this.barCode = barCode;
        this.name = name;
    }

    private float priceCalc(float initPrice) {
        return (initPrice + initPrice*(warrantyDays/365)*0.1f);
    }

    private void setPrice() {
        this.price = (int) (price + price*(warrantyDays/365)*0.1);
    }
}
