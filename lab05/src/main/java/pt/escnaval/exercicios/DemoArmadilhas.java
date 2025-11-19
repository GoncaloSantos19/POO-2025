package pt.escnaval.exercicios;

public class DemoArmadilhas {
    public static void main(String[] args) {
        System.out.println("=== Demonstração: Armadilhas Comuns ===\n");

        Endereco end = new Endereco("Rua A", "Lisboa", "1000");
        Cliente c1 = new Cliente(1, "Ana", "ana@x.com", end, "pass");
        Iban iban1 = new Iban("PT50000000000000000000001");

        // 1. Usar == em vez de equals
        System.out.println("--- 1. == vs equals ---");
        Endereco e1 = new Endereco("Rua A", "Lisboa", "1000");
        Endereco e2 = new Endereco("Rua A", "Lisboa", "1000");
        System.out.println("e1 == e2: " + (e1 == e2) + " (compara referências)");
        System.out.println("e1.equals(e2): " + e1.equals(e2) + " (compara conteúdo)");

        // 2. Não validar objetos antes de usar
        System.out.println("\n--- 2. Validação de objetos ---");
        Cliente c_invalido = new Cliente(0, "", "x", end, "");
        System.out.println("Cliente inválido criado, isValido()? " + c_invalido.isValido());
        System.out.println("Sempre verificar isValido() antes de usar!");

        // 3. Esquecer protected em saldo (para herança)
        System.out.println("\n--- 3. Visibilidade protected ---");
        System.out.println("Campo saldo em Conta é protected para acesso em subclasses");
        System.out.println("ContaOrdem e ContaPoupanca podem acessar diretamente");

        // 4. Casting sem instanceof
        System.out.println("\n--- 4. Casting seguro ---");
        Conta conta = new Conta(iban1, c1, 100.0);
        System.out.println("conta instanceof ContaOrdem? " + (conta instanceof ContaOrdem));
        System.out.println("Sempre usar instanceof antes de casting!");

        // 5. Confundir composição com herança
        System.out.println("\n--- 5. Composição vs Herança ---");
        System.out.println("Cliente TEM-UM Endereco -> composição (campo)");
        System.out.println("ContaOrdem É-UMA Conta -> herança (extends)");
        System.out.println("Use herança apenas para relação É-UM legítima!");

        // 6. Modificar objetos imutáveis
        System.out.println("\n--- 6. Imutabilidade ---");
        System.out.println("Endereco e IBAN são imutáveis (final fields)");
        System.out.println("Cliente tem id final mas email mutável (com validação)");

        // 7. Não implementar equals/hashCode corretamente
        System.out.println("\n--- 7. equals e hashCode ---");
        Cliente c2 = new Cliente(1, "Outro Nome", "outro@x.com", end, "x");
        System.out.println("c1.equals(c2)? " + c1.equals(c2) + " (mesmo id)");
        System.out.println("c1.hashCode() == c2.hashCode()? " + (c1.hashCode() == c2.hashCode()));
        System.out.println("Objetos iguais devem ter mesmo hashCode!");

        System.out.println("\n--- Resumo ---");
        System.out.println("✓ Use equals(), não ==, para comparar conteúdo");
        System.out.println("✓ Sempre valide objetos antes de usar");
        System.out.println("✓ Use instanceof antes de casting");
        System.out.println("✓ Composição para TEM-UM, herança para É-UM");
        System.out.println("✓ equals() e hashCode() devem ser consistentes");
    }
}
