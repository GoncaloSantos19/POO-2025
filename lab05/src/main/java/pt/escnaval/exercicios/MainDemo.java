package pt.escnaval.exercicios;

public class MainDemo {
    public static void main(String[] args) {
        System.out.println("=== Lab 05: Demo Principal ===\n");

        // 1. Testar Endereco
        System.out.println("--- 1. Endereços ---");
        Endereco end1 = new Endereco("Rua das Flores", "Lisboa", "1000-100");
        Endereco end2 = new Endereco("", "Porto", "4000-100");
        System.out.println("Endereco 1 válido? " + end1.isValido() + " -> " + end1);
        System.out.println("Endereco 2 válido? " + end2.isValido() + " -> " + end2);

        // 2. Testar Cliente
        System.out.println("\n--- 2. Clientes ---");
        Cliente c1 = new Cliente(1, "Ana Silva", "ana@example.com", end1, "senha123");
        Cliente c2 = new Cliente(0, "Inválido", "x@", end1, "pass");
        System.out.println("Cliente 1 válido? " + c1.isValido() + " -> " + c1);
        System.out.println("Cliente 2 válido? " + c2.isValido() + " -> " + c2);

        // 3. Testar IBAN
        System.out.println("\n--- 3. IBANs ---");
        Iban iban1 = new Iban("PT50000000000000000000001");
        Iban iban2 = new Iban("PT1");
        System.out.println("IBAN 1 válido? " + iban1.isValid() + " -> " + iban1);
        System.out.println("IBAN 2 válido? " + iban2.isValid() + " -> " + iban2);

        // 4. Testar Conta
        System.out.println("\n--- 4. Contas ---");
        Conta conta1 = new Conta(iban1, c1, 100.0);
        System.out.println("Conta criada: " + conta1);
        System.out.println("Depositar 50: " + conta1.depositar(50.0) + " -> saldo: " + conta1.getSaldo());
        System.out.println("Levantar 30: " + conta1.levantar(30.0) + " -> saldo: " + conta1.getSaldo());
        System.out.println("Levantar 200 (falha): " + conta1.levantar(200.0) + " -> saldo: " + conta1.getSaldo());

        // 5. Testar Banco
        System.out.println("\n--- 5. Banco ---");
        Banco banco = new Banco();
        System.out.println("Abrir conta1: " + banco.abrirConta(conta1));
        System.out.println("Número de contas: " + banco.getNumContas());
        System.out.println("Abrir conta1 novamente (falha): " + banco.abrirConta(conta1));
        System.out.println("Buscar conta: " + banco.findByIban(iban1));
        System.out.println("Fechar conta: " + banco.fecharConta(iban1));
        System.out.println("Número de contas após fechar: " + banco.getNumContas());

        System.out.println("\n=== Fim da Demo ===");
    }
}
