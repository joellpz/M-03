package uf5.RegExC;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PapaNoel {
    private static String[] values = {"Papa Noel", "Ren", "Follet"};
    private static String[] regex = {"\\*<]:-DOo", ">:o\\)", "<]:-D"};
    private static Map<String, Integer> reps = new HashMap<>();
    static String line;
    static int cont = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("uf5/RegExC/santako.txt"));
        br.mark(0);
        regexFind(br);
        br.reset();
        stringFind(br);
        br.close();
    }

    public static void regexFind(BufferedReader br) throws IOException {
        while ((line = br.readLine()) != null) {

            for (int i = 0; i < values.length; i++) {
                cont = 0;
                Pattern P = Pattern.compile(regex[i]);
                Matcher m = P.matcher(line);
                while (m.find()) {
                    cont++;
                }
                if (values[i].equals("Follet")) cont -= reps.get("Papa Noel");
                reps.put(values[i], cont);
            }
            reps.forEach((k, v) -> {
                if (v != 0) {
                    System.out.print(k + "(" + v + ")" + " ");
                }
            });
            System.out.println();
        }
    }

    public static void stringFind(BufferedReader br) throws IOException {
        String lineCP = line;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                cont = 0;
                //while(lineCP.contains(regex[i])){
                System.out.println(lineCP.indexOf(regex[i]));
                //}
            }
        }
    }
}
