package UF4.Collections.UF41_4;

import java.util.ArrayList;

public class Caixa {
    ArrayList<Llapis> caixa = new ArrayList<>(2);

    public static void main(String[] args) {
        int value;
        value = Llapis.Colors.values().length;
        System.out.println(value);
    }
}
