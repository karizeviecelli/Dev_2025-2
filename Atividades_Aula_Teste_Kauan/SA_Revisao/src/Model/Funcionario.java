package Model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private double salario;
    private String cargo;

    public Funcionario(String nome, String cpf, LocalDate dtNasc, double salario, String cargo) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDt_nas(dtNasc);
        this.setSalario(salario);
        this.setCargo(cargo);
    }

    public Funcionario(double salario, String cargo, int id, String nome, String cpf, LocalDate dt_nas) {
        super(id, nome, cpf, dt_nas);
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(double salario, String cargo, String nome, String cpf, LocalDate dt_nas) {
        super(nome, cpf, dt_nas);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + super.toString() + ", salario=" + salario + ", cargo=" + cargo + "}";
    }

}
