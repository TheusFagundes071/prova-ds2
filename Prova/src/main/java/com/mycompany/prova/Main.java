package com.mycompany.prova;

import java.util.Scanner;
import java.util.Date;



public class Main {
    public static void main(String[] args) throws EAtendimentoNaoRegistradoException {
        Clinica Senaimed = new Clinica("Senai Med", "av_Dendezeiros 188 Bonfim", "3254324", 80, 120);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Menu Principal");
            System.out.println("a. Realizar atendimento");
            System.out.println("b. Consultar a média de valor dos atendimentos");
            System.out.println("c. Alterar o valor da consulta simples ou o adicional para exames");
            System.out.print("Escolha uma opção: ");
            char opcao = scanner.next().charAt(0);
            scanner.nextLine();

            switch (opcao) {
                case 'a':
                    realizarAtendimento(Senaimed, scanner);
                    break;
                case 'b':
                    consultarMediaAtendimentos(Senaimed);
                    break;
                case 'c':
                    alterarValores(Senaimed, scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void realizarAtendimento(Clinica clinica, Scanner scanner, Date data) throws EAtendimentoNaoRegistradoException, EValorInvalidoException {
        try {
            System.out.print("Qual o tipo de atendimento(simples ou checkup)? ");
            String tipoAtendimento = scanner.nextLine();

            System.out.print("Qual o CPF do paciente? ");
            String cpf = scanner.nextLine();

            System.out.print("Qual o nome do paciente? ");
            String nome = scanner.nextLine();

            System.out.print("Qual a data de nascimento do paciente (yyyy-MM-dd)? ");
            String dataNascimento = scanner.nextLine();

            System.out.print("Qual o plano de saúde do paciente? ");
            String planoSaude = scanner.nextLine();

            Paciente paciente = new Paciente(cpf, nome, dataNascimento, planoSaude);
            System.out.println(dataNascimento);
            System.out.print("Qual a data do atendimento (yyyy-MM-dd)? ");
            String dataAtendimento = scanner.nextLine();
           

            System.out.print("Qual o local do atendimento? ");
            String localAtendimento = scanner.nextLine();

            double valorAtendimento = clinica.realizarAtendimento(tipoAtendimento, paciente, data, localAtendimento);
            System.out.println("Atendimento realizado!");
            System.out.println("Valor total: R$" + valorAtendimento);
              } catch (RuntimeException e) {
            System.out.println("Erro ao realizar atendimento: " + e.getMessage());
        }
    }

    private static void consultarMediaAtendimentos(Clinica clinica) {
        double media = clinica.getValorTotal() / clinica.getAtendimentosRealizados().size();
        System.out.println("Média de valor dos atendimentos realizados: R$ " + media);
    }

    private static void alterarValores(Clinica clinica, Scanner scanner) {
        char opcao = scanner.next().charAt(0);
        scanner.nextLine();

        try {
            switch (opcao) {
                case 'a':
                    System.out.print("Qual o novo valor adicional para exames: ");
                    double novoValorAdicionalExames = scanner.nextDouble();
                    clinica.setValorAdicionalExames(novoValorAdicionalExames);
                    System.out.println("Valor adicional para exames alterado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao alterar valores: " + e.getMessage());
        }
    }
}

