package Supermercat;
import java.util.List;

/**
 * Un client que té una llista de valors que representen el preu(int)
 * dels productes que porta al seu carret
 * Aquesta llista és el que la Caixa agafarà per calcular el preu total a pagar
 * Fitxers: 'Caixa.java', 'Supermercat.java'
 */

public class Client {
    private String Nom;
    private List<Integer> carret;

    public Client(String nom, List<Integer> carret) {
        this.carret = carret;
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public List<Integer> getCarret() {
        return carret;
    }

    public void setCarret(List<Integer> carret) {
        this.carret = carret;
    }
}
