package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Pay {
    public static void makeTicket(Cart cart) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("--------------------- T I C K E T ---------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("*************** " + dtf.format(LocalDateTime.now()) + " - JoelMarket" + " ***************");
        Map<Product, Integer> products = getDupes(cart);
        for (Product p : products.keySet()) {
            System.out.println("- " + p.getName() + " - " + products.get(p) +
                    "u - " + p.getPrice() + "€ - Total:" +
                    (p.getPrice() * products.get(p)) + "€ - ");
        }
        cart.getShoppingCart().clear();
        System.out.println();
    }

    private static Map<Product, Integer> getDupes(Cart cart) {
        Map<Product, Integer> productCount = new HashMap<>();
        Integer count;
        for (Product p : cart.getShoppingCart()) {
            count = productCount.get(p);
            if (count == null) {
                productCount.put(p, 1);
            } else {
                productCount.put(p, ++count);
            }
        }
        return productCount;
    }


}
