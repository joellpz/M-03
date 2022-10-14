package Carrito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private List<Product> shoppingCart = new ArrayList<>();

    public void addToCart(Product p) {
        shoppingCart.add(p);
        System.out.println("--- Producte \"" + p.name + "\" ha estat introduit al CARRO. ---");
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void showCart() {

    }
}
