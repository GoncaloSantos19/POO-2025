package pt.escnaval.exercicios;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de horas trabalhadas");

        // Entrada de horários
        System.out.println("Digite a hora e minuto da entrada da manhã:");
        int entradaManhaHora = sc.nextInt();
        int entradaManhaMinuto = sc.nextInt();

        System.out.println("Digite a hora e minuto da saída para almoço:");
        int saidaAlmocoHora = sc.nextInt();
        int saidaAlmocoMinuto = sc.nextInt();

        System.out.println("Digite a hora e minuto da entrada depois do almoço:");
        int entradaTardeHora = sc.nextInt();
        int entradaTardeMinuto = sc.nextInt();

        System.out.println("Digite a hora e minuto da saída no final do dia:");
        int saidaTardeHora = sc.nextInt();
        int saidaTardeMinuto = sc.nextInt();

        // Conversão para minutos desde meia-noite
        int minutosManha = (saidaAlmocoHora * 60 + saidaAlmocoMinuto) - (entradaManhaHora * 60 + entradaManhaMinuto);
        int minutosTarde = (saidaTardeHora * 60 + saidaTardeMinuto) - (entradaTardeHora * 60 + entradaTardeMinuto);

        int totalMinutos = minutosManha + minutosTarde;

        int horasTrabalhadas = totalMinutos / 60;
        int minutosTrabalhados = totalMinutos % 60;

        System.out.println("Total de horas trabalhadas: " + horasTrabalhadas + " horas e " + minutosTrabalhados + " minutos.");

        sc.close();
    }
}
