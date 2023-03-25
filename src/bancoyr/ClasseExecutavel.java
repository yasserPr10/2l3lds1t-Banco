/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoyr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClasseExecutavel {
    
    public static void main(String[] args) {
    
    Scanner x = new Scanner(System.in);
        
        Connection con;
        PreparedStatement pst;
        PreparedStatement pst2;
        PreparedStatement pst3;
        
        PreparedStatement pst5;
        PreparedStatement pst6;
        ResultSet rs;
        
        //NB.: O metodo ramdom e usado para gerar automaticamente o numero do cartao do credito
 Conta ce=new Conta(); 
        
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(rand.nextInt(10));
        }
        String cartaoCredito = sb.toString();
        
      
       
                
        
        System.out.println("Sistema bancario");
        
        System.out.println("Digite 0 caso queira regressar ao menu");
        while(1==1){
        System.out.println("---1.Contas---");
        System.out.println("---2.Transferencias---");
        
        
        
        System.out.println("Escolha oque deseja realizar");
        int opc=x.nextInt();
        
        switch(opc){
            
            case 1:
                System.out.println("1]-----Criar conta-----");
                System.out.println("2]-----Selecionar conta----");
                System.out.println("3]-----Registro de contas");
               int opc1=x.nextInt();
               
               switch(opc1){
                   
                   case 1:
                       System.out.println("");
                       String c=x.nextLine();
        System.out.println("Digite o tipo de conta");
        String conta=x.nextLine();
                
               
                System.out.println("Digite o nome do cliente");
                String nom=x.nextLine();
                
                System.out.println("O numero da sua conta sera: ");
                System.out.println( cartaoCredito);
               
               
                System.out.println("Digite uma senha");
                String senha =x.nextLine();
                
               ce.setNome(nom);
               ce.setSenha(senha);
               ce.setNumCard(cartaoCredito);
               ce.setTipoC(conta);
               ce.setSaldo(0);
              
                String nome=ce.getNome();
                String cartao=ce.getNumCard();
                String pin = ce.getSenha();
                double sal=ce.getSaldo();
               
                String tipo=ce.getTipoC();
                
                //conexao ao banco de dados
                
                  try { 
           Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
            
            pst=con.prepareStatement("insert into conta (nome,cartao,senha,saldo,tipoCon) values (?,?,?,?,?)");
  
            
            pst.setString(1, nome);
            pst.setString(2, cartao);
            pst.setString(3, pin);
            pst.setDouble(4, sal);
            pst.setString(5, tipo);
            
            pst.executeUpdate();
            
                      System.out.println("Salvooo");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                  break;
                 
                  
                   case 2:
                        //Codigo para pesquisar a conta
                       
                       System.out.println("Pesquisando conta");
                       String v=x.nextLine();
                       
                         System.out.println("Digite o numero do seu cartao");
                       String numC=x.nextLine();
     
                         ce.setTen(numC);
                         
                         String dc=ce.getTen();
                         
                        try {
                Class.forName("com.mysql.jdbc.Driver");
                
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
         
         pst2=con.prepareStatement("select * from conta where cartao=?");
          
                     
       
                       pst2.setString(1,dc);
                       rs=pst2.executeQuery();
                       
                       //Se isso for verdade significa que a conta existe e ira retornar todos os dados da conta
                      if(rs.next()==true){
                          
                          System.out.println("Conta encontrada");
                          
                          //Caso a conta existe ele ira mostrar as informacoes da conta usando o codigo abaixo
                          
                          String y1=rs.getString("nome");
                          System.out.println("Nome: "+ y1);
                          
                          String y3=rs.getString("tipoCon");
                          System.out.println("Tipo de conta: "+y3);
                          
                          String y2=rs.getString("saldo");
                          System.out.println("Saldo: "+y2);
                           
                          System.out.println("Deseja apagar a seguinte conta?");
                          String apagar=x.nextLine();
                          
                          if(apagar.equalsIgnoreCase("sim")){
                              
                              
                             pst3=con.prepareStatement("DELETE FROM conta WHERE cartao=?");
                             
                             pst3.executeUpdate();
                              
                              
                          }
                          
                          
                          
                               }
                      else{
                          System.out.println("Essa conta nao existe");
                      }         
                        
                        
         
         
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
        
                   case 3:
                       System.out.println("Gerar Relatorio");
                       
                       System.out.println("Todas as contas disponiveis no sistema");
                       
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
 
                
                pst6=con.prepareStatement("select * from  conta");
               rs=pst6.executeQuery();
                
               while(rs.next()){
               
                System.out.println("nome: "+rs.getString("nome")+" // "+ "Numero do cartao: "+rs.getString("cartao")+" // "+" Saldo: "+rs.getString("saldo")+" // " +" Tipo de conta: "+rs.getString("tipoCon") );
               
               
               }
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
        }
         

                       
                       
 
           
            case 2:
                
                
                System.out.println("Oque Deseja");
                System.out.println("1]---Depositar---");
                System.out.println("2]---Levantar---");
                System.out.println("3]---Transferir---");
                System.out.println("4]---Mostar dados de uma conta---");
                
               int desejo=x.nextInt();
               
               switch(desejo){
                   
                   case 1:
                       
                       System.out.println("Area de deposito");
                       
                       String l=x.nextLine();
                     System.out.println("Digite o numero do seu cartao");
                       String numC=x.nextLine();
     
                         ce.setTen(numC);
                         
                         String dc=ce.getTen();
                         
                        try {
                Class.forName("com.mysql.jdbc.Driver");
                
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
         
         pst2=con.prepareStatement("select * from conta where cartao=?");
          
                     
       
                       pst2.setString(1,dc);
                       rs=pst2.executeQuery();
                       
                       //Se isso for verdade significa que a conta existe e ira perguntar quanto se deseja depositar
                      if(rs.next()==true){
                          
                          System.out.println("Conta encontrada");
                          
                          System.out.println("Digite o valor que deseja depositar");
                          String valor =x.nextLine();
                          
                          ce.setValor(valor);
                          
                          String val=ce.getValor();
                          
                          
                          
                          //Depois ira atualizar o saldo  na conta do cliente usando o codigo abaixo
                         pst5=con.prepareStatement("update conta set saldo = saldo+ ? where cartao=?");
                        pst5.setString(1, val);
                        pst5.setString(2, dc);
                         pst5.executeUpdate();
                         
                          String c1=rs.getString("nome");
                           
                          System.out.println("Deposito realizado com sucesso, na conta de "+c1+" Vc depositou "+val);
                            
                          
                      }
                      
                      else{
                          System.out.println("Essa conta nao existe");
                      }
               
               
               } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        }
break;

                   case 2:
                       
                       System.out.println("Levantamento");

          String l1=x.nextLine();
                     System.out.println("Digite o numero do seu cartao");
                       String numC1=x.nextLine();
     
                         ce.setTen(numC1);
                         
                         String dc1=ce.getTen();
                         
                        try {
                Class.forName("com.mysql.jdbc.Driver");
                
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
         
         pst2=con.prepareStatement("select * from conta where cartao=?");
          
                     
       
                       pst2.setString(1,dc1);
                       rs=pst2.executeQuery();
                       
                       //Se isso for verdade significa que a conta existe e ira ......
                      if(rs.next()==true){
                          
                          System.out.println("Conta encontrada");
                          
                          System.out.println("Digite o valor que deseja levantar");
                          String valor =x.nextLine();
                          
                          ce.setValor(valor);
                          
                          String val=ce.getValor();
                          
                          
                          //Codigo para fazer levantamento
                          
                         pst5=con.prepareStatement("update conta set saldo = saldo- ? where cartao=?");
                        pst5.setString(1, val);
                        pst5.setString(2, dc1);
                         pst5.executeUpdate();
                         
                          System.out.println("Vc retirou: "+ val+"MT "+" da sua conta");

                      }
                      else{
                          System.out.println("Essa conta nao existe");
                      }
                      
                   } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                        break;
                     
                        
                        
                   case 3:
                       System.out.println("Transferencia");
                         
                        String l2=x.nextLine();
                     System.out.println("Digite o numero do seu cartao");
                       String numC2=x.nextLine();
     
                         ce.setTen(numC2);
                         
                         String dc2=ce.getTen();
                         
                        try {
                Class.forName("com.mysql.jdbc.Driver");
                
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
         
         pst2=con.prepareStatement("select * from conta where cartao=?");
          
                     
       
                        pst2.setString(1,dc2);
                       rs=pst2.executeQuery();
                       
                       //Se isso for verdade significa que a conta existe e ira retornar todos os dados da conta
                      if(rs.next()==true){
                          
                          System.out.println("Digite a  conta que vai receber o valor");
                          String valR=x.nextLine();
                           
                        pst2.setString(1,valR);
                       rs=pst2.executeQuery();
                       
                       if(rs.next()==true){
                    
                        
                         System.out.println("Digite o valor que deseja enviar");
                          String valor =x.nextLine();
                          
                          ce.setValor(valor);
                          
                          String val=ce.getValor();
                          
                          
                          
                          
                         pst5=con.prepareStatement("update conta set saldo = saldo- ? where cartao=?");
                        pst5.setString(1, val);
                        pst5.setString(2, dc2);
                         pst5.executeUpdate(); 
                         
                         
                         
                          pst5=con.prepareStatement("update conta set saldo = saldo+ ? where cartao=?");
                        pst5.setString(1, val);
                        pst5.setString(2, valR);
                         pst5.executeUpdate(); 
                         
                           System.out.println("Transferencia realizada com Sucesso");
                       }
                       else{
                           
                           System.out.println("Essa conta nao existe");
                       }

        }  
                      else{
                          System.out.println("Essa conta nao existe");
                      }
    }       catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            } 
 
                    break;
                    
                   case 4: 
                        
                                              
                       String v=x.nextLine();
                         System.out.println("Digite o numero do cartao da conta que deseja encontrar");
                       String numC3=x.nextLine();
     
                         ce.setTen(numC3);
                         
                         String cn=ce.getTen();
                         
                        try {
                Class.forName("com.mysql.jdbc.Driver");
                
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","");
         
         pst2=con.prepareStatement("select * from conta where cartao=?");
          
                     
       
                       pst2.setString(1,cn);
                       rs=pst2.executeQuery();
                       
                      if(rs.next()==true){
                          
                          System.out.println("Conta encontrada");

                          
                          String y1=rs.getString("nome");
                          System.out.println("Nome: "+ y1);
                          
                          
                          String y4=rs.getString("cartao");
                          System.out.println("Numero do cartao: "+y4);
                          
                          String y3=rs.getString("tipoCon");
                          System.out.println("Tipo de conta: "+y3);
                          
                          String y2=rs.getString("saldo");
                          System.out.println("Saldo: "+y2);
                           
                      }
                          
                        
                      else{
                          System.out.println("Essa conta nao existe");
                      }
                      
                       }       catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseExecutavel.class.getName()).log(Level.SEVERE, null, ex);
            }
                        break;
               
                        
    }
              break;
    }
}
    }}


    

           
               
               
               
              

    
            
       
            

        
        
        
    
    
    

