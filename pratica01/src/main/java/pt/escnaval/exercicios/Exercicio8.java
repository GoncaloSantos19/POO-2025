package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 8: Cálculo de Desconto em Encomendas ===");

        // Ler número de peças e preço unitário
        System.out.print("Introduza o número de peças encomendadas: ");
        int numPecas = sc.nextInt();

        System.out.print("Introduza o preço unitário (€): ");
        double precoUnitario = sc.nextDouble();

        // Calcular valor total bruto
        double valorEncomenda = numPecas * precoUnitario;
        double desconto = 0.0;

        // Determinar o desconto com base na tabela
        if (valorEncomenda < 2000) {
            desconto = 0.02;
        } else if (valorEncomenda < 5000) {
            desconto = 0.04;
        } else {
            desconto = 0.075;
        }

        // Calcular valor final após desconto
        double valorFinal = valorEncomenda * (1 - desconto);

        // Mostrar resultados
        System.out.printf("Valor da encomenda: %.2f €%n", valorEncomenda);
        System.out.printf("Desconto aplicado: %.1f%%%n", desconto * 100);
        System.out.printf("Valor a pagar: %.2f €%n", valorFinal);

        sc.close();
    }
}
