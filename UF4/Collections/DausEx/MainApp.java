package UF4.Collections.DausEx;

import java.util.Scanner;

/**
 * daus
 *
 * @JoelLopez
 */
public class MainApp {

    public static void main(String[] args) {
        JocDaus jc = new JocDaus();
        boolean rep = true, test = false;
        int val, win = 0, lose = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("  -- Que vols fer? -- ");

        do {
            System.out.println("1 - Tirar Daus");
            System.out.println("2 - Parxis");
            System.out.println("3 - Tic Tac Toe");
            System.out.println("0 - Sortir.");
            System.out.print("Tria --> ");
            val = sc.nextInt();
            switch (val) {
                case 0:
                    rep = false;
                    System.out.println("Has guanyat "+ win + " partides y has perdut "+ lose+ " d'un total de " + (win+lose) + " partides.");
                    System.out.println("  -- Fins la Pròxima! -- ");
                    break;

                case 1:
                    if (jc.jugar()) {
                        win++;
                        System.out.println("- Has GUANYAT -");
                    } else {
                        lose++;
                        System.out.println("- Has PERDUT -");
                    }
                    System.out.println(jc);

                    break;
                case 2:
                case 3:
                    System.out.println( " -- Jocs proximament disponibles -- ");
                    break;
                default:
                    System.out.println(" - Ñe, aquesta no és una opció. - ");
                    break;
            }
        } while (rep);

    }
}