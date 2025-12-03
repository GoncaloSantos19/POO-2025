package pt.escnaval.exercicios.modelo;

import pt.escnaval.exercicios.exceptions.*;

/**
 * Conta Poupança — não permite saldo negativo, tem limite de levantamentos mensais.
 */
public class ContaPoupanca extends ContaBancariaBase {
    
    private final int limiteLevantamentosMensais;
    private int levantamentosRealizados;
    
    /**
     * Cria uma conta poupança.
     * @param numero número da conta
     * @param titular titular
     * @param saldoInicial saldo inicial (>= 0)
     * @param limiteLevantamentosMensais limite de levantamentos por mês
     * @throws ContaInvalidaException se parâmetros inválidos
     */
    public ContaPoupanca(String numero, String titular, double saldoInicial, int limiteLevantamentosMensais) {
        super(numero, titular, saldoInicial);
        if (limiteLevantamentosMensais <= 0) {
            throw new ContaInvalidaException("Limite de levantamentos deve ser positivo: " + limiteLevantamentosMensais);
        }
        this.limiteLevantamentosMensais = limiteLevantamentosMensais;
        this.levantamentosRealizados = 0;
    }
    
    public int getLimiteLevantamentosMensais() {
        return limiteLevantamentosMensais;
    }
    
    public int getLevantamentosRealizados() {
        return levantamentosRealizados;
    }
    
    /**
     * Reseta o contador de levantamentos (simula início de novo mês).
     */
    public void resetarLevantamentosMensais() {
        this.levantamentosRealizados = 0;
    }
    
    /**
     * Sobrescreve levantar para verificar limite de levantamentos.
     * @throws OperacaoNaoPermitidaException se limite de levantamentos atingido
     * @throws SaldoInsuficienteException se saldo insuficiente
     */
    @Override
    public void levantar(double valor) throws ContaBancariaException {
        validarValorPositivo(valor, "levantamento");
        
        // Verifica limite de levantamentos mensais
        if (levantamentosRealizados >= limiteLevantamentosMensais) {
            throw new OperacaoNaoPermitidaException(
                    "levantamento",
                    getTipo(),
                    String.format("Limite mensal de %d levantamentos atingido", limiteLevantamentosMensais)
            );
        }
        
        // Não permite saldo negativo (sem descoberto)
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        
        saldo -= valor;
        levantamentosRealizados++;
    }
    
    @Override
    public String getTipo() {
        return "Conta Poupança";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", Levantamentos: %d/%d",
                levantamentosRealizados, limiteLevantamentosMensais);
    }
}
