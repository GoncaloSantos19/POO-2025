package pt.escnaval.exercicios.exceptions;

/**
 * Exceção base (checked) para erros relacionados com contas bancárias.
 * Todas as exceções de negócio do sistema bancário devem estender esta classe.
 * 
 * Checked Exception: obriga o chamador a tratar ou declarar (throws).
 */
public class ContaBancariaException extends Exception {
    
    public ContaBancariaException(String mensagem) {
        super(mensagem);
    }
    
    public ContaBancariaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
