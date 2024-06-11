package src;

import src.Utils.Util;
import src.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = Util.inicializarFuncionarios();

        // 3.2 - Remover o funcionário “João” da lista
        Util.removerFuncionario(funcionarios, "João");

        // 3.3 - Imprimir todos os funcionários
        Util.imprimirFuncionarios(funcionarios);

        // 3.4 - Os funcionários receberam 10% de aumento de salário
        for (Funcionario func : funcionarios) {
            func.aumentoSalarial(new BigDecimal("0.10"));
        }

        // 3.5 - 3.6 - Agrupar os funcionários por função em um MAP
        Util.imprimirFuncionariosAgrupadosPorFuncao(funcionarios);

        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12
        Util.imprimirAniversariantes(funcionarios, 10, 12);

        // 3.9 - Imprimir o funcionário com a maior idade
        Util.imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        Util.imprimirFuncionariosOrdemAlfabetica(funcionarios);

        // 3.11 - Imprimir o total dos salários dos funcionários
        Util.imprimirTotalSalarios(funcionarios);

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        Util.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}

