package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Pay {
    public static void makeTicket(Cart cart) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("--- TICKET ---");
        System.out.println("--------------");
        System.out.println("*** " + dtf.format(LocalDateTime.now()) + " - JoelMarket ***");

    }

    private static Map<Product, Integer> getDupes(Cart cart) {
        Map<Product, Integer> productCount = new HashMap<>();
        for (Product p : cart.getShoppingCart()) {
            Integer count = productCount.get(p);
            if (count == null) {
                productCount.put(p, 1);
            } else {
                productCount.put(p, ++count);
            }
        }
    }


}
