package pt.escnaval.exercicios.modelo;

import pt.escnaval.exercicios.exceptions.*;

/**
 * Interface ContaBancaria — define o contrato público para todas as contas.
 * Todos os métodos que lançam exceções checked devem declarar throws.
 */
public interface ContaBancaria {
    
    /**
     * @return número único da conta
     */
    String getNumero();
    
    /**
     * @return titular da conta
     */
    String getTitular();
    
    /**
     * @return saldo atual
     */
    double getSaldo();
    
    /**
     * Deposita um valor na conta.
     * @param valor valor a depositar (deve ser > 0)
     * @throws ContaBancariaException se valor <= 0 (checked - erro de negócio)
     */
    void depositar(double valor) throws ContaBancariaException;
    
    /**
     * Levanta um valor da conta.
     * @param valor valor a levantar
     * @throws ContaBancariaException se saldo insuficiente ou valor inválido (checked - erro de negócio)
     */
    void levantar(double valor) throws ContaBancariaException;
    
    /**
     * Transfere valor para outra conta.
     * @param destino conta destino
     * @param valor valor a transferir
     * @throws ContaBancariaException se saldo insuficiente ou parâmetros inválidos (checked)
     */
    void transferir(ContaBancaria destino, double valor) throws ContaBancariaException;
    
    /**
     * @return tipo da conta (ex: "Corrente", "Poupança")
     */
    String getTipo();
}
