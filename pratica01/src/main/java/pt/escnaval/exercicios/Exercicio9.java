package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 9: Estatísticas de Produção ===");
        System.out.println("Introduza o nº de peças produzidas por dia (-1 para terminar):");

        int producao;
        int totalPecas = 0;
        int dias = 0;
        int diasAbaixo250 = 0;

        // Leitura dos valores até o utilizador introduzir -1
        while (true) {
            System.out.print("Dia " + (dias + 1) + ": ");
            producao = sc.nextInt();

            if (producao == -1) {
                break; // termina a leitura
            }

            // Atualiza os contadores
            totalPecas += producao;
            dias++;

            if (producao < 250) {
                diasAbaixo250++;
            }
        }

        System.out.println("\n=== Resultados Estatísticos ===");
        if (dias > 0) {
            double media = (double) totalPecas / dias;

            System.out.println("a) Total de peças produzidas: " + totalPecas);
            System.out.printf("b) Média de peças por dia: %.2f%n", media);
            System.out.println("c) Nº de dias com produção inferior a 250 peças: " + diasAbaixo250);
        } else {
            System.out.println("Nenhum dado introduzido.");
        }

        sc.close();
    }
}
