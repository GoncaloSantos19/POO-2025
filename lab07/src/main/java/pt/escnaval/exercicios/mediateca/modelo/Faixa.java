package pt.escnaval.exercicios.mediateca.modelo;

import java.util.Objects;

/**
 * Representa uma faixa musical.
 * Contém número, título, duração em segundos e caminho opcional para ficheiro mp3.
 */
public class Faixa {
    private final int numero;
    private final String titulo;
    private final int duracaoSegundos;
    private String ficheiroMp3Path; // relativo (ex: media/..)

    /**
     * Construtor sem caminho de ficheiro mp3.
     */
    public Faixa(int numero, String titulo, int duracaoSegundos) {
        this.numero = numero;
        this.titulo = Objects.requireNonNull(titulo);
        this.duracaoSegundos = duracaoSegundos;
    }

    /**
     * Construtor completo.
     */
    public Faixa(int numero, String titulo, int duracaoSegundos, String ficheiroMp3Path) {
        this.numero = numero;
        this.titulo = Objects.requireNonNull(titulo);
        this.duracaoSegundos = duracaoSegundos;
        this.ficheiroMp3Path = ficheiroMp3Path;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getFicheiroMp3Path() {
        return ficheiroMp3Path;
    }

    public void setFicheiroMp3Path(String p) {
        this.ficheiroMp3Path = p;
    }

    @Override
    public String toString() {
        return String.format("%02d. %s (%ds) %s", numero, titulo, duracaoSegundos,
                ficheiroMp3Path == null ? "" : "[" + ficheiroMp3Path + "]");
    }
}
