package uf5.RegEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PapaNoel {
    public static void main(String[] args) throws FileNotFoundException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("santako.txt"));
        String[] val = {"Papa Noel","Ren","Follet"};
        String[] regex = {"\\*<]:-DOo",">:o\\)","<]:-D"};

        Map<String,Integer> mapReps = new HashMap<>();

        for (int i = 0; i < regex.length; i++) {
            Pattern P = Pattern.compile(regex[i]);
            Matcher m = P.matcher(linia);
        }

        int compte = 0;
        while (m.find()) {
            compte++;
        }
        System.out.println(compte);
    }
}
