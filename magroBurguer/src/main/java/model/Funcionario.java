/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joaop
 */
public class Funcionario extends Pessoa {
    private String cpf;

    public Funcionario(String nome, String endereco, String celular, String cpf) {
        super(nome, endereco, celular);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
        public void GravaDadosFuncionario() {      
        List<Funcionario> funcionarios = new ArrayList<>();
        
        Funcionario[] lista = RetornaListaFuncionarios();
        
        if (lista != null) {
            //Adiciona os funcionario ja existente no arquivo
            funcionarios.addAll(Arrays.asList(lista));
        } 

        //Adiciona o novo funcionario no arquivo
        funcionarios.add(this);
        
        EscreveArquivo(funcionarios);   
    }
    
    private void EscreveArquivo(List<Funcionario> funcionarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(funcionarios);

        try ( 
            //Escreve Json convertido em arquivo chamado "funcionarios.json"
            FileWriter writer = new FileWriter("funcionarios.json")) {
            writer.write(json);
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public Funcionario[] RetornaListaFuncionarios() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json = null;
        try {
            json = new BufferedReader(new FileReader("funcionarios.json"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Funcionario[] lista = gson.fromJson(json, Funcionario[].class);

        return lista;
    } 
    
    static public Funcionario RetornaFuncionario(int idFuncionario) {
        Funcionario[] lista = RetornaListaFuncionarios();
        
        for (Funcionario lista1 : lista) {
            if (lista1.getId() == idFuncionario) {
                return lista1;
            }
        }
        return null;
    }

    @Override
    void GeraId() {
        Funcionario[] lista = RetornaListaFuncionarios();
        
        if (lista != null) {
            this.id = lista.length + 1;
        } else {
            this.id = 1;
        } 
    }
    
    
}
