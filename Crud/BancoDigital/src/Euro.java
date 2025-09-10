public class Euro extends Moeda {
    private static final double TAXA = 6.0; // 1 EUR = 6 BRL (exemplo)

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * TAXA;
    }

    @Override
    public String toString() {
        return valor + " EUR (equivale a " + converterParaReal() + " BRL)";
    }
}
    