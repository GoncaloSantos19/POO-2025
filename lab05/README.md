# Lab 05 — POO: Classes, Encapsulamento, Composição, Herança, Interfaces e Identidade

Unidade Curricular: Programação Orientada aos Objetos — Java

Modalidade: Laboratório em computador pessoal

Duração sugerida: 2h

## Versões de ferramentas

- **JDK:** 17.0.x (ou superior)
- **javac:** 17.0.x
- **java:** 17.0.x

## Compilar

```powershell
# A partir de lab05/
javac -d out src/main/java/pt/escnaval/exercicios/*.java
```

## Executar

```cmd
java -cp out pt.escnaval.exercicios.MainDemo
java -cp out pt.escnaval.exercicios.DemoIdentidade
java -cp out pt.escnaval.exercicios.DemoArmadilhas
java -cp out pt.escnaval.exercicios.DemoHerancaInterface
```

## Tabela de Testes

| # | Caso | Entrada/Passos | Saída Esperada | Resultado |
|---|------|----------------|----------------|-----------|
| 1 | Endereco válido | `new Endereco("Rua A", "Lisboa", "1000")` | `isValido()` retorna `true` | ✓ |
| 2 | Endereco inválido (rua vazia) | `new Endereco("", "Lisboa", "1000")` | `isValido()` retorna `false` | ✓ |
| 3 | Cliente válido | `new Cliente(1, "Ana", email, end, senha)` | `isValido()` retorna `true` | ✓ |
| 4 | Cliente inválido (id ≤ 0) | `new Cliente(0, "Ana", email, end, senha)` | `isValido()` retorna `false` | ✓ |
| 5 | Cliente inválido (email) | `new Cliente(1, "Ana", "x@", end, senha)` | `isValido()` retorna `false` | ✓ |
| 6 | mudarEmail válido | `cliente.mudarEmail("novo@mail.com")` | retorna `true` | ✓ |
| 7 | mudarEmail inválido | `cliente.mudarEmail("invalido")` | retorna `false` | ✓ |
| 8 | Interface: autenticar correto | `cliente.autenticar("senha123")` | retorna `true` | ✓ |
| 9 | Interface: autenticar errado | `cliente.autenticar("errada")` | retorna `false` | ✓ |
| 10 | Interface: getIdentificador | `cliente.getIdentificador()` | retorna email | ✓ |
| 11 | IBAN válido | `new Iban("PT50000000000000000000000")` | `isValid()` retorna `true` | ✓ |
| 12 | IBAN inválido | `new Iban("PT1")` | `isValid()` retorna `false` | ✓ |
| 13 | Conta válida | `new Conta(iban, cliente, 100)` | `isValida()` retorna `true` | ✓ |
| 14 | Conta inválida (saldo < 0) | `new Conta(iban, cliente, -10)` | `isValida()` retorna `false` | ✓ |
| 15 | Depósito válido | `conta.depositar(25)` | retorna `true`, saldo aumenta | ✓ |
| 16 | Depósito inválido | `conta.depositar(-1)` | retorna `false` | ✓ |
| 17 | Levantamento > saldo | `conta.levantar(999)` | retorna `false` | ✓ |
| 18 | Transferência válida | `a1.transferirPara(a2, 30)` | retorna `true`, saldos ajustados | ✓ |
| 19 | Transferência saldo insuf. | `a1.transferirPara(a2, 300)` | retorna `false` | ✓ |
| 20 | Banco: abrir conta | `banco.abrirConta(conta)` | retorna `true`, numContas aumenta | ✓ |
| 21 | Banco: abrir duplicada | `banco.abrirConta(contaDup)` | retorna `false` | ✓ |
| 22 | Banco: fechar conta | `banco.fecharConta(iban)` | retorna `true`, numContas diminui | ✓ |
| 23 | Banco: buscar conta | `banco.findByIban(iban)` | retorna conta ou `null` | ✓ |
| 24 | Herança: ContaOrdem criar | `new ContaOrdem(iban, cli, 100, 500)` | conta válida com limite | ✓ |
| 25 | Herança: descoberto permitido | `contaOrdem.levantar(600)` saldo=100 | retorna `true`, saldo=-500 | ✓ |
| 26 | Herança: descoberto excedido | `contaOrdem.levantar(700)` limite=500 | retorna `false` | ✓ |
| 27 | Herança: ContaPoupanca criar | `new ContaPoupanca(iban, cli, 1000, 3.5)` | conta válida com taxa | ✓ |
| 28 | Herança: calcular juros | `contaPoup.calcularJuros()` saldo=1000 | retorna `35.0` | ✓ |
| 29 | Herança: aplicar juros | `contaPoup.aplicarJuros()` | saldo aumenta | ✓ |
| 30 | Polimorfismo: array Conta[] | `Conta[] = {Conta, ContaOrdem, ContaPoup}` | todas tratadas como Conta | ✓ |
| 31 | Polimorfismo: instanceof | `if (c instanceof ContaOrdem)` | permite casting seguro | ✓ |
| 32 | equals em hierarquia | `contaBase.equals(contaOrdem)` mesmo IBAN | retorna `true` | ✓ |

