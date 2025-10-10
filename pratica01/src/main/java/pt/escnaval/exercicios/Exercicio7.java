package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 7: Cálculo da Nota Final ===");

        // Ler as notas
        System.out.print("Introduza a nota da Avaliação Periódica (0 a 20): ");
        double notaPeriodica = sc.nextDouble();

        System.out.print("Introduza a nota da Avaliação Final (0 a 20): ");
        double notaFinal = sc.nextDouble();

        // Calcular média ponderada
        double media = (0.3 * notaPeriodica) + (0.7 * notaFinal);

        // Mostrar resultado
        System.out.printf("Nota final: %.2f valores", media);

        // Verificar se alguma das notas é inferior a 6
        if (notaPeriodica < 6 || notaFinal < 6) {
            System.out.println(" — Reprovado por uma das notas ser inferior à mínima.");
        } else {
            System.out.println();
        }

        sc.close();
    }
}
