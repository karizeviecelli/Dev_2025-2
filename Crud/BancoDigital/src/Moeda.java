public abstract class Moeda {
    protected double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public void retirar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}