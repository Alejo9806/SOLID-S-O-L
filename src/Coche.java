public class Coche {
    public String modelo;
    public String color;
    public int potencia;
    public int cilindrada;
    public int numeroRuedas;
    public String marca;
    public String matricula;

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", potencia=" + potencia +
                ", cilindrada=" + cilindrada +
                ", numeroRuedas=" + numeroRuedas +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
