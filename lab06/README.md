# Lab 06 — Tratamento de Exceções em Java

Unidade Curricular: Programação Orientada aos Objetos — Java

Modalidade: Laboratório em computador pessoal

Duração sugerida: 120 min

## Objetivos de aprendizagem

Ao concluir este laboratório, será capaz de:

- Compreender a hierarquia de Exceções em Java (Throwable, Exception, RuntimeException, Error)
- Distinguir Exceções **verificadas (checked)** de **não-verificadas (unchecked)**
- Criar Exceções customizadas específicas do domínio com hierarquia própria
- Implementar tratamento robusto com `try-catch-finally` e `try-with-resources`
- Aplicar Boas Práticas: validação em construtores, mensagens descritivas, propagação adequada
- Projetar validações de invariantes usando Exceções apropriadas
- Integrar interfaces, classes abstratas e polimorfismo com tratamento de Exceções

## Versões de ferramentas

- **JDK:** 17.0.x (ou superior)
- **javac:** 17.0.x
- **java:** 17.0.x

## Estrutura de ficheiros

```
lab06/
├─ src/
│  └─ main/
│     └─ java/
│        └─ pt/
│           └─ escnaval/
│              └─ exercicios/
│                 ├─ exceptions/
│                 │  ├─ ContaBancariaException.java
│                 │  ├─ SaldoInsuficienteException.java
│                 │  ├─ ContaInvalidaException.java
│                 │  └─ OperacaoNaoPermitidaException.java
│                 ├─ modelo/
│                 │  ├─ ContaBancaria.java (interface)
│                 │  ├─ ContaBancariaBase.java (abstrata)
│                 │  ├─ ContaCorrente.java
│                 │  └─ ContaPoupanca.java
│                 ├─ servicos/
│                 │  └─ Banco.java
│                 ├─ utils/
│                 │  └─ UtilsIO.java
│                 └─ MenuBanco.java
├─ README.md
├─ .gitignore
└─ out/
```

## Compilar

```cmd
cd lab06
javac -d out src\main\java\pt\escnaval\exercicios\exceptions\*.java src\main\java\pt\escnaval\exercicios\modelo\*.java src\main\java\pt\escnaval\exercicios\servicos\*.java src\main\java\pt\escnaval\exercicios\utils\*.java src\main\java\pt\escnaval\exercicios\*.java
```

## Executar

```cmd
chcp 65001
java -cp out pt.escnaval.exercicios.MenuBanco
```

**Nota:** Execute `chcp 65001` antes para suporte UTF-8 se houver caracteres inválidos.

## Conceitos Fundamentais

### Hierarquia de Exceções

```
Throwable
├─ Error (não recuperáveis, não capturar)
└─ Exception
   ├─ RuntimeException (não-verificadas/unchecked)
   │  ├─ NullPointerException
   │  ├─ IllegalArgumentException
   │  └─ IllegalStateException
   └─ IOException, SQLException, etc. (verificadas/checked)
```

### Exceções Verificadas (Checked) vs Não-Verificadas (Unchecked)

**Verificadas (Checked):**
- Estendem `Exception` (mas não `RuntimeException`)
- Compilador obriga a declarar (`throws`) ou capturar (`try-catch`)
- Usadas para **erros recuperáveis** de negócio
- Exemplos: `IOException`, `SQLException`, `SaldoInsuficienteException`

**Não-Verificadas (Unchecked):**
- Estendem `RuntimeException`
- Compilador não obriga tratamento
- Usadas para **violações de invariantes/pré-condições**
- Exemplos: `NullPointerException`, `IllegalArgumentException`, `ContaInvalidaException`

### Quando usar cada tipo?

**Use Checked (verificadas):**
- Erros de negócio recuperáveis (saldo insuficiente, operação não permitida)
- Situações previsíveis que o chamador deve tratar
- Quando a recuperação é possível e desejável

**Use Unchecked (não-verificadas):**
- Violações de pré-condições (argumentos nulos/inválidos)
- Erros de programação (bugs)
- Violações de invariantes do objeto

## Regras de Ouro

✓ Interface define o contrato (métodos públicos)  
✓ Classe abstrata centraliza validações e comportamento comum  
✓ Subclasses implementam lógica específica (polimorfismo)  
✓ Arrays de objetos permitem polimorfismo (tipo base no array)  
✓ Exceções verificadas para erros recuperáveis de negócio  
✓ Exceções não-verificadas para violações de invariantes/pré-condições  

## Boas Práticas

1. **Mensagens descritivas** — incluir contexto (valores, limites)
2. **Validação cedo** — construtores devem validar e lançar exceções apropriadas
3. **Não usar exceções para controlo de fluxo normal** — use-as apenas para situações excecionais
4. **Finally ou try-with-resources** — garantir libertação de recursos
5. **Não capturar Exception genérica** — capturar exceções específicas
6. **Documentar com @throws** — Javadoc deve indicar quando/porquê lançar

## .gitignore

Ficheiros ignorados:
- `out/`, `bin/`, `target/`, `build/`
- `*.class`, `*.log`
- `.vscode/`, `.idea/`

## Workflow Git sugerido

```cmd
git add lab06
git commit -m "Adiciona lab06: tratamento de exceções em Java"
git push
```

## Biblioteca Java utilizada

- **Arrays** — armazenamento polimórfico de `ContaBancaria[]`
- **java.util.Arrays** — `Arrays.copyOf()` para redimensionar
- **java.util.Objects** — `Objects.requireNonNull()` para validações
- **java.util.Scanner** — entrada com `nextLine()` + parse
- **java.lang.String** — `trim()`, `isBlank()`, `matches()`
- **java.util.Locale** — formatação consistente com `Locale.US`
