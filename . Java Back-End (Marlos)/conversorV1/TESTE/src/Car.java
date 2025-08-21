import java.util.Objects;

public class Car {
    String nome;

    public Car(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
