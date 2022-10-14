package Carrito;

import java.util.Scanner;

public class Menu {
    private static int opt;
    private static final Scanner sc = new Scanner(System.in);
    private static final Cart shoppingCart = new Cart();

    public static void shoppingMenu() {
        String[] options = {"Introduir Producte",
                "Passar per caixa",
                "Mostrar carro de la compra",
                "Sortir"};


        do {
            System.out.println("--- Tria una opció ---");
            for (int i = 0; i < options.length; i++) {
                if (i == options.length - 1) System.out.println("0. " + options[i]);
                else System.out.println((i + 1) + ". " + options[i]);
            }
            switch (opt = sc.nextInt()) {
                case 1:
                    productMenu();
                    opt = 1;
                    break;
                case 2:
                    Pay.makeTicket(shoppingCart);
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("--- Mala Opció... ERROR --- ");
                    break;
            }
        } while (opt != 0);
    }

    public static void productMenu() {
        String[] options = {"Alimentació",
                "Téxtil",
                "Electrònica",
                "Tornar"};
        do {
            System.out.println("--- Tria una opció ---");
            for (int i = 0; i < options.length; i++) {
                if (i == options.length - 1) System.out.println("0. " + options[i]);
                else System.out.println((i + 1) + ". " + options[i]);
            }
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("-- " + options[0] + " --");
                    Food eatingObject = new Food();
                    System.out.println("Introdueix la Data de Caducitat (dd/MM/yyyy):");
                    eatingObject.setExpirationDate(sc.nextLine());
                    setProductVariables(eatingObject);
                    shoppingCart.addToCart(eatingObject);
                    break;
                case 2:
                    System.out.println("-- " + options[1] + " --");
                    Textile textileObject = new Textile();
                    System.out.println("Introdueix el Material:");
                    textileObject.setComposition(sc.nextLine());
                    setProductVariables(textileObject);
                    shoppingCart.addToCart(textileObject);
                    break;
                case 3:
                    System.out.println("-- " + options[2] + " --");
                    Electronics electroObject = new Electronics();
                    System.out.println("Introdueix la Garantia del Producte:");
                    electroObject.setWarrantyDays(sc.nextInt());
                    sc.nextLine();
                    setProductVariables(electroObject);
                    shoppingCart.addToCart(electroObject);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("--- Mala Opció... ERROR --- ");
                    break;
            }
        } while (opt != 0);

    }

    public static void setProductVariables(Product p) {
        System.out.println("Nom del Producte:");
        p.setName(sc.nextLine());
        System.out.println("Preu:");
        p.setPrice(sc.nextFloat());
        System.out.println("Codi de Barres: (barras, barras, pensalas...)");
        p.setBarCode(sc.nextInt());
        sc.nextLine();
    }
}
