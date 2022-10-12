package Carrito;

public class Electronics extends Product {
    public Electronics(int price, int barCode, int name, int warrantyDays) {
        this.price = (int) (price + price*(warrantyDays/365)*0.1);
        this.barCode = barCode;
        this.name = name;
    }
}
