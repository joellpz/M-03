package Carrito;

public class Menu {
    public void shoppingMenu() {
        String[] options = {"Introduir Producte",
                "Passar per caixa",
                "Mostrar carro de la compra",
                "Sortir"};
        System.out.println("--- Tria una opció ---");
        for (int i = 0; i < options.length; i++) {
            if (i == options.length-1) System.out.println("0. "+ options[i]);
            else System.out.println((i+1) +". "+ options[i]);
        }
    }

    public void productMenu(){
        String[] options = {"Alimentació",
                "Téxtil",
                "Electrònica",
                "Tornar"};

        System.out.println("--- Tria una opció ---");
        for (int i = 0; i < options.length; i++) {
            if (i == options.length-1) System.out.println("0. "+ options[i]);
            else System.out.println((i+1) +". "+ options[i]);
        }
    }
}
