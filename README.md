# Iniflex Teste Prático

Este projeto é uma aplicação Java desenvolvida como parte de um teste prático. Ele implementa funcionalidades relacionadas à manipulação de uma lista de funcionários, incluindo cálculos, agrupamentos e formatações.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Maven**: Gerenciador de dependências e build.
- **IntelliJ IDEA**: IDE recomendada para desenvolvimento.

## Estrutura do Projeto

- `src/main/java/inflex/Pessoa.java`: Classe base representando uma pessoa com nome e data de nascimento.
- `src/main/java/inflex/Funcionario.java`: Classe que estende `Pessoa`, adicionando atributos de função e salário.
- `src/main/java/inflex/Main.java`: Classe principal que executa as funcionalidades solicitadas.
- `pom.xml`: Arquivo de configuração do Maven.

## Funcionalidades

1. **Inserção de Funcionários**: Criação de uma lista de funcionários com dados pré-definidos.
2. **Remoção de Funcionário**: Exclusão do funcionário "João" da lista.
3. **Impressão de Funcionários**:
    - Data formatada como `dd/MM/yyyy`.
    - Salário formatado com separador de milhar e decimal.
4. **Aumento Salarial**: Aplicação de 10% de aumento no salário de todos os funcionários.
5. **Agrupamento por Função**: Agrupamento dos funcionários em um `Map` com base na função.
6. **Aniversariantes**: Listagem de funcionários que fazem aniversário nos meses 10 e 12.
7. **Funcionário Mais Velho**: Identificação do funcionário com a maior idade.
8. **Ordenação Alfabética**: Impressão da lista de funcionários em ordem alfabética.
9. **Total de Salários**: Cálculo do total dos salários de todos os funcionários.
10. **Salários Mínimos**: Cálculo de quantos salários mínimos cada funcionário recebe.

## Como Executar

1. **Pré-requisitos**:
    - Java 17 instalado.
    - Maven configurado no ambiente.
    - IDE (como IntelliJ IDEA) ou terminal para execução.

2. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/helenformighieri/iniflex-teste-pratico.git
   cd iniflex-teste-pratico