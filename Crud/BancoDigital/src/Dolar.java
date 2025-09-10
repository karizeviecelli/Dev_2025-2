public class Dolar extends Moeda {
    private static final double TAXA = 5.0; // 1 USD = 5 BRL (exemplo)

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA;
    }

    @Override
    public String toString() {
        return valor + " USD (equivale a " + converterParaReal() + " BRL)";
    }
}
