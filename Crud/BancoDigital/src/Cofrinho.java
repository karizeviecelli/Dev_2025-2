import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> moedas = new ArrayList<>();

    public void adicionar(Moeda m) {
        moedas.add(m);
    }

    public void listar() {
        System.out.println("\n--- COFRINHO ---");
        if (moedas.isEmpty()) {
            System.out.println("Cofrinho vazio!");
        } else {
            for (Moeda m : moedas) {
                System.out.println(m);
            }
        }
    }

    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda m : moedas) {
            total += m.converterParaReal();
        }
        return total;
    }
}
