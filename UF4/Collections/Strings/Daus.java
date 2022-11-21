package UF4.Collections.Strings;

import java.util.Random;
import java.util.Scanner;

public class Daus {
    public static void main(String[] args) {
        int daus = 0, valor = 0;
        int[] prob = new int[12];
        boolean rep = false;
        Random aleat = new Random();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quants cops vols llençar els daus?");
            daus = sc.nextInt();
            if (daus < 2){
                rep = true;
            }else{
                for (int i = 0; i < daus;i++){
                    for (int j = 0; j < 2; j++){
                        valor = valor + aleat.nextInt(6)+1;
                    }
                    prob[valor-1]++;
                    System.out.println(valor);
                    valor = 0;
                }
                for (int k = 1;k < prob.length; k++){
                    System.out.println(k+1 + "--> " + prob[k] + " vegades.");
                }
                rep = false;
            }
        }while (rep);

    }
}
