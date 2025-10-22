package pt.escnaval.exercicios;

public class Conta {
    private int id;
    private Cliente cliente;
    private Endereco endereco;
    private Endereco antigoEndereco;
    private double saldo;

    public Conta(int aId, Cliente aCliente, double aSaldo, Endereco aEndereco) {
        id = aId;
        cliente = aCliente;
        saldo = aSaldo;
        endereco = aEndereco;
    }

    public Conta(int aId, Cliente aCliente) {
        this(aId, aCliente, 0, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        if (cliente != null) return cliente;
        else return null;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo > 0) this.saldo = saldo;
    }

    public Conta deposito(double valor) {
        if (valor > 0) saldo += valor;
        return this;
    }

    public void levantar(double valor) {
        if (valor <= saldo) saldo -= valor;
        else System.out.println("Valor a levantar excede o corrente saldo");
    }

    public String getClienteNome() {
        if (cliente != null) return cliente.getNome();
        else return "";
    }

    public void mostrar() {
        System.out.println("Nome(" + cliente.getNome() + ") Saldo=" + saldo);
    }

    public void mostrarEndereco() {
        if (endereco != null)
            System.out.println(endereco.mostrar());
        else
            System.out.println("Sem endereço associado.");
    }

    public void atualizarEndereco(Endereco aEndereco) {
        if (endereco != null) {
            antigoEndereco = endereco;
            endereco = aEndereco;
        }
    }
}
