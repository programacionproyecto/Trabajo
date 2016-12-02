/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steam;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JoseLuis
 */
public class TestSteam {
    
    static Scanner lea = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        int opc=lea.nextInt();
        
        do{
        System.out.println("1. - AddGame");
        System.out.println("2. - AddPlayer");
        System.out.println("3. - DownloadGame");
        System.out.println("4. - UpdatePriceFor");
        System.out.println("5. - ReportForClient");
        System.out.println("6. - PrintGames");
        System.out.println("7. - Salir");
        
        try{
        switch(opc){
            case 1:
                char opc2=lea.next().charAt(0);
                boolean estado=true;
                String n = lea.next();
                char so=opc2;
                do{
                
                switch(opc2){
                    case 'W':
                        so='W';
                     break;
                    case 'M':
                        so='M';
                     break;
                    case 'L':
                        so='L';
                     break;   
                }
                }while(estado);
                double p= lea.nextDouble();
                /*addGame(n,so,p);*/          
             break;
             case 2:
                 String nombre =lea.next();
                /*addPlayer(nombre)*/
             break;
             case 3:
                 int codigoj=lea.nextInt();
                 int codigoc=lea.nextInt();
                 char opc3=lea.next().charAt(0);
                 boolean estado2=true;
                 char s=opc3;
                  do{
                
                switch(opc3){
                    case 'W':
                        so='W';
                     break;
                    case 'M':
                        so='M';
                     break;
                    case 'L':
                        so='L';
                     break;   
                }
                }while(estado2);
                 
                /*downloadGame(codigoj, codigoc, s)*/
             break;
             case 4:
                 int cvg=lea.nextInt();
                 double np=lea.nextDouble();
                /*updatePriceFor(cvg,np)*/
             break;
             case 5:
                 int ccli = lea.nextInt();
                  String dato="";
                 do{
                System.out.println("Escriba algo: ");
                 dato += lea.nextLine();
                if(!dato.equals(":q")){
                    System.out.println(dato+"\r\n");
                    
                }
                else
                    break;
                
            }while(true);
                /*reportForClient(ccli, dato)*/
             break;
             case 6:
                /*printGame()*/
             break;
             case 7:
                /*Salir*/
             break;   
        }
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingrese una opcion Correcta");
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        }while(opc != 8);
        
    }
}
