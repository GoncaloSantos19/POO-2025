package pt.escnaval.exercicios;

public class Colaborador extends Pessoa {
    private double salario;
    private int ano;
    private int mes;
    private int dia;

    public Colaborador(String nome, int idade, double salario, int ano, int mes, int dia) {
        super(nome, idade);
        this.salario = salario;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double percentagem) {
        if (percentagem > 0) {
            salario += salario * percentagem / 100.0;
        }
    }

    public String getDataContratacao() {
        return String.format("%04d-%02d-%02d", ano, mes, dia);
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(", Salário: %.2f, Contratação: %s", salario, getDataContratacao());
    }
}
