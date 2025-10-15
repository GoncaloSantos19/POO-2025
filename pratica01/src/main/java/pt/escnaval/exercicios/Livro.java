package pt.escnaval.exercicios;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponibilidade;

    // Construtor com todos os atributos
    public Livro(String titulo, String autor, int anoPublicacao, String genero, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = disponibilidade;
    }

    // Construtor sobrecarregado com título e autor
    public Livro(String titulo, String autor) {
        this(titulo, autor, 0, "Não especificado", false);
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public boolean isDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    // Método para formatar a saída das informações do livro
    public String formatarInformacoes() {
        return "Livro:\nTítulo: " + titulo + "\nAutor: " + autor + "\nAno de Publicação: " + anoPublicacao + "\nGênero: " + genero + "\nDisponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }
}
