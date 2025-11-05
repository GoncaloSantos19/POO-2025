package pt.escnaval.exercicios;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void mostrar() {
        System.out.printf("Nome: %s, Idade: %d", nome, idade);
    }
}
