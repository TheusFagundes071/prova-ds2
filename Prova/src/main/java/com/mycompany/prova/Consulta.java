/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prova;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Consulta {
    private Paciente paciente;
    private Date data;
    private String Local_Atendimento;
    private double valor;

    
    
    
    
    public Consulta(Paciente paciente, Date data, String Local_Atendimento, double valor) {
        this.paciente = paciente;
        this.data = data;
        this.Local_Atendimento = Local_Atendimento;
        this.valor = valor;
    }
    
    
    
    
    
    
     private void validarDataNascimento(Date dataNascimento) throws EValorInvalidoException {
        // Adicione aqui a lógica de validação da data de nascimento
        Date dataAtual = new Date();
        if (dataNascimento.after(dataAtual)) {
            throw new EValorInvalidoException("Valor Inválido");
        }
    }
    
    
    
    
    public Paciente getPaciente() {
        return paciente;
    }

    
    
    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }


    
    

    public String getLocal_Atendimento() {
        return Local_Atendimento;
    }
     
    
 
    private void validarValorConsulta(double valor) throws EValorInvalidoException {
        if (valor < 0) {
            throw new EValorInvalidoException("Valor Inválido");
        }
    }

}
