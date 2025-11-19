package pt.escnaval.exercicios;

import java.util.Objects;

/**
 * Classe Endereco — objeto de valor imutável.
 * equals/hashCode baseados em todas as propriedades.
 */
public class Endereco {
    private final String rua;
    private final String cidade;
    private final String codigoPostal;
    private final boolean valido;

    public Endereco(String rua, String cidade, String codigoPostal) {
        this.rua = rua != null ? rua.trim() : "";
        this.cidade = cidade != null ? cidade.trim() : "";
        this.codigoPostal = codigoPostal != null ? codigoPostal.trim() : "";
        this.valido = validar();
    }

    private boolean validar() {
        return !rua.isEmpty() && !cidade.isEmpty() && !codigoPostal.isEmpty();
    }

    public boolean isValido() {
        return valido;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Endereco outro = (Endereco) obj;
        return Objects.equals(rua, outro.rua) &&
               Objects.equals(cidade, outro.cidade) &&
               Objects.equals(codigoPostal, outro.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, cidade, codigoPostal);
    }

    @Override
    public String toString() {
        if (!valido) return "[Endereco inválido]";
        return rua + ", " + cidade + ", " + codigoPostal;
    }
}
