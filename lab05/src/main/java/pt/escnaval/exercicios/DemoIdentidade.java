package pt.escnaval.exercicios;

public class DemoIdentidade {
    public static void main(String[] args) {
        System.out.println("=== Demonstração: Identidade vs. Valor ===\n");

        // 1. Endereco: valor (equals por todas as propriedades)
        System.out.println("--- 1. Endereco (valor) ---");
        Endereco e1 = new Endereco("Rua A", "Lisboa", "1000");
        Endereco e2 = new Endereco("Rua A", "Lisboa", "1000");
        Endereco e3 = new Endereco("Rua B", "Lisboa", "1000");
        System.out.println("e1 == e2? " + (e1 == e2) + " (diferentes objetos)");
        System.out.println("e1.equals(e2)? " + e1.equals(e2) + " (mesmo conteúdo)");
        System.out.println("e1.equals(e3)? " + e1.equals(e3) + " (conteúdo diferente)");

        // 2. Cliente: identidade por id
        System.out.println("\n--- 2. Cliente (identidade por id) ---");
        Cliente c1 = new Cliente(1, "Ana", "ana@x.com", e1, "pass");
        Cliente c2 = new Cliente(1, "Ana Silva", "outro@x.com", e2, "diff");
        Cliente c3 = new Cliente(2, "Ana", "ana@x.com", e1, "pass");
        System.out.println("c1.equals(c2)? " + c1.equals(c2) + " (mesmo id, dados diferentes)");
        System.out.println("c1.equals(c3)? " + c1.equals(c3) + " (id diferente, dados iguais)");

        // 3. IBAN: valor (equals por codigo)
        System.out.println("\n--- 3. IBAN (valor) ---");
        Iban iban1 = new Iban("PT50000000000000000000001");
        Iban iban2 = new Iban("PT50000000000000000000001");
        Iban iban3 = new Iban("PT50000000000000000000002");
        System.out.println("iban1.equals(iban2)? " + iban1.equals(iban2) + " (mesmo código)");
        System.out.println("iban1.equals(iban3)? " + iban1.equals(iban3) + " (código diferente)");

        // 4. Conta: identidade por IBAN
        System.out.println("\n--- 4. Conta (identidade por IBAN) ---");
        Conta a1 = new Conta(iban1, c1, 100.0);
        Conta a2 = new Conta(iban1, c3, 999.0); // mesmo IBAN, titular e saldo diferentes
        Conta a3 = new Conta(iban3, c1, 100.0);
        System.out.println("a1.equals(a2)? " + a1.equals(a2) + " (mesmo IBAN, dados diferentes)");
        System.out.println("a1.equals(a3)? " + a1.equals(a3) + " (IBAN diferente, dados iguais)");

        // 5. hashCode consistente com equals
        System.out.println("\n--- 5. hashCode consistente ---");
        System.out.println("e1.hashCode() == e2.hashCode()? " + (e1.hashCode() == e2.hashCode()));
        System.out.println("c1.hashCode() == c2.hashCode()? " + (c1.hashCode() == c2.hashCode()));
        System.out.println("iban1.hashCode() == iban2.hashCode()? " + (iban1.hashCode() == iban2.hashCode()));
        System.out.println("a1.hashCode() == a2.hashCode()? " + (a1.hashCode() == a2.hashCode()));

        System.out.println("\n--- Resumo ---");
        System.out.println("✓ Valor: equals compara conteúdo (Endereco, IBAN)");
        System.out.println("✓ Identidade: equals compara chave estável (Cliente.id, Conta.iban)");
        System.out.println("✓ hashCode deve ser consistente com equals");
    }
}
