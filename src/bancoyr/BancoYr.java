/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bancoyr;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP CQ58
 */
public class BancoYr {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<ContaBancaria>conta=new ArrayList<ContaBancaria>();
    
    //Criacao das contas   
 
    ContaPoupanca cp=new ContaPoupanca("12222-0",13000,300);
   
    ContaCorrente cc=new ContaCorrente("2222-9",1000,10);
   
    
        System.out.println("Informacao inicial");
        cc.mostrarDados();
        cp.mostrarDados();
        System.out.println("");
        
     System.out.println("Depositos");
     //Fazendo depositos
        cc.Depositar(1000);
        System.out.println("");
         cp.Depositar(200);
        
//Dados das contas apos o deposito

       
        cc.mostrarDados();
        cp.mostrarDados();
        System.out.println("");
    
        
         
        //fazendo levantamentos
        
                System.out.println("Levantamento");

        cc.levantar(20000000);
        System.out.println("");
        cp.levantar(2);
        System.out.println("");
        
        //Dados da conta apos o levantamento
        cc.mostrarDados();
        cp.mostrarDados();
        
        
        //Fazendo transferrencias
        System.out.println("Transferencia");
        cp.transferir(100000, cc);
       
        System.out.println("");
        // Mostrando os dados das contas apos a transferencio
        
        cc.mostrarDados();
        cp.mostrarDados();
        
        
   
 
        


      
       

    }
    
}
