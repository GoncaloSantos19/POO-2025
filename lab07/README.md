# Lab 07 — Utilização de Coleções e Ficheiros (Leitura e Escrita)

Unidade Curricular: Programação Orientada aos Objetos — Java

Modalidade: Laboratório em computador pessoal

Duração sugerida: 120 min

## Objetivos de aprendizagem

Ao concluir este laboratório, será capaz de:

- Usar coleções `ArrayList<T>` para gerir uma coleção de objetos (Album, Faixa)
- Implementar repositório simples em ficheiro texto (CSV) para persistência e carregamento
- Realizar operações de leitura/escrita binária com `InputStream`/`OutputStream` (ex.: copiar ficheiros .mp3)
- Projetar modelos simples (Album, Faixa) e serviços de negócio (Mediateca)
- Implementar um CLI (menu) que integra operações de coleção e I/O com tratamento de Exceções
- Aplicar boas práticas: try-with-resources, separação de responsabilidades e validações básicas

## Versões de ferramentas

- **JDK:** 17.0.x (ou superior)
- **javac:** 17.0.x
- **java:** 17.0.x

## Estrutura de ficheiros

```
lab07/
├─ src/
│  └─ main/
│     └─ java/
│        └─ pt/
│           └─ escnaval/
│              └─ exercicios/
│                 └─ mediateca/
│                    ├─ modelo/
│                    │  ├─ Album.java
│                    │  └─ Faixa.java
│                    ├─ servicos/
│                    │  ├─ Mediateca.java
│                    │  ├─ RepositorioTexto.java
│                    │  └─ Mp3Util.java
│                    ├─ utils/
│                    │  └─ UtilsIO.java
│                    ├─ AppMediateca.java
│                    └─ MenuMediateca.java
├─ data/           # ficheiro CSV persistente (ex: mediateca.csv)
├─ media/          # ficheiros mp3 (opcional)
├─ README.md
└─ .gitignore
```

## Compilar

```cmd
cd lab07
javac -encoding UTF-8 -d out src\main\java\pt\escnaval\exercicios\mediateca\modelo\*.java src\main\java\pt\escnaval\exercicios\mediateca\servicos\*.java src\main\java\pt\escnaval\exercicios\mediateca\utils\*.java src\main\java\pt\escnaval\exercicios\mediateca\*.java
```

## Executar

```cmd
java -cp out pt.escnaval.exercicios.mediateca.MenuMediateca
```

## Conceitos Fundamentais

### ArrayList<T>
- Coleção dinâmica (tamanho ajustável)
- Acesso por índice O(1)
- Métodos: `add()`, `remove()`, `get()`, `size()`, `contains()`

### Persistência em CSV
- Formato: `id;titulo;autor;faixa1|dur1|path1,faixa2|dur2|path2`
- Separadores: `;` (campos), `,` (faixas), `|` (dados faixa)
- Encoding: UTF-8

### I/O Binário
- `InputStream`/`OutputStream` para bytes
- `BufferedInputStream`/`BufferedOutputStream` para performance
- Útil para copiar ficheiros .mp3, imagens, etc.

### Try-with-resources
Garante fecho automático de recursos:
```java
try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    // usar br
} // fecha automaticamente
```

## Biblioteca Java utilizada

- **java.util.ArrayList, List** — coleção em memória
- **java.nio.file.Files, Path** — APIs de ficheiros modernas
- **java.io.InputStream, OutputStream** — I/O binário
- **java.io.BufferedReader, BufferedWriter** — I/O texto com buffer
- **java.nio.charset.StandardCharsets** — UTF-8
- **java.util.Scanner** — input CLI

## Formato CSV

Exemplo de linha no ficheiro `mediateca.csv`:
```
ALB001;Dark Side of the Moon;Pink Floyd;Speak to Me|90|media/track01.mp3,Breathe|163|media/track02.mp3
ALB002;Abbey Road;The Beatles;Come Together|259|media/track03.mp3,Something|182|media/track04.mp3
```

## Menu da Aplicação

1. Listar álbuns
2. Adicionar álbum
3. Adicionar faixa a álbum
4. Remover álbum
5. Procurar por autor
6. Copiar ficheiro mp3 para media/
7. Guardar alterações (salvar CSV)
8. Sair

## Tabela de Testes

| # | Caso | Entrada/Passos | Resultado Esperado |
|---|------|----------------|-------------------|
| 1 | Adicionar álbum | 2 → ALB001, Dark Side, Pink Floyd | Álbum criado |
| 2 | Adicionar faixa | 3 → ALB001, 1, Speak to Me, 90 | Faixa adicionada |
| 3 | Listar álbuns | 1 | Mostra álbuns cadastrados |
| 4 | Procurar por autor | 5 → Pink Floyd | Lista álbuns do autor |
| 5 | Guardar CSV | 7 | Ficheiro data/mediateca.csv criado |
| 6 | Carregar ao iniciar | Reiniciar app | Dados carregados do CSV |
| 7 | Remover álbum | 4 → ALB001 | Álbum removido |
| 8 | Copiar mp3 | 6 → source.mp3, track01.mp3 | Ficheiro copiado para media/ |

## Boas Práticas

✓ **Try-with-resources** para fechar recursos automaticamente  
✓ **Separação de responsabilidades** (modelo, serviços, UI)  
✓ **Validações** em construtores e métodos  
✓ **UTF-8** explícito em I/O de texto  
✓ **Buffer** para I/O eficiente (8KB)  
✓ **Tratamento de IOException** apropriado  

## .gitignore

Ficheiros ignorados:
- `out/`, `bin/`, `target/`, `build/`
- `*.class`, `*.log`
- `.vscode/`, `.idea/`
- Opcional: `data/`, `media/` (se não quiser versionar dados)

## Workflow Git sugerido

```cmd
git add lab07
git commit -m "Adiciona lab07: coleções e ficheiros (CSV + binário)"
git push
```
