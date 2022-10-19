package Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Pay {
    /*
    * makeTicket: Funcion encargada de crear el formato del TICKET, enumerar y mostrar
    * los productos introducidos al carro llamando a getDupes para recoger los elementos
    * reperidos y mostrar el precio. Posteriomente borra el carro simulando el pago de
    * los productos.
    * */
    public static void makeTicket(Cart cart) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("--------------------- T I C K E T ---------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("*************** " + dtf.format(LocalDateTime.now()) + " - JoelMarket" + " ***************");
        if (cart.getShoppingCart().size() == 0) {
            System.out.println("- EL CARRET ESTÀ BUIT -");
        }else {
            Map<Product, Integer> products = getDupes(cart);
            for (Product p : products.keySet()) {
                System.out.println("- " + p.getName() + " - " + products.get(p) +
                        "u - " + p.getPrice() + "€ - Total:" +
                        (p.getPrice() * products.get(p)) + "€ - ");
            }
            cart.getShoppingCart().clear();
        }
        System.out.println();
    }

    /*
    * getDupes: Encargada de enumerar los productos y contar los productos que se
    * repiten. Introduciendo cada producto con el numero de repeticiones dentro de
    * un mapa, comparando precio y el codigo de barras.
    * */
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
