package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 2: Conversor de Dólares para Euros ===");

        // 1. Ler valor em dólares
        System.out.print("Introduza o valor em dólares ($): ");
        double dolares = sc.nextDouble();

        // 2. Converter para euros (1€ = 1.2$ → € = $ / 1.2)
        double euros = dolares / 1.2;

        // 3. Subtrair comissão fixa de 2 €
        double eurosLiquidos = euros - 2;

        // 4. Mostrar resultado formatado
        System.out.printf("Valor convertido: %.2f € (após comissão de 2€)%n", eurosLiquidos);

        sc.close();
    }
}
