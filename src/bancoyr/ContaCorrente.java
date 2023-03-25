/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoyr;

/**
 *
 * @author HP CQ58
 */
public class ContaCorrente extends ContaBancaria{
    
    private double taxa;
    
    
    public ContaCorrente(String numConta,double saldo,double taxa){
        
        super(numConta,saldo);
        this.taxa=taxa;
        
    }
    
    
    
    
    @Override
    public void levantar(double valor){
        
      if(valor>0  && valor<=(getSaldo()-taxa)){
          setSaldo(getSaldo()-valor -taxa);
       
          System.out.println("Vc retirou "+valor + " da sua conta, a taxa foi de "+taxa);
          
      }
      else{
          System.out.println("Saldo insuficiente");
      }
    }

    @Override
    public void Depositar(double valor) {
    
    if(valor>0){
       setSaldo(getSaldo()+valor-taxa);
        
     
        System.out.println("Deposito realizado com sucesso na conta "
                + ""+getNumConta()+", vc depositou "+ valor+ ", taxa: "+taxa );
        
    }
    else{
        System.out.println("Valor invalido");
    }
    }
    
    public void mostrarDados(){
        
        System.out.println("Conta Corrente");
        System.out.println("Numero da conta: "+getNumConta());
        System.out.println("Saldo da conta: "+getSaldo());
        System.out.println("");
        
    }
    
    
    
    }
    
    
    

   
    
    

