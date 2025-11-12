package pt.escnaval.exercicios;

/**
 * Repositório em memória usando array dinâmico para Aluno.
 */
public class AlunoRepo {
    private Aluno[] dados;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    public AlunoRepo() {
        this.dados = new Aluno[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    private void redimensionar() {
        Aluno[] novo = new Aluno[dados.length * 2];
        for (int i = 0; i < tamanho; i++) novo[i] = dados[i];
        dados = novo;
    }

    public boolean adicionar(Aluno a) {
        if (a == null) return false;
        if (findById(a.getId()) != null) return false; // id já existe
        if (tamanho == dados.length) redimensionar();
        dados[tamanho++] = a;
        return true;
    }

    public boolean removerPorId(int id) {
        int idx = -1;
        for (int i = 0; i < tamanho; i++) {
            if (dados[i].getId() == id) { idx = i; break; }
        }
        if (idx == -1) return false;
        for (int i = idx; i < tamanho - 1; i++) dados[i] = dados[i + 1];
        dados[--tamanho] = null; // ajuda GC
        return true;
    }

    public Aluno findById(int id) {
        for (int i = 0; i < tamanho; i++) if (dados[i].getId() == id) return dados[i];
        return null;
    }

    public void listarPorId() {
        Aluno[] copia = new Aluno[tamanho];
        for (int i = 0; i < tamanho; i++) copia[i] = dados[i];
        ordenarPorId(copia, tamanho);
        for (int i = 0; i < tamanho; i++) System.out.println(copia[i]);
    }

    public void listarPorNome() {
        Aluno[] copia = new Aluno[tamanho];
        for (int i = 0; i < tamanho; i++) copia[i] = dados[i];
        ordenarPorNome(copia, tamanho);
        for (int i = 0; i < tamanho; i++) System.out.println(copia[i]);
    }

    private void ordenarPorId(Aluno[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getId() > arr[j + 1].getId()) {
                    Aluno tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }

    private void ordenarPorNome(Aluno[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getNome().compareToIgnoreCase(arr[j + 1].getNome()) > 0) {
                    Aluno tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }

    public void buscarPorNome(String termo) {
        String t = (termo == null) ? "" : termo.toLowerCase().trim();
        boolean algum = false;
        for (int i = 0; i < tamanho; i++) {
            if (dados[i].getNome().toLowerCase().contains(t)) {
                System.out.println(dados[i]);
                algum = true;
            }
        }
        if (!algum) System.out.println("(nenhum resultado)");
    }

    // alias conforme variantes do enunciado
    public void buscarPorTermo(String termo) { buscarPorNome(termo); }
}
