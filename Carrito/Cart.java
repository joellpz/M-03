package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cart {
    private List<Product> shoppingCart = new ArrayList<>();
    private Map<Product, Integer> noDupeBarCodeCart;

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
        getBarCodeDupes(shoppingCart);
        for (Product p : noDupeBarCodeCart.keySet()) {
            System.out.println("- " + p.getBarCode() + " - " + noDupeBarCodeCart.get(p) +
                    "u");
        }
    }


    private Map<Product, Integer> getBarCodeDupes(List<Product> cart) {
        List<Product> sortedCart = cart;
        Integer count = 0;
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

        for (int i = 0; i < sortedCart.size() - 1; i++) {
            if (sortedCart.get(i).getBarCode() == sortedCart.get(i + 1).getBarCode()) {
                ++count;
            }else{
                noDupeBarCodeCart.put(sortedCart.get(i),count);
                count = 0;
            }
        }

        return noDupeBarCodeCart;
    }
}
