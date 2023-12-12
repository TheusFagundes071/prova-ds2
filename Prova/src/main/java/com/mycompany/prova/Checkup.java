/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Checkup extends Consulta {
    private double valor_Adicional;

    
    
    public Checkup(double valor_Adicional, Paciente paciente, Date data, String Local_Atendimento, double valor) {
        super(paciente, data, Local_Atendimento, valor);
        this.valor_Adicional = valor_Adicional;
    }

    
    
    private void validarDataNascimento(Date dataNascimento) throws EValorInvalidoException {
        // Adicione aqui a lógica de validação da data de nascimento
        Date dataAtual = new Date();
        if (dataNascimento.after(dataAtual)) {
            throw new EValorInvalidoException("Valor Inválido");
        }
    }
    
    
    
     private void validarValorConsulta(double valor) throws EValorInvalidoException {
        if (valor < 0) {
            throw new EValorInvalidoException("Valor Inválido");
        }
    }

     
      private void validarValorAdicional(double valorAdicional) throws EValorInvalidoException {
        if (valorAdicional < 0) {
            throw new EValorInvalidoException("Valor adicional do check-up não pode ser negativo");
        }
    }

    @Override
    public double getValor() {
        if ("SenaiMed".equals(super.getPaciente().getPlanoSaude())) {
            return super.getValor() + this.valor_Adicional - (0.18 * this.valor_Adicional);
        } else {
            return super.getValor() + this.valor_Adicional;
        }
    }
     
    public double getValor_adicional() {
        return valor_Adicional;
    }
     
          
}
