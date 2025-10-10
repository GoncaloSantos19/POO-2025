package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 6: Conversão de Temperaturas ===");

        // Ler a temperatura
        System.out.print("Introduza a temperatura: ");
        double temperatura = sc.nextDouble();

        // Ler o tipo de temperatura
        System.out.print("Introduza o tipo ('C' para Celsius ou 'F' para Fahrenheit): ");
        char tipo = sc.next().toUpperCase().charAt(0); // converte para maiúscula

        // Conversão com base no tipo
        if (tipo == 'C') {
            double fahrenheit = 1.8 * temperatura + 32;
            System.out.printf("%.2fº Celsius é equivalente a %.2fº Fahrenheit%n", temperatura, fahrenheit);
        } else if (tipo == 'F') {
            double celsius = (temperatura - 32) / 1.8;
            System.out.printf("%.2fº Fahrenheit é equivalente a %.2fº Celsius%n", temperatura, celsius);
        } else {
            System.out.println("Tipo inválido! Use 'C' ou 'F'.");
        }

        sc.close();
    }
}
