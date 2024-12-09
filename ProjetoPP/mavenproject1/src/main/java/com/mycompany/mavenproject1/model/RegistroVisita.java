/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

/**
 *
 * @author leafa
 */
public class RegistroVisita {
    private Integer id;
    private String nomePaciente;
    private String nomeVisita;
    private String telefone;
    private String periodo;
    
    public RegistroVisita(){     
    }

    public RegistroVisita(Integer id,String nomePaciente, String nomeVisita, String telefone, String periodo) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.nomeVisita = nomeVisita;
        this.telefone = telefone;
        this.periodo = periodo;
    }
    
    
    
    public RegistroVisita(Integer id, String nomePaciente, String nomeVisita, String telefone){
        this.id = id;;
        this.nomePaciente = nomePaciente;
        this.nomeVisita = nomeVisita;
        this.telefone = telefone;
    }
    
    public String getNomePaciente(){
     return this.nomePaciente;
    }
    
     public void setNomePaciente(String nomePaciente){
     this.nomePaciente = nomePaciente;
    }

    public String getNomeVisita() {
        return nomeVisita;
    }

    public void setNomeVisita(String nomeVisita) {
        this.nomeVisita = nomeVisita;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void showObj(){
        System.out.println(this.periodo + "Nome Paciente: "+ this.nomePaciente+" Nome Visita: " + this.nomeVisita + " Telefone: " + this.telefone + " Período: ");
    }
}
