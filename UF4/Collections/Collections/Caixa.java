package UF4.Collections.Collections;

import java.util.*;

public class Caixa{
    List<Llapis> caixa = new ArrayList<>(10);
    int color;
    float guix;

    public void omplirColor(){
        int valor;
        for (int i = 0; i < 10; i++) {
            valor = (int)(Math.random() * 7);
            caixa.add(new Llapis(valor));
        }
    }

    public void omplirColGruix(){
        int color;
        float gruix;
        for (int i = 0; i < 10; i++) {
            color = (int)(Math.random() * 7);
            gruix = (float)Math.round((Math.random() * 3)*10)/10;
            caixa.add(new Llapis(color, gruix));
        }
    }
    public void ordenarColor(){
        Collections.sort(caixa);
    }

    public void ordenarGruix(){
        Collections.sort(caixa, new Comparator<Llapis>() {
            @Override
            public int compare(Llapis o1, Llapis o2) {
                if(o1.getGruix() < o2.getGruix()) return 1;
                else if (o1.getGruix() > o2.getGruix()) return -1;
                else return 0;
            }
        });
    }
    @Override
    public String toString() {
        String string = "Caixa: \n";
        int i;
        string += "for -> \n";
        for (i = 0; i < caixa.size(); i++) {
            string += caixa.get(i)+"\n";
        }
        i=0;
        string += "\nfor each-> \n";
        for (Llapis c: caixa) {
            string += caixa.get(i)+"\n";
            i++;
        }
        string += "\nIterator -> \n";
        Iterator it = caixa.iterator();
        while (it.hasNext()){
            string += it.next()+"\n";

        }
        return string;
    }
}
