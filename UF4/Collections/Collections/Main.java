package UF4.Collections.Collections;

import java.util.*;

public class Main {
    public static Caixa caixa1 = new Caixa();
    public static Caixa caixa2 = new Caixa();

    public static void main(String[] args) {

        System.out.println("\n--------------------Exercici 3 i 4--------------------");
        caixa1.omplirColor();
        caixa2.omplirColGruix();
        System.out.println("\n--------------------Exercici 5--------------------");
        System.out.println(caixa1);
        System.out.println(caixa2);
        System.out.println("\n--------------------Exercici 6 i 7--------------------");
        caixa1.ordenarColor();
        caixa2.ordenarGruix();
        //System.out.println(caixa1);
        //System.out.println(caixa2);

        //8
        System.out.println("\n--------------------Exercici 8--------------------");

        List<Llapis> ll = new LinkedList<>(caixa2.caixa);
        //Collections.copy(ll,caixa2.caixa);

        //9
        System.out.println("\n--------------------Exercici 9--------------------");

        //ll.addAll(caixa1.caixa);
        for (Llapis llapis : caixa1.caixa
        ) {
            ll.add(llapis);
        }

        //10
        System.out.println("\n--------------------Exercici 10--------------------");
        Iterator it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //11
        System.out.println("\n--------------------Exercici 11--------------------");

        HashSet<Llapis> nocopyBox = new HashSet<>(ll);

        /*for (Llapis llapis: ll) {
            if (!nocopyBox.caixa.contains(llapis)) nocopyBox.caixa.add(llapis);
        }*/
        System.out.println(nocopyBox);

        //12
        System.out.println("\n--------------------Exercici 12--------------------");

        Map<Integer, String> map_colors = new HashMap<>();
        map_colors.put(0, "Negre");
        map_colors.put(1, "Vermell");
        map_colors.put(2, "Groc");
        map_colors.put(3, "Verd");
        map_colors.put(4, "Verd");
        map_colors.put(3, "Blanc");
        /*
        12.1 El que passa es que agafa l'ultima definició per posició, 
        ve a dir, sobreescriu amb la infomació definida en ultima instancia.
        */


        //12.2
        System.out.println("\n--------------------Exercici 12.2--------------------");

        System.out.println(map_colors.keySet() + "" + map_colors.values());

        //12.3
        System.out.println("\n--------------------Exercici 12.3--------------------");

        //for (int i = 0; i < map_colors.size(); i++) {
        System.out.println(map_colors.values());
        //}

        //13
        System.out.println("\n--------------------Exercici 13--------------------");

        int daus;
        List valDaus = new ArrayList();
        for (int i = 0; i < 10; i++) {
            daus = (int) (Math.random() * 12) + 1;
            valDaus.add(daus);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(i + 1 + ": " + Collections.frequency(valDaus, i));
        }

        //14
        System.out.println("\n--------------------Exercici 14--------------------");

        Map<Integer, Integer> map_daus = new HashMap<>();
        int val;
        for (int i = 0; i < 100; i++) {
            daus = (int) (Math.random() * 12) + 1;
            if (map_daus.containsKey(daus)) map_daus.put(daus, map_daus.get(daus) + 1);
            else map_daus.put(daus, 1);
        }
        System.out.println(map_daus);

        //15
        System.out.println("\n--------------------Exercici 15--------------------");

        List<Alumne> alumnes = new ArrayList<>(3);
        alumnes.add(new Alumne("Joel", Alumne.Genere.HOME, "Hola"));
        alumnes.add(new Alumne("JA", Alumne.Genere.DONA, "1"));
        alumnes.add(new Alumne("No", Alumne.Genere.NOBINARI, "2"));
        UF mp3uf4 = new UF("003004", "Introducció a la POO");
        UF mp3uf5 = new UF("003005", "POO avançada");
        for (int i = 0; i < alumnes.size(); i++) {
            alumnes.get(i).addNota(mp3uf4, Qualifier.NOTABLE);
            alumnes.get(i).addNota(mp3uf5, Qualifier.EXCELLENT);
        }
        //Notes x alumne
        for (Alumne a : alumnes) {
            System.out.println(a.getNom());
            System.out.println("-------------");
            a.getNotes().forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
            System.out.println("-------------");
        }
        //Nota Mitja
        Map<String, Float> notesMitges = new TreeMap<>();
        for (Alumne a : alumnes) {
            float notaM = 0;
            for (Map.Entry entry : a.getNotes().entrySet()) {
                Qualifier qf = (Qualifier) entry.getValue();
                notaM += qf.getValor();
            }
            notaM = notaM / a.getNotes().size();
            System.out.printf("Nota mitja de %s és %f%n", a.getNom(), notaM);
            notesMitges.put(a.getNom(), notaM);
        }
    }
}
