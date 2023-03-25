/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoyr;

/**
 *
 * @author HP CQ58
 */
public class ContaPoupanca extends ContaBancaria {
    
    private double limite;
    
    public ContaPoupanca(String numConta,double saldo,double limite){
        
        super(numConta,saldo);
        this.limite=limite;
        
    }
    
    @Override
    public void levantar(double valor){
        
        if (valor > 0 && valor <= (getSaldo() + limite)) {
            setSaldo(getSaldo() - valor);
      
        } else {
            System.out.println("Saldo insuficiente.");
        }
        
    }
    @Override
    public void Depositar(double valor){
               
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            
            System.out.println("Vc depositou "+valor +" na conta: "+getNumConta());
           
        } else {
            System.out.println("Valor inválido.");
        }
    }
    
     
    
public void mostrarDados(){

    System.out.println("Numero da Conta: "+getNumConta());
    System.out.println("Saldo: "+getSaldo());
    System.out.println("");
   
    
    
    
}
}
    
    
    

