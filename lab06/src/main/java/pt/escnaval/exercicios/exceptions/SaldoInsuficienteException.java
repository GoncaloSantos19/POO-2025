package pt.escnaval.exercicios.exceptions;

/**
 * Exceção (checked) lançada quando uma operação não pode ser realizada
 * devido a saldo insuficiente.
 * 
 * É checked porque representa um erro de negócio recuperável - o utilizador
 * pode tentar novamente com um valor diferente ou depositar fundos.
 */
public class SaldoInsuficienteException extends ContaBancariaException {
    
    private final double saldoAtual;
    private final double valorSolicitado;
    
    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super(String.format("Saldo insuficiente. Saldo atual: %.2f, Valor solicitado: %.2f",
                saldoAtual, valorSolicitado));
        this.saldoAtual = saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }
    
    public double getSaldoAtual() {
        return saldoAtual;
    }
    
    public double getValorSolicitado() {
        return valorSolicitado;
    }
}
