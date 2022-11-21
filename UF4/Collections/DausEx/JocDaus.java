package UF4.Collections.DausEx;

import java.util.Arrays;

/**
 * daus
 *
 * @JoelLopez
 */
public class JocDaus {
    Dau[] dau = new Dau[3];
    public JocDaus() {
        for (int i = 0; i < dau.length; i++) {
            this.dau[i] = new Dau();
        }
    }

    public boolean jugar() {
        for (int i = 0; i < dau.length; i++) {
            this.dau[i].tirar();
        }
        if (dau[0].equals(dau[1]) && dau[0].equals(dau[2])) {
            return true;
        }else{
            return false;
        }
    }

    public String toString() {
        return "JocDeDaus{dau=" + Arrays.toString(this.dau) + '}';
    }

}
