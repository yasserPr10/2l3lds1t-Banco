/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoyr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP CQ58
 */
public class MetodosDaClasseEx {
      Scanner x = new Scanner(System.in);
        PreparedStatement pst;
        PreparedStatement pst2;
        PreparedStatement pst3;
        ResultSet rs;
        Connection con;      
       Conta ce=new Conta(); 
       
       
    //Metodo para criar a conta e adiocionar no banco de dados
     public void conta(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(rand.nextInt(10));
        }
        String cartaoCredito = sb.toString();
        
      
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
    
    
    
     }

     
     public void Pesquisar(){
           //Codigo para pesquisar a conta
                       
                       System.out.println("Pesquisando conta");
                         
                         System.out.println("Digite o numero do seu cartao");
                       String numC=x.nextLine();
     
                         ce.setTen(numC);
                         
                         String dc=ce.getTen();
                                                 //Codigo para pesquisar a conta

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
                              
                             pst3=con.prepareStatement("delete from conta where cartao=? ");
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

         
     }
     
     
     
}


