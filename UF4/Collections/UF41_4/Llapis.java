package UF4.Collections.UF41_4;

public class Llapis {

    public enum Colors{
        Negre(0),
        Gris(1),
        Vermell(2),
        Groc(3),
        Verd(4),
        Blau(5),
        Blanc(6),
        Violeta(7);

        private int color;
        Colors(int color) {
            this.color = color;
        }
    }
    static float gruix;
    static int color;
    public Llapis(float gruix, int color) {
        if (gruix >= 0.1 && gruix <= 3.0)
            this.gruix = gruix;
        if (color >=0 && color <= 7)
            this.color = color;
    }

    public static float getGruix() {
        return gruix;
    }

    public static void setGruix(float gruix) {
        Llapis.gruix = gruix;
    }

    public static int getColor() {
        return color;
    }

    public static void setColor(int color) {
        Llapis.color = color;
    }


}
