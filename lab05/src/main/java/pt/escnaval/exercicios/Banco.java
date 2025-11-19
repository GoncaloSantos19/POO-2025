package pt.escnaval.exercicios;

/**
 * Classe Banco — gerencia contas usando array.
 * Demonstra uso de arrays sem coleções.
 */
public class Banco {
    private Conta[] contas;
    private int numContas;

    public Banco() {
        this.contas = new Conta[10]; // capacidade inicial
        this.numContas = 0;
    }

    /**
     * Abre uma conta no banco.
     * @param conta conta a adicionar
     * @return true se sucesso
     */
    public boolean abrirConta(Conta conta) {
        if (conta == null || !conta.isValida()) return false;
        // Verificar se já existe
        if (findByIban(conta.getIban()) != null) return false;
        // Expandir array se necessário
        if (numContas == contas.length) {
            expandir();
        }
        contas[numContas++] = conta;
        return true;
    }

    /**
     * Fecha uma conta pelo IBAN.
     * @param iban IBAN da conta
     * @return true se sucesso
     */
    public boolean fecharConta(Iban iban) {
        if (iban == null) return false;
        int index = encontrarIndice(iban);
        if (index == -1) return false;
        // Remover: deslocar elementos
        for (int i = index; i < numContas - 1; i++) {
            contas[i] = contas[i + 1];
        }
        contas[--numContas] = null;
        return true;
    }

    /**
     * Busca conta por IBAN.
     * @param iban IBAN da conta
     * @return conta encontrada ou null
     */
    public Conta findByIban(Iban iban) {
        if (iban == null) return null;
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getIban().equals(iban)) {
                return contas[i];
            }
        }
        return null;
    }

    /**
     * Lista todas as contas.
     * @return array com cópia das contas (tamanho exato)
     */
    public Conta[] listarContas() {
        Conta[] resultado = new Conta[numContas];
        for (int i = 0; i < numContas; i++) {
            resultado[i] = contas[i];
        }
        return resultado;
    }

    public int getNumContas() {
        return numContas;
    }

    private int encontrarIndice(Iban iban) {
        for (int i = 0; i < numContas; i++) {
            if (contas[i].getIban().equals(iban)) {
                return i;
            }
        }
        return -1;
    }

    private void expandir() {
        Conta[] novoArray = new Conta[contas.length * 2];
        for (int i = 0; i < contas.length; i++) {
            novoArray[i] = contas[i];
        }
        contas = novoArray;
    }
}
