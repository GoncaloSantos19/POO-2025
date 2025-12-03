package pt.escnaval.exercicios.servicos;

import pt.escnaval.exercicios.modelo.*;
import pt.escnaval.exercicios.exceptions.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Classe Banco — gerencia um conjunto de contas bancárias.
 * Usa array (sem Collections) e demonstra tratamento robusto de exceções.
 */
public class Banco {
    
    private ContaBancaria[] contas;
    private int numeroContas;
    
    public Banco() {
        this.contas = new ContaBancaria[10]; // capacidade inicial
        this.numeroContas = 0;
    }
    
    /**
     * Adiciona uma conta ao banco.
     * @param conta conta a adicionar
     * @throws ContaInvalidaException se conta null ou já existe
     */
    public void adicionarConta(ContaBancaria conta) {
        Objects.requireNonNull(conta, "Conta não pode ser null");
        
        // Verificar se já existe
        if (encontrarConta(conta.getNumero()) != null) {
            throw new ContaInvalidaException("Conta com número " + conta.getNumero() + " já existe");
        }
        
        // Expandir array se necessário
        if (numeroContas == contas.length) {
            contas = Arrays.copyOf(contas, contas.length * 2);
        }
        
        contas[numeroContas++] = conta;
    }
    
    /**
     * Encontra conta por número.
     * @param numero número da conta
     * @return conta encontrada ou null
     */
    public ContaBancaria encontrarConta(String numero) {
        if (numero == null || numero.isBlank()) {
            return null;
        }
        
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i].getNumero().equals(numero.trim())) {
                return contas[i];
            }
        }
        
        return null;
    }
    
    /**
     * Remove conta por número.
     * @param numero número da conta
     * @return true se removida
     */
    public boolean removerConta(String numero) {
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i].getNumero().equals(numero)) {
                // Deslocar elementos
                for (int j = i; j < numeroContas - 1; j++) {
                    contas[j] = contas[j + 1];
                }
                contas[--numeroContas] = null;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Imprime lista formatada de contas.
     */
    public void listarContas() {
        if (numeroContas == 0) {
            System.out.println("(Nenhuma conta cadastrada)");
            return;
        }
        
        System.out.println("\n═══ LISTA DE CONTAS ═══");
        for (int i = 0; i < numeroContas; i++) {
            System.out.printf("%d. %s%n", i + 1, contas[i]);
        }
    }
    
    /**
     * Retorna array com todas as contas (cópia).
     * @return array com contas
     */
    public ContaBancaria[] obterTodasContas() {
        return Arrays.copyOf(contas, numeroContas);
    }
    
    /**
     * Calcula saldo total de todas as contas.
     * @return soma dos saldos
     */
    public double saldoTotal() {
        double total = 0;
        for (int i = 0; i < numeroContas; i++) {
            total += contas[i].getSaldo();
        }
        return total;
    }
    
    /**
     * Lista contas correntes com descoberto ativo.
     */
    public void listarContasComDescoberto() {
        System.out.println("\n═══ CONTAS COM DESCOBERTO ═══");
        boolean encontrou = false;
        
        for (int i = 0; i < numeroContas; i++) {
            if (contas[i] instanceof ContaCorrente && contas[i].getSaldo() < 0) {
                System.out.println(contas[i]);
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("(Nenhuma conta com descoberto ativo)");
        }
    }
    
    /**
     * @return número de contas no banco
     */
    public int getNumeroContas() {
        return numeroContas;
    }
    
    /**
     * Realiza transferência entre contas do banco.
     * @param numeroOrigem número da conta origem
     * @param numeroDestino número da conta destino
     * @param valor valor a transferir
     * @throws ContaBancariaException se erro de negócio
     * @throws ContaInvalidaException se contas não encontradas
     */
    public void transferir(String numeroOrigem, String numeroDestino, double valor)
            throws ContaBancariaException {
        
        ContaBancaria origem = encontrarConta(numeroOrigem);
        ContaBancaria destino = encontrarConta(numeroDestino);
        
        if (origem == null) {
            throw new ContaInvalidaException("Conta origem não encontrada: " + numeroOrigem);
        }
        if (destino == null) {
            throw new ContaInvalidaException("Conta destino não encontrada: " + numeroDestino);
        }
        
        // Delega a transferência para a conta origem
        origem.transferir(destino, valor);
    }
}
