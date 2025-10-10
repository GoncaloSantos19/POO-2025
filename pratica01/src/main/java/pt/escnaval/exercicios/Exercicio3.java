package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 3: Cálculo de Empréstimo ===");

        // Ler dados de entrada
        System.out.print("Valor do empréstimo (€): ");
        double valorEmprestimo = sc.nextDouble();

        System.out.print("Duração (em anos): ");
        int duracaoAnos = sc.nextInt();

        System.out.print("Taxa de juro anual (entre 0 e 1): ");
        double taxaJuro = sc.nextDouble();

        // Converter anos para meses
        int numMeses = duracaoAnos * 12;

        // Calcular juro mensal e base mensal
        double juroMes = taxaJuro / 12.0;
        double baseMes = 1.0 + juroMes;

        // Calcular mensalidade
        double mensalidade = (juroMes * Math.pow(baseMes, numMeses) * valorEmprestimo) /
                             (Math.pow(baseMes, numMeses) - 1);

        // Calcular total a pagar
        double totalAPagar = mensalidade * numMeses;

        // Mostrar resultados
        System.out.printf("Mensalidade: %.2f €%n", mensalidade);
        System.out.printf("Total a pagar: %.2f €%n", totalAPagar);

        sc.close();
    }
}
