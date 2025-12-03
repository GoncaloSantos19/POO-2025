package pt.escnaval.exercicios.exceptions;

/**
 * Exceção (checked) lançada quando uma operação específica não é permitida
 * no tipo de conta atual.
 * 
 * Exemplo: tentar levantar de uma conta poupança que tem restrições.
 * É checked porque é um erro de negócio recuperável.
 */
public class OperacaoNaoPermitidaException extends ContaBancariaException {
    
    private final String tipoOperacao;
    private final String tipoConta;
    
    public OperacaoNaoPermitidaException(String tipoOperacao, String tipoConta, String motivo) {
        super(String.format("Operação '%s' não permitida para conta tipo '%s': %s",
                tipoOperacao, tipoConta, motivo));
        this.tipoOperacao = tipoOperacao;
        this.tipoConta = tipoConta;
    }
    
    public String getTipoOperacao() {
        return tipoOperacao;
    }
    
    public String getTipoConta() {
        return tipoConta;
    }
}
