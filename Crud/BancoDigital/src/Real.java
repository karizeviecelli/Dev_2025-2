public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor; // já está em reais
    }

    @Override
    public String toString() {
        return valor + " BRL";
    }
}
