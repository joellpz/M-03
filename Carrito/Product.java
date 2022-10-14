package Carrito;

public /*abstract*/ class Product {
    protected float price;
    protected String name;
    protected int barCode;


    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    //private abstract void setPrice();
}
