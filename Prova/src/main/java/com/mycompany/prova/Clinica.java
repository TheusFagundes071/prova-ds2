/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Clinica {
    private String nome;
    private String endereco;
    private String cnpj;
    private double valorConsultaSimples;
    private double valorAdicionalExames;
    private List<Consulta> atendimentosRealizados;

    public Clinica(String nome, String endereco, String cnpj, double valorConsultaSimples, double valorAdicionalExames, List<Consulta> atendimentosRealizados) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.valorConsultaSimples = valorConsultaSimples;
        this.valorAdicionalExames = valorAdicionalExames;
        this.atendimentosRealizados = new ArrayList<>();
    }

    Clinica(String senai_Med, String av_Dendezeiros188Bonfim, String string, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


     private void validarValores(double valorConsultaSimples, double valorAdicionalExames) throws EValorInvalidoException {
        if (valorConsultaSimples < 0 || valorAdicionalExames < 0) {
            throw new EValorInvalidoException("Valor Inválido");
            
        }
    }

     
     
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getValorConsultaSimples() {
        return valorConsultaSimples;
    }

    public double getValorAdicionalExames() {
        return valorAdicionalExames;
    }

    
    public void alterarValores(double novoValorConsultaSimples, double novoValorAdicionalExames)
            throws EValorInvalidoException {
        validarValores(novoValorConsultaSimples, novoValorAdicionalExames);

        this.valorConsultaSimples = novoValorConsultaSimples;
        this.valorAdicionalExames = novoValorAdicionalExames;
    }

    public double getValorTotal() {
        double total = 0;
        for (Consulta consulta : atendimentosRealizados) {
            total += consulta.getValor();
        }
        return total;
    }
    
public double realizarAtendimento(String tipoConsulta, Paciente paciente, Date data, String localAtendimento) throws EAtendimentoNaoRegistradoException, EValorInvalidoException {

        double valorAtendimento = 0;

        if (tipoConsulta.equals("simples")) {

            Consulta consultaSimples = new Consulta(paciente, data, localAtendimento, valorConsultaSimples);

            atendimentosRealizados.add(consultaSimples);

            valorAtendimento = valorConsultaSimples;

        } else if (tipoConsulta.equals("check-up")) {

            Checkup checkup = new Checkup(valorAdicionalExames, paciente, data, localAtendimento, valorAtendimento);

            atendimentosRealizados.add(checkup);

            valorAtendimento = checkup.getValor();

        } else {

            throw new EAtendimentoNaoRegistradoException("Consulta Inválida");

        }

        return valorAtendimento;

    }


    public List<Consulta> getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    public void setValorAdicionalExames(double valorAdicionalExames) {
        this.valorAdicionalExames = valorAdicionalExames;
    }


}



