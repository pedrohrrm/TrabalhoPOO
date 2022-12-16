/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class teste {
    public static void main(String[] args) {
        String[] nomeFuncionario = new String [1];
        nomeFuncionario[0] = "Paulo";
        
        String[] nomeUsuario = new String [1];
        nomeUsuario[0] = nomeFuncionario[0] + 1;
        
        String[] senhaUsuario = new String [1];
        senhaUsuario[0] = "@" + nomeFuncionario[0] + 1;
        
        String[] cpfFuncionario = new String [1];
        cpfFuncionario[0] = "000.000.000-00";
        
        
        
        System.out.println(Arrays.toString(nomeFuncionario));
        System.out.println(Arrays.toString(nomeUsuario));
        System.out.println(Arrays.toString(senhaUsuario));
        System.out.println(Arrays.toString(cpfFuncionario));
        
        
    }
    
}
