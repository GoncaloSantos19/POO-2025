package pt.escnaval.exercicios;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Classe Cliente — composição com Endereco, implementa Autenticavel.
 * Identidade baseada apenas em id.
 */
public class Cliente implements Autenticavel {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    private final int id;
    private final String nome;
    private String email;
    private final Endereco endereco;
    private String senha;
    private final boolean valido;

    public Cliente(int id, String nome, String email, Endereco endereco, String senha) {
        this.id = id;
        this.nome = nome != null ? nome.trim() : "";
        this.email = email != null ? email.trim() : "";
        this.endereco = endereco;
        this.senha = senha != null ? senha : "";
        this.valido = validar();
    }

    private boolean validar() {
        return id > 0 && !nome.isEmpty() && validarEmail(email) &&
               endereco != null && endereco.isValido() && !senha.isEmpty();
    }

    private boolean validarEmail(String e) {
        if (e == null || e.isEmpty()) return false;
        return EMAIL_PATTERN.matcher(e).matches();
    }

    public boolean isValido() {
        return valido;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Muda o email se válido.
     * @param novoEmail novo email
     * @return true se alterado com sucesso
     */
    public boolean mudarEmail(String novoEmail) {
        if (!valido || !validarEmail(novoEmail)) return false;
        this.email = novoEmail.trim();
        return true;
    }

    /**
     * Muda a senha.
     * @param novaSenha nova senha
     * @return true se alterada com sucesso
     */
    public boolean mudarSenha(String novaSenha) {
        if (!valido || novaSenha == null || novaSenha.isEmpty()) return false;
        this.senha = novaSenha;
        return true;
    }

    // Implementação de Autenticavel
    @Override
    public String getIdentificador() {
        return email;
    }

    @Override
    public boolean autenticar(String senha) {
        if (!valido || senha == null) return false;
        return this.senha.equals(senha);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente outro = (Cliente) obj;
        return id == outro.id; // identidade apenas por id
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // apenas id
    }

    @Override
    public String toString() {
        if (!valido) return "[Cliente inválido]";
        return "Cliente#" + id + " " + nome + " (" + email + ")";
    }
}
