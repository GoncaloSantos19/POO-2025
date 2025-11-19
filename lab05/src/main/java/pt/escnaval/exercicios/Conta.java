package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Objects;

/**
 * Classe Conta — classe base para contas bancárias.
 * Identidade baseada em IBAN.
 * Campo saldo é protected para permitir acesso em subclasses.
 */
public class Conta {
    private final Iban iban;
    private final Cliente titular;
    protected double saldo; // protected para subclasses
    private final boolean valida;

    public Conta(Iban iban, Cliente titular, double saldoInicial) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.valida = validar();
    }

    private boolean validar() {
        return iban != null && iban.isValid() &&
               titular != null && titular.isValido() &&
               saldo >= 0;
    }

    public boolean isValida() {
        return valida;
    }

    public Iban getIban() {
        return iban;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Deposita valor na conta.
     * @param valor valor a depositar
     * @return true se sucesso
     */
    public boolean depositar(double valor) {
        if (!valida || valor <= 0) return false;
        saldo += valor;
        return true;
    }

    /**
     * Levanta valor da conta.
     * @param valor valor a levantar
     * @return true se sucesso
     */
    public boolean levantar(double valor) {
        if (!valida || valor <= 0 || valor > saldo) return false;
        saldo -= valor;
        return true;
    }

    /**
     * Transfere valor para outra conta.
     * @param destino conta destino
     * @param valor valor a transferir
     * @return true se sucesso
     */
    public boolean transferirPara(Conta destino, double valor) {
        if (destino == null || !destino.isValida()) return false;
        if (!this.levantar(valor)) return false;
        if (!destino.depositar(valor)) {
            // Reverter se falhar
            this.depositar(valor);
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Conta)) return false;
        Conta outra = (Conta) obj;
        return Objects.equals(iban, outra.iban); // identidade por IBAN
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban); // apenas IBAN
    }

    @Override
    public String toString() {
        if (!valida) return "[Conta inválida]";
        return String.format(Locale.US, "Conta %s\t%-18s saldo=%.2f",
                iban, titular.getNome(), saldo);
    }
}
