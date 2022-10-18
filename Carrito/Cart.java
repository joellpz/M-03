package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cart {
    private final List<Product> shoppingCart = new ArrayList<>();
    private final Map<Product, Integer> noDupeBarCodeCart = new HashMap<>();

    public void addToCart(Product p) {
        shoppingCart.add(p);
        System.out.println("--- Producte \"" + p.name + "\" ha estat introduit al CARRO. ---");
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void showCart() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("-------------------- T H E  C A R T -------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("*************** " + dtf.format(LocalDateTime.now()) + " - JoelMarket" + " ***************");
        getBarCodeDupes(shoppingCart);
        for (Product p : noDupeBarCodeCart.keySet()) {
            System.out.println("- " + p.getBarCode() + " - " + p.getName() + " - " + noDupeBarCodeCart.get(p) +
                    "u");
        }
        System.out.println();
        noDupeBarCodeCart.clear();
    }


    private void getBarCodeDupes(List<Product> cart) {
        Integer count = 0;
        cart.sort(Comparator.comparingInt(Product::getBarCode));

        /* Without IntelliJ Corrections.
        Collections.sort(
                cart,
                new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        if (p1.getBarCode() < p2.getBarCode()) return -1;
                        else if (p1.getBarCode() > p2.getBarCode()) return 1;
                        else return 0;
                    }
                }
        );
        */
        for (int i = 0; i < cart.size() - 1; i++) {
            if (cart.get(i).getBarCode() != cart.get(i + 1).getBarCode()) {
                ++count;
                noDupeBarCodeCart.put(cart.get(i), count);
                count = 0;
            } else {
                ++count;
                if (i == cart.size() - 2) {
                    ++count;
                    noDupeBarCodeCart.put(cart.get(i), count);
                }
            }

            /*if (sortedCart.get(i).getBarCode() == sortedCart.get(i + 1).getBarCode()) {
                System.out.println(sortedCart.get(i).getBarCode());
                ++count;
            } else {
                System.out.println(sortedCart.get(i).getBarCode());
                ++count;
                System.out.println("PONER");
                noDupeBarCodeCart.put(sortedCart.get(i), count);
                count = 0;
            }*/
        }
    }
}
