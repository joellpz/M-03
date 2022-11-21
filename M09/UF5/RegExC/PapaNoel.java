package M09.UF5.RegExC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PapaNoel {
    private static final String[] values = {"Papa Noel", "Ren", "Follet"};
    private static final String[] regex = {"\\*<]:-DOo", ">:o\\)", "<]:-D"};
    private static final String[] regexString = {"*<]:-DOo", ">:o)", "<]:-D"};
    private static final Map<String, Integer> reps = new HashMap<>();
    static String line;
    static int cont = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br_regex = new BufferedReader(new FileReader("M09/UF5/RegExC/santako.txt"));
        BufferedReader br_string = new BufferedReader(new FileReader("M09/UF5/RegExC/santako.txt"));
        regexFind(br_regex);

        stringFind(br_string);
        br_regex.close();
        br_string.close();
    }

    public static void regexFind(BufferedReader br) throws IOException {
        System.out.println("\n--- With RegEX: ---");
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
        String lineCP ;
        System.out.println("\n--- With Strings: ---");
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                lineCP = line;
                cont = 0;
                //System.out.println(" --> Regex: " + regexString[i] + " Contiene: "+ lineCP.contains(regexString[i]));
                //System.out.println(" ////" + lineCP);
                while(lineCP.contains(regexString[i])){
                    //System.out.println(lineCP);

                    lineCP = lineCP.substring(lineCP.indexOf(regexString[i])+regexString[i].length());
                    cont++;
                    //System.out.println(lineCP);
                    //System.out.println(regexString[i]);
                    //System.out.println(cont);
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
}
