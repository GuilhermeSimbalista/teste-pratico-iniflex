package src.Utils;


import src.model.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static List<Funcionario> inicializarFuncionarios() {
        return new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
    }

    public static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(func -> func.getNome().equals(nome));
        System.out.println("\n");
    }

    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
        System.out.println("\n");
    }

    public static void aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
        for (Funcionario func : funcionarios) {
            func.aumentoSalarial(percentual);
        }
        System.out.println("\n");
    }

    public static void imprimirFuncionariosAgrupadosPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario func : entry.getValue()) {
                System.out.println(func);
            }
        }
        System.out.println("\n");
    }

    public static void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        System.out.println("Funcionários que fazem aniversário nos meses especificados: ");
        for (Funcionario func : funcionarios) {
            int month = func.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (month == mes) {
                    System.out.println(func);
                }
            }
        }
        System.out.println("\n");
    }

    public static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idadeMaisVelho = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("Funcionário com maior idade: " + maisVelho.getNome() + ", Idade: " + idadeMaisVelho);
        System.out.println("\n");
    }

    public static void imprimirFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios) {
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario func : funcionariosOrdenados) {
            System.out.println(func);
        }
        System.out.println("\n");
    }

    public static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + numberFormat.format(totalSalarios));
        System.out.println("\n");
    }

    public static void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        for (Funcionario func : funcionarios) {
            BigDecimal quantidadeSalariosMinimos = func.getSalario().divide(salarioMinimo, BigDecimal.ROUND_DOWN);
            System.out.println(func.getNome() + " ganha " + quantidadeSalariosMinimos + " salários mínimos.");
        }
        System.out.println("\n");
    }
}
