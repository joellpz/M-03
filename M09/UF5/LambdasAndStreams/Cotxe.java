package M09.UF5.LambdasAndStreams;

public class Cotxe {
    String marca;
    public Cotxe(String m) {
        marca = m;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "uf5.LambdasAndStreams.Cotxe{" +
                "marca='" + marca + '\'' +
                '}';
    }
}