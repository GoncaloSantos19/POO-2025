package pt.escnaval.exercicios;

/**
 * Interface Autenticavel — define contrato de autenticação.
 */
public interface Autenticavel {
    /**
     * Retorna identificador único do objeto autenticável.
     * @return identificador (ex: email, username)
     */
    String getIdentificador();

    /**
     * Autentica com a senha fornecida.
     * @param senha senha a validar
     * @return true se autenticação bem-sucedida
     */
    boolean autenticar(String senha);
}
