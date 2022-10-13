package Carrito;

public class Textile extends Product {
    String composition;
    public void setComposition(String composition) {
        this.composition = composition;
    }
    public Textile(){};
    public Textile(int price, int barCode, String name, String copmposition) {
        this.price = price;
        this.barCode = barCode;
        this.name = name;
        this.composition = copmposition;
    }


}
