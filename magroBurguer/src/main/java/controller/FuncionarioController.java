/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Funcionario;

/**
 *
 * @author joaop
 */
public class FuncionarioController {
    static public void geraNotaFiscal(String nome, String endereco, String celular, String cpf) {
        Funcionario funcionario = new Funcionario(nome, endereco, celular, cpf);
        
        funcionario.GravaDadosFuncionario();
    }   
}