## Notas de Design

### Sem Exceções
Todos os métodos de validação e operações retornam `boolean` ou `null` em vez de lançar exceções. Os objetos têm um campo `valido`/`isValid()` para indicar se a criação foi bem-sucedida.

### Sem Coleções
Uso de arrays (`Tipo[]`) em vez de `List`, `ArrayList`, `Set`, `HashMap`. Classe `Banco` usa `Conta[]` contas com expansão manual quando necessário. Retorno `null` em vez de `Optional`.

### Identidade vs. Valor
- **Endereco**: valor imutável, equals/hashCode por todas as propriedades.
- **Cliente**: identidade por `id`, equals/hashCode apenas por `id`.
- **Iban**: valor imutável, equals/hashCode por `codigo`.
- **Conta**: identidade por `iban`, equals/hashCode apenas por `iban`.

### Encapsulamento e Invariantes
Campos `private` (ou `private final` para imutáveis). Construtores validam e garantem invariantes. Métodos de negócio preservam as regras (ex: saldo ≥ 0).

### Composição
- `Cliente` tem `Endereco` (composição, não herança).
- `Conta` tem `Cliente` e `Iban`.

### Herança vs. Composição
**Herança** usada quando existe relação **É-UM** legítima:
- `ContaOrdem` é uma `Conta`
- `ContaPoupanca` é uma `Conta`

**Composição** usada quando existe relação **TEM-UM**:
- `Cliente` tem um `Endereco`
- `Conta` tem um `Cliente`

### Interfaces
`Autenticavel` define contrato de comportamento. `Cliente implements Autenticavel` - compromete-se a implementar os métodos. Permite polimorfismo: `Autenticavel auth = new Cliente(...)`. Vantagens: desacoplamento, múltiplas implementações, contratos claros.

### Polimorfismo
- Via herança: `Conta[] contas` pode conter `Conta`, `ContaOrdem`, `ContaPoupanca`.
- Via interface: `Autenticavel auth` pode referenciar qualquer classe que implemente.
- Métodos comuns chamados via tipo base.
- Métodos específicos requerem casting após `instanceof`.

### Visibilidade Protected
Campo `saldo` em `Conta` é `protected` (não `private`). Permite acesso em subclasses (`ContaOrdem`, `ContaPoupanca`). Mantém encapsulamento para código externo.

## Compilar/Executar

```powershell
# A partir de lab05/
javac -d out src/main/java/pt/escnaval/exercicios/*.java
java -cp out pt.escnaval.exercicios.MainDemo
java -cp out pt.escnaval.exercicios.DemoIdentidade
```

## Critérios de avaliação (formativa)

- Encapsulamento e invariantes corretos (objetos nascem válidos).
- Composição correta quando relação é TEM-UM (Cliente tem Endereco).
- Herança correta quando relação é É-UM (ContaOrdem é Conta).
- Interfaces implementadas corretamente (Cliente implements Autenticavel).
- Polimorfismo demonstrado (arrays polimórficos, chamadas via tipo base).
- equals/hashCode coerentes (identidade vs. valor) e funcionam em hierarquia.
- Arrays utilizados corretamente em vez de coleções.
- Sem exceções: validações retornam boolean ou null.
- toString() úteis; @Override usado corretamente.
- Código legível/organizado; separação de responsabilidades.
- README com 30+ testes, comandos e notas de design (incluindo decisões sobre herança/composição).

## .gitignore recomendado

O ficheiro `.gitignore` inclui regras para ignorar ficheiros compilados e pastas de build. Não commite os ficheiros `.class` nem a pasta `out/`.

## Workflow Git sugerido

A partir da raiz do repositório `POO_2025`:

```cmd
git add lab05
git commit -m "Adiciona lab05: herança, interfaces e polimorfismo"
git push
```
