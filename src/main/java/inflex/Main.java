package inflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    private static final BigDecimal AUMENTO_PERCENTUAL = new BigDecimal("0.10");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

    static {
        NUMBER_FORMATTER.setMinimumFractionDigits(2);
        NUMBER_FORMATTER.setMaximumFractionDigits(2);
    }

    public static void main(String[] args) {
        List<Funcionario> funcionarios = criarFuncionarios();

        System.out.println("Tabela antes da exclusão de João:");
        imprimirTabela(funcionarios);

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        System.out.println("\nTabela após a exclusão de João:");
        imprimirTabela(funcionarios);

        funcionarios.forEach(funcionario -> {
            BigDecimal aumento = funcionario.getSalario().multiply(AUMENTO_PERCENTUAL);
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        });

        System.out.println("\nTabela após o aumento de 10% nos salários:");
        imprimirTabela(funcionarios);

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> System.out.println(" - " + funcionario.getNome()));
        });

        System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
        funcionarios.stream()
                .filter(funcionario -> {
                    int mes = funcionario.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(funcionario -> System.out.println(" - " + funcionario.getNome()));

        System.out.println("\nFuncionário com a maior idade:");
        funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(funcionario -> {
                    int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.println("Nome: " + funcionario.getNome() + ", Idade: " + idade + " anos");
                });

        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal dos salários dos funcionários: " + NUMBER_FORMATTER.format(totalSalarios));

        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome, String.CASE_INSENSITIVE_ORDER))
                .forEach(funcionario -> System.out.println(" - " + funcionario.getNome()));

        System.out.println("\nQuantidade de salários mínimos que cada funcionário ganha:");
        funcionarios.forEach(funcionario -> {
            BigDecimal quantidadeSalariosMinimos = funcionario.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + funcionario.getNome() + ", Salários mínimos: " + quantidadeSalariosMinimos);
        });
    }

    private static List<Funcionario> criarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), "Operador", new BigDecimal("2009.44")));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), "Operador", new BigDecimal("2284.38")));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), "Coordenador", new BigDecimal("9836.14")));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), "Diretor", new BigDecimal("19119.88")));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), "Recepcionista", new BigDecimal("2234.68")));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), "Operador", new BigDecimal("1582.72")));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), "Contador", new BigDecimal("4071.84")));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), "Gerente", new BigDecimal("3017.45")));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), "Eletricista", new BigDecimal("1606.85")));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), "Gerente", new BigDecimal("2799.93")));
        return funcionarios;
    }

    private static void imprimirTabela(List<Funcionario> funcionarios) {
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Nome", "Data Nascimento", "Função", "Salário");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%-15s %-15s %-15s %-15s%n",
                    funcionario.getNome(),
                    funcionario.getDataNascimento().format(DATE_FORMATTER),
                    funcionario.getFuncao(),
                    NUMBER_FORMATTER.format(funcionario.getSalario()));
        }
    }
}