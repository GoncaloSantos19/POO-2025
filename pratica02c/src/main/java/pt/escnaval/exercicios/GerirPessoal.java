package pt.escnaval.exercicios;

public class GerirPessoal {
    public static void main(String[] args) {
        Colaborador[] pessoal = new Colaborador[10];
        int count = 0;

        // a) criar gestor e adicionar ao array
        Gestor gestor = new Gestor("Ana Gestora", 40, 2000, 2020, 1, 15);
        pessoal[count++] = gestor;

        // b) criar mais dois colaboradores
        Colaborador c1 = new Colaborador("Bruno Colab", 30, 1200, 2021, 3, 10);
        Colaborador c2 = new Colaborador("Carla Colab", 28, 1100, 2022, 5, 20);
        gestor.aumentarEquipa(c1);
        gestor.aumentarEquipa(c2);

        // c) adicionar colaboradores ao array
        pessoal[count++] = c1;
        pessoal[count++] = c2;

        // d) mostrar informação completa
        System.out.println("--- Informação inicial ---");
        for (int i = 0; i < count; i++) {
            pessoal[i].mostrar();
            if (pessoal[i] instanceof Gestor) {
                System.out.println();
                ((Gestor)pessoal[i]).listarEquipa();
            }
            System.out.println();
        }

        // e) aumentar salários em 3%
        for (int i = 0; i < count; i++) {
            pessoal[i].aumentarSalario(3);
        }

        // f) mostrar informação após aumento
        System.out.println("--- Após aumento de 3% ---");
        for (int i = 0; i < count; i++) {
            pessoal[i].mostrar();
            if (pessoal[i] instanceof Gestor) {
                System.out.println();
                ((Gestor)pessoal[i]).listarEquipa();
            }
            System.out.println();
        }
    }
}
