package UF4.Collections.DausEx;

public class Dau {

    /**
     * daus
     *
     * @JoelLopez
     */
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "UF4.Collections.DausEx.Dau{" +
                "valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dau dau = (Dau) o;
        return valor == dau.valor;
    }

    public int tirar() {
        return this.valor = (int) (Math.random() * 6 +1);
    }




}
