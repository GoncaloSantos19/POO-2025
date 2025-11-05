package pt.escnaval.exercicios;
import java.util.ArrayList;

public class Gestor extends Colaborador {
    private double bonus;
    private ArrayList<Colaborador> equipa;

    public Gestor(String nome, int idade, double salario, int ano, int mes, int dia) {
        super(nome, idade, salario, ano, mes, dia);
        this.bonus = 0;
        this.equipa = new ArrayList<>();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalario() {
        return super.getSalario() + bonus;
    }

    public void aumentarEquipa(Colaborador c) {
        if (c != null && !equipa.contains(c)) {
            equipa.add(c);
        }
    }

    public void listarEquipa() {
        System.out.println("Equipa do gestor " + getNome() + ":");
        if (equipa.isEmpty()) {
            System.out.println("(sem membros)");
        } else {
            for (Colaborador c : equipa) {
                c.mostrar();
                System.out.println();
            }
        }
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.printf(", Bónus: %.2f", bonus);
    }
}
