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
public class Paciente {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String planoSaude;


    
    public Paciente(String cpf, String nome, Date dataNascimento, String planoSaude) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.planoSaude = planoSaude;
    }

    Paciente(String cpf, String nome, String dataNascimentoStr, String planoXYZ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    
    
    
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    

    
    
}
