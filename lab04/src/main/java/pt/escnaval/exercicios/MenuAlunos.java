package pt.escnaval.exercicios;

import java.util.Scanner;

public class MenuAlunos {
    private static final AlunoRepo repo = new AlunoRepo();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            mostrarMenu();
            System.out.print("Opção (0..6) → ");
            opc = UtilsIO.lerOpcao(sc, 0, 6);
            switch (opc) {
                case 1 -> adicionarFluxo(sc);
                case 2 -> repo.listarPorId();
                case 3 -> repo.listarPorNome();
                case 4 -> removerFluxo(sc);
                case 5 -> buscarFluxo(sc);
                case 6 -> renomearFluxo(sc);
                case 0 -> System.out.println("Adeus!");
                default -> System.out.println("Opção inválida");
            }
            System.out.println();
        } while (opc != 0);
        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n=== Menu Alunos ===");
        System.out.println("1) Adicionar aluno");
        System.out.println("2) Listar por ID");
        System.out.println("3) Listar por Nome");
        System.out.println("4) Remover por ID");
        System.out.println("5) Buscar por Nome");
        System.out.println("6) Renomear por ID");
        System.out.println("0) Sair");
    }

    static void adicionarFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID? ");
        System.out.print("Nome? ");
        String nome = sc.nextLine();
        try {
            Aluno a = new Aluno(id, nome);
            boolean ok = repo.adicionar(a);
            System.out.println(ok ? "[OK] Adicionado." : "[X] Falhou (ID já existe).");
        } catch (IllegalArgumentException ex) {
            System.out.println("[X] Dados inválidos: " + ex.getMessage());
        }
    }

    static void removerFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID a remover? ");
        System.out.println(repo.removerPorId(id) ? "[OK] Removido." : "[X] ID inexistente.");
    }

    static void buscarFluxo(Scanner sc) {
        System.out.print("Termo de busca (nome): ");
        String termo = sc.nextLine();
        repo.buscarPorNome(termo);
    }

    static void renomearFluxo(Scanner sc) {
        int id = UtilsIO.lerInt(sc, "ID a renomear? ");
        Aluno a = repo.findById(id);
        if (a == null) { System.out.println("[X] ID inexistente."); return; }
        System.out.print("Novo nome: ");
        String novo = sc.nextLine();
        try {
            a.setNome(novo);
            System.out.println("[OK] Renomeado.");
        } catch (IllegalArgumentException ex) {
            System.out.println("[X] Nome inválido: " + ex.getMessage());
        }
    }
}
