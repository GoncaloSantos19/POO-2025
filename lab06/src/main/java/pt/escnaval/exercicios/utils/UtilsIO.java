package pt.escnaval.exercicios.utils;

import java.util.Scanner;

/**
 * Utilitários de I/O — entrada robusta do terminal.
 * Sempre usar nextLine() + parse para evitar problemas com Scanner.
 */
public class UtilsIO {
    
    /**
     * Lê uma opção de menu (inteiro) com tratamento de exceções.
     * @param sc scanner
     * @param min valor mínimo válido
     * @param max valor máximo válido
     * @return opção lida
     */
    public static int lerOpcao(Scanner sc, int min, int max) {
        while (true) {
            try {
                String input = sc.nextLine().trim();
                int opcao = Integer.parseInt(input);
                if (opcao >= min && opcao <= max) {
                    return opcao;
                }
                System.out.printf("❌ Opção inválida. Escolha entre %d e %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("❌ Entrada inválida. Digite um número: ");
            }
        }
    }
    
    /**
     * Lê um número decimal com tratamento de exceções.
     * @param sc scanner
     * @param prompt mensagem a exibir
     * @return número lido
     */
    public static double lerDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Digite um número decimal.");
            }
        }
    }
    
    /**
     * Lê um número inteiro com tratamento de exceções.
     * @param sc scanner
     * @param prompt mensagem a exibir
     * @return número lido
     */
    public static int lerInt(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Digite um número inteiro.");
            }
        }
    }
    
    /**
     * Lê uma string não vazia.
     * @param sc scanner
     * @param prompt mensagem a exibir
     * @return string lida (não vazia)
     */
    public static String lerStringNaoVazia(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("❌ Entrada não pode ser vazia.");
        }
    }
}
