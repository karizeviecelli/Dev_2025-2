package Model;


import java.time.LocalDate;

public class Pessoa {

    int id;
    private String nome;
    private String cpf;
    private LocalDate dt_Nas;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, LocalDate dt_nas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dt_Nas = dt_nas;
    }

    public Pessoa(String nome, String cpf, LocalDate dt_nas) {
        this.nome = nome;
        this.cpf = cpf;
        this.dt_Nas = dt_nas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDt_nas() {
        return dt_Nas;
    }

    public void setDt_nas(LocalDate dt_nas) {
        this.dt_Nas = dt_nas;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dt_Nas=" + dt_Nas + '}';
    }
    
    
}
