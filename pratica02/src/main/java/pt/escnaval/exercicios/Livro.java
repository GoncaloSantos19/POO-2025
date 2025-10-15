package pt.escnaval.exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private int paginas;

    // Construtor completo
    public Livro(String titulo, String autor, int ano, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.paginas = paginas;
    }

    // Construtor apenas com título
    public Livro(String titulo) {
        this.titulo = titulo;
        this.autor = "";
        this.ano = 0;
        this.paginas = 0;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    // Método para mostrar os dados formatados
    public void mostrarDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano: " + ano);
        System.out.println("Páginas: " + paginas);
        System.out.println("----------------------");
    }

    // Programa principal para testar a classe
    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 1178);
        Livro livro2 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, 863);
        Livro livro3 = new Livro("Clean Code");
        livro3.setAutor("Robert C. Martin");
        livro3.setAno(2008);
        livro3.setPaginas(464);

        livro1.mostrarDados();
        livro2.mostrarDados();
        livro3.mostrarDados();
    }
}
