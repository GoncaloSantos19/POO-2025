package pt.escnaval.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Distância em milhas: ");
            double milhas = sc.nextDouble();
            double km = milhas * 1.609;
            System.out.printf("%.3f milhas = %.3f km%n", milhas, km);
        }
    }
}
