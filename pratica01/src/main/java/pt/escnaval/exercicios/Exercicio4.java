package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercício 4: Conversão de segundos em hh:mm:ss ===");

        // Ler o valor em segundos
        System.out.print("Introduza o tempo em segundos: ");
        int totalSegundos = sc.nextInt();

        // Calcular horas, minutos e segundos
        int horas = totalSegundos / 3600;              // 1 hora = 3600 segundos
        int resto = totalSegundos % 3600;              // resto após remover as horas
        int minutos = resto / 60;                      // 1 minuto = 60 segundos
        int segundos = resto % 60;                     // resto final são os segundos

        // Mostrar resultado no formato hh:mm:ss
        System.out.printf("Tempo equivalente: %02d:%02d:%02d%n", horas, minutos, segundos);

        sc.close();
    }
}
