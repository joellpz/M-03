package UF4.Carrito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cart {
    private final List<Product> shoppingCart = new ArrayList<>();
    private final Map<Product, Integer> noDupeBarCodeCart = new HashMap<>();

    public void addToCart(Product p) {
        if (shoppingCart.size() < 100 ) {
            shoppingCart.add(p);
            System.out.println("--- Producte \"" + p.name + "\" ha estat introduit al CARRO. ---");
        }else{
            System.out.println("** ERROR, no pots agafar més productes **");
        }

    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    /*
    * showCart: Funció que formateja i mostra el carret en el moment que s'executa.
    * Crida la funció auxiliar getBarCodeDupes per determinar la quantitat d'elements
    * que es troben repetits segons un criteri en especific.
    * */
    public void showCart() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("-------------------- T H E  C A R T -------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("*************** " + dtf.format(LocalDateTime.now()) + " - JoelMarket" + " ***************");
        getBarCodeDupes(shoppingCart);
        if (shoppingCart.size() == 0) {
            System.out.println("- EL CARRET ESTÀ BUIT -");
        } else {
            for (Product p : noDupeBarCodeCart.keySet()) {
                System.out.println("- " + p.getBarCode() + " - " + p.getName() + " - " + noDupeBarCodeCart.get(p) +
                        "u");
            }
            noDupeBarCodeCart.clear();
        }
        System.out.println();
    }


    /*
    * getBarCodeDupes: Enviem un carro i comparem els seus BarCodes per
    * determinar si es troben repetits. Posteriorment asignem els valor
    * dessitjats a un Map<Producte, Integer> amb el producte en qÚestió
    * i la quantitat de repeticions.
    * */
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
        }
    }
}
