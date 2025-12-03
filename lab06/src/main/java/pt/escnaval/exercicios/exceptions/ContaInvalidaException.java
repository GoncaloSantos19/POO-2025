package pt.escnaval.exercicios.exceptions;

/**
 * Exceção (unchecked) lançada quando uma conta bancária é criada com
 * parâmetros inválidos ou está em estado inválido.
 * 
 * É unchecked porque representa uma violação de invariantes/pré-condições
 * (erro de programação, não erro de negócio).
 */
public class ContaInvalidaException extends IllegalArgumentException {
    
    public ContaInvalidaException(String mensagem) {
        super(mensagem);
    }
    
    public ContaInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
