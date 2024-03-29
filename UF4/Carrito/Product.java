package UF4.Carrito;

import java.util.Objects;

public abstract class Product {
    protected float price;
    protected String name;
    protected int barCode;

    public int getBarCode() {
        return barCode;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public abstract void setPrice(float price);

    public void setName(String name) {
        this.name = name;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    /*
    * equals: Compara el preu i el codi de barres per determinar
    * si dos productes són iguals.
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && barCode == product.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, barCode);
    }
}
