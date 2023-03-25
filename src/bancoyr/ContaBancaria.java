
package bancoyr;

import java.util.ArrayList;



interface Imprimivel{
    void mostrarDados();
}

public abstract  class ContaBancaria {
    
 private String numConta;
 private double saldo;
 private ArrayList<String>historico;
    
 
 public ContaBancaria(String numConta,double saldo){
     this.numConta=numConta;
     this.saldo=saldo;
     this.historico=new ArrayList<>();
     
 }
 
 

public abstract void Depositar(double valor); 
 public abstract void levantar(double valor);
 
 
 
 
 
 
 
 

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> histrorico) {
        this.historico = histrorico;
    }
 
 @Override
 public String toString(){
     return "Numero da conta "+numConta+" saldo "+saldo;
     
 }
 
 
 public void transferir(double valor,ContaBancaria destino){
     if(getSaldo()<valor){
         System.out.println("Saldo insuficiente");
     }
     else{
   this.levantar(valor);
   destino.Depositar(valor);
   
         System.out.println("tranferencia realizada com sucesso");
   
                 }
         
     }
     
 }
 
 
    

