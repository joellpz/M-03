package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("--------------------- T I C K E T ---------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("*************** " + dtf.format(LocalDateTime.now()) + " - JoelMarket" + " ***************");
        List<Product> sortedCart = getBarCodeDupes(shoppingCart);
        for (Product p :) {
            System.out.println("- " + p.getName() + " - " + products.get(p) +
                    "u - " + p.getPrice() + "€ - Total:" +
                    (p.getPrice() * products.get(p)) + "€ - ");
        }
    }


    public List<Product> getBarCodeDupes(List<Product> cart) {
        List<Product> sortedCart = cart;
        Collections.sort(
                sortedCart,
                new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        if (p1.getBarCode() < p2.getBarCode()) return -1;
                        else if (p1.getBarCode() > p2.getBarCode()) return 1;
                        else return 0;
                    }
                }
        );


        return sortedCart;
    }
}
