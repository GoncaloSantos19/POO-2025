package pt.escnaval.exercicios.modelo;

import pt.escnaval.exercicios.exceptions.*;

/**
 * Conta Corrente — permite descoberto (saldo negativo até um limite).
 */
public class ContaCorrente extends ContaBancariaBase {
    
    private final double limiteDescoberto;
    
    /**
     * Cria uma conta corrente.
     * @param numero número da conta
     * @param titular titular
     * @param saldoInicial saldo inicial (>= 0)
     * @param limiteDescoberto limite de descoberto (>= 0)
     * @throws ContaInvalidaException se parâmetros inválidos
     */
    public ContaCorrente(String numero, String titular, double saldoInicial, double limiteDescoberto) {
        super(numero, titular, saldoInicial);
        if (limiteDescoberto < 0) {
            throw new ContaInvalidaException("Limite de descoberto não pode ser negativo: " + limiteDescoberto);
        }
        this.limiteDescoberto = limiteDescoberto;
    }
    
    public double getLimiteDescoberto() {
        return limiteDescoberto;
    }
    
    /**
     * Sobrescreve levantar para permitir descoberto.
     */
    @Override
    public void levantar(double valor) throws ContaBancariaException {
        validarValorPositivo(valor, "levantamento");
        
        // Verifica se pode levantar considerando o descoberto
        if (valor > saldo + limiteDescoberto) {
            throw new SaldoInsuficienteException(saldo + limiteDescoberto, valor);
        }
        
        saldo -= valor;
    }
    
    @Override
    public String getTipo() {
        return "Conta Corrente";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", Limite Descoberto: %.2f", limiteDescoberto);
    }
}
