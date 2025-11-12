git commit -m "Adiciona lab04: menu CLI + CRUD"
git push
# Lab 04 — Objetos de Domínio, Encapsulamento e Repositórios em Memória

Unidade Curricular: Programação Orientada aos Objetos — Java

Modalidade: Laboratório em computador pessoal

Duração sugerida: 2h

Objetivo

Este laboratório introduz conceitos de objetos de domínio, encapsulamento, invariantes e repositórios em memória.

Estrutura de ficheiros

- `src/main/java/pt/escnaval/exercicios/UtilsIO.java` — utilitários de I/O e validação
- `src/main/java/pt/escnaval/exercicios/Aluno.java` — classe de domínio Aluno
- `src/main/java/pt/escnaval/exercicios/AlunoRepo.java` — repositório em memória (CRUD)
- `src/main/java/pt/escnaval/exercicios/MenuAlunos.java` — programa principal com menu CLI

Preparação do ambiente

1. Confirmar JDK instalado:

```cmd
javac -version
java -version
```

2. Compilar (Windows PowerShell):

```powershell
Get-ChildItem -Recurse src -Filter *.java | % { $_.FullName } | % { & javac -d out $_ }
```

3. Executar:

```powershell
java -cp out pt.escnaval.exercicios.MenuAlunos
```

Compilação (cmd.exe):

```cmd
javac -d out src\main\java\pt\escnaval\exercicios\*.java
java -cp out pt.escnaval.exercicios.MenuAlunos
```

.gitignore recomendado

O ficheiro `.gitignore` inclui regras para ignorar ficheiros compilados e pastas de build. Não commite os ficheiros `.class` nem a pasta `out/`.

Workflow Git sugerido (a partir da raiz do repositório `POO_2025`):

```cmd
git add lab04
git commit -m "Lab04: objetos de domínio (Aluno), repositório e menu CLI"
git push
```

Teste rápido / Casos de teste

1. Listar quando vazio → output: `(vazio)`
2. Adicionar aluno com id=1, nome="Ana" → [OK] Adicionado.
3. Adicionar aluno com id=1 novamente → [X] Falhou (ID já existe).
4. Buscar por nome com termo parcial (case-insensitive) → lista correspondências.
5. Remover por id existente → [OK] Removido.

Descrição curta das classes

- `Aluno` — construtor valida `id>0` e `nome` não vazio; `equals/hashCode` por `id`.
- `AlunoRepo` — implementa `adicionar`, `removerPorId`, `findById`, `listarPorId`, `listarPorNome`, `buscarPorNome`.
- `MenuAlunos` — menu CLI com opções: 1 Adicionar, 2 Listar por ID, 3 Listar por Nome, 4 Remover, 5 Buscar, 6 Renomear, 0 Sair.

Notas

Os ficheiros `.class` gerados pela compilação serão ignorados pelo Git graças ao `.gitignore`.

Tabela de testes (10 casos) — preencher com saídas reais ao testar

| Caso | Passos / Entrada | Saída esperada |
|------|------------------|----------------|
| 1 | Listar (vazio) | (nenhum resultado) |
| 2 | Adicionar id=1 nome=Ana | [OK] Adicionado. |
| 3 | Adicionar id=1 nome=Ana | [X] Falhou (ID já existente). |
| 4 | Remover id=1 | [OK] Removido. |
| 5 | Remover id=9 | [X] ID não encontrado. |
| 6 | Adicionar vários; Listar por Nome | mostra linhas ordenadas por nome |
| 7 | Buscar por termo "an" | lista correspondências case-insensitive |
| 8 | Renomear id existente | [OK] Atualizado. |
| 9 | Renomear id inexistente | [X] ID não encontrado. |
| 10 | Adicionar com nome vazio | [X] Erro: nome não pode ser vazio |

Comandos de compilação (PowerShell):
```powershell
cd lab04
Get-ChildItem -Recurse src -Filter *.java | % { $_.FullName } | % { & javac -d out $_ }
java -cp out pt.escnaval.exercicios.MenuAlunos
```

Notas de design: encapsulamento (getters/setters com validação), `equals`/`hashCode` baseados em `id`, separação I/O vs lógica de domínio (Menu vs AlunoRepo).

