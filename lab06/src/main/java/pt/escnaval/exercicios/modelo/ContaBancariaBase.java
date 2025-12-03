package pt.escnaval.exercicios.modelo;

import pt.escnaval.exercicios.exceptions.*;
import java.util.Objects;

/**
 * Classe abstrata ContaBancariaBase — implementação base comum.
 * Centraliza validações e comportamento compartilhado.
 * Subclasses concretas apenas implementam lógica específica.
 */
public abstract class ContaBancariaBase implements ContaBancaria {
    
    private final String numero;
    private final String titular;
    protected double saldo; // protected para acesso em subclasses
    
    /**
     * Construtor protegido — valida invariantes.
     * @param numero número da conta (formato PTXX-YYYY-ZZZZZZZZ)
     * @param titular titular (não pode ser null/vazio)
     * @param saldoInicial saldo inicial (deve ser >= 0)
     * @throws ContaInvalidaException se parâmetros inválidos (unchecked)
     */
    protected ContaBancariaBase(String numero, String titular, double saldoInicial) {
        // Validação com Objects.requireNonNull para null
        Objects.requireNonNull(numero, "Número da conta não pode ser null");
        Objects.requireNonNull(titular, "Titular não pode ser null");
        
        // Validações de negócio
        if (numero.isBlank()) {
            throw new ContaInvalidaException("Número da conta não pode ser vazio");
        }
        
        // Validar formato IBAN português: PTXX-YYYY-ZZZZZZZZ
        if (!numero.matches("PT\\d{2}-\\d{4}-\\d{8}")) {
            throw new ContaInvalidaException("Formato de conta inválido. Use: PTXX-YYYY-ZZZZZZZZ");
        }
        
        if (titular.isBlank()) {
            throw new ContaInvalidaException("Titular não pode ser vazio");
        }
        if (saldoInicial < 0) {
            throw new ContaInvalidaException("Saldo inicial não pode ser negativo: " + saldoInicial);
        }
        
        this.numero = numero.trim();
        this.titular = titular.trim();
        this.saldo = saldoInicial;
    }
    
    @Override
    public String getNumero() {
        return numero;
    }
    
    @Override
    public String getTitular() {
        return titular;
    }
    
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public void depositar(double valor) throws ContaBancariaException {
        validarValorPositivo(valor, "depósito");
        saldo += valor;
    }
    
    @Override
    public void levantar(double valor) throws ContaBancariaException {
        validarValorPositivo(valor, "levantamento");
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        saldo -= valor;
    }
    
    @Override
    public void transferir(ContaBancaria destino, double valor) throws ContaBancariaException {
        Objects.requireNonNull(destino, "Conta destino não pode ser null");
        validarValorPositivo(valor, "transferência");
        
        // Levantar desta conta (pode lançar SaldoInsuficienteException)
        levantar(valor);
        
        try {
            // Depositar na conta destino
            destino.depositar(valor);
        } catch (Exception e) {
            // Se falhar, reverter o levantamento
            saldo += valor;
            throw new ContaInvalidaException("Falha ao depositar na conta destino: " + e.getMessage(), e);
        }
    }
    
    /**
     * Método auxiliar para validar valores positivos.
     * @param valor valor a validar
     * @param operacao nome da operação (para mensagem de erro)
     * @throws ContaBancariaException se valor <= 0 (checked - erro de negócio)
     */
    protected void validarValorPositivo(double valor, String operacao) throws ContaBancariaException {
        if (valor <= 0) {
            throw new ContaBancariaException(
                String.format("Valor para %s deve ser positivo: %.2f", operacao, valor));
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s [%s] - Titular: %s, Saldo: %.2f", 
                getTipo(), numero, titular, saldo);
    }
}
