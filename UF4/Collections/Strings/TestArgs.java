package UF4.Collections.Strings;

public class TestArgs {
    public static void main(String[] args) {
        String nom = "";
        int edat = 0;
        if (args.length == 2) {
            nom = args[0];
            edat = Integer.valueOf(args[1]);
        }else{
            System.out.println("Arguments Incorrectes");
        }

        System.out.printf("Hola %s tens %d anys", nom, edat);
    }
}
