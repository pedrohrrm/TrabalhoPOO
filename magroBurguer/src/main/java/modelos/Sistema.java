
package modelos;

import controller.ClienteController;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Sistema  {
    
    public static void main(String[] args) throws IOException {
        String nome;
        String endereco;
        String celular;
        
        ClienteController ClienteController = new ClienteController();
    
        Scanner dados = new Scanner(System.in);

        
         
//        ClienteController.AlteraCliente();
        
        
        System.out.printf("Informe o nome: ");
        nome = dados.nextLine();
        
        System.out.printf("Informe o endereço: ");
        endereco = dados.nextLine();
        
        System.out.printf("Informe o celular: ");
        celular = dados.nextLine();

        ClienteController.CadastraCliente(nome, endereco, celular);
        
    }
    

     
}
    

