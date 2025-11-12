package pt.escnaval.exercicios;

import java.util.Objects;

/**
 * Classe de domínio Aluno com encapsulamento e invariantes.
 */
public class Aluno {
    private final int id; // id imutável e > 0
    private String nome;

    public Aluno(int id, String nome) {
        if (id <= 0) throw new IllegalArgumentException("id deve ser > 0");
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("nome não pode ser vazio");
        this.id = id;
        this.nome = nome.trim();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("nome não pode ser vazio");
        this.nome = nome.trim();
    }

    @Override
    public String toString() {
        // formato tabular id\tnome para facilitar listagens
        return String.format("%d\t%s", id, nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
