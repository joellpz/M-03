package UF4.Collections.Strings;

public class castig {
    public static void main(String[] args) {
        final String MSG_COPY = "No faré servir mai més l'operador suma per concatenar STRINGS";
        final int num_linies = 50000;
        String s = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< num_linies; i++){
           /* s = s + MSG_COPY;
            s = s.concat(MSG_COPY);*/
            sb.append(MSG_COPY);
        }
    }
}
