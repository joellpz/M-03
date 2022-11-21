package UF4.Collections.Collections;

import java.util.Objects;

public class Llapis implements Comparable<Llapis>{ //6 se hace con COMPARABLE
    int color;
    float gruix;

    public Llapis(int color, float gruix) {
        if (color >= 0 && color <= 7) this.color = color;
        if (gruix >= 0.1 && gruix <= 3.0) this.gruix = gruix;
    }

    public Llapis(int color){
        if (color >= 0 && color <= 7) this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getGruix() {
        return gruix;
    }

    public void setGruix(int gruix) {
        this.gruix = gruix;
    }

    @Override
    public String toString() {
        return "Llapis: " +
                "color=" + color +
                ", gruix=" + gruix;
    }

    @Override
    public int compareTo(Llapis o) {
        if(this.color < o.getColor()) return 1;
        else if (this.color > o.getColor()) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llapis llapis = (Llapis) o;
        return color == llapis.color && Float.compare(llapis.gruix, gruix) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, gruix);
    }
}
