/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steam;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 *
 * @author JoseLuis
 */
public class Steam {
    private RandomAccessFile codStm,plaStm,gamStm;
     public Steam(){
         try {
             //Aseguro Carpeta steam y download
              File f=new File("steam/downloads");
              f.mkdirs();
              //Instancio los atributos
              codStm= new RandomAccessFile("steam/codes.stm","rw");
              plaStm=new RandomAccessFile("steam/players.stm","rw");
              gamStm=new RandomAccessFile("steam/games.stm","rw");
              //Inicio codigo
                initCode();
         } catch (IOException e) {
             System.out.println("No debe pasar!");
         }
       
    }
     //Codigo de inicio de datos
    private void initCode() throws IOException{
        if(codStm.length()==0){
            codStm.writeInt(1);
            codStm.writeInt(1);
            codStm.writeInt(1);
        }
    }
    //Recibir Codigos
    private int getCodeStm(char letra) throws IOException{
         int codigo=0;
        switch(letra){
            case 'g':
                codStm.seek(0);
                 codigo=codStm.readInt();
                break; 
            case 'p':
                codStm.seek(0);
                codStm.skipBytes(4);
                codigo=codStm.readInt();
                break;
            case 'd':
                codStm.seek(0);
                codStm.skipBytes(8);
                codigo=codStm.readInt();
                break;
            
        }
        
        return codigo;
    }
    //Add Game
    public void addGame(String titulo,char SO,int edadMin,double precio)throws IOException{
        gamStm.seek(gamStm.length());
        gamStm.writeInt(getCodeStm('g'));
        gamStm.writeUTF(titulo);
        gamStm.writeChar(SO);
        gamStm.writeInt(edadMin);
        gamStm.writeDouble(precio);
        gamStm.writeInt(0);
    }
    //Add player
    public void addPlayer(String nombre, long nacimiento)throws IOException{
        plaStm.seek(plaStm.length());
        plaStm.writeInt(getCodeStm('p'));
        plaStm.writeUTF(nombre);
        plaStm.writeLong(nacimiento);
        plaStm.writeInt(0);
    }
    //DownloadGame
    public boolean downloadGame(int codeGame,int codePlayer,char SO)throws IOException{
       
        
        return false;
    }
    //searchPlayer
    private int  searchPlayer(int code)throws IOException{
        plaStm.seek(0);
        Calendar date= Calendar.getInstance();
        int year=date.get(Calendar.YEAR);
        while(plaStm.getFilePointer()<plaStm.length()){
            int codigo=plaStm.readInt();
            plaStm.readUTF();
            date.setTimeInMillis(plaStm.readLong());
            int edad= year-date.get(Calendar.YEAR);
            plaStm.skipBytes(4);
            if(code== codigo){
                return edad;
            }
                
        }
        return -1;
                
    }
    //searchGame
     private int searchGame(int code)throws IOException{
        gamStm.seek(0);
        while(gamStm.getFilePointer()<gamStm.length()){
            int codigo=gamStm.readInt();
                gamStm.readUTF();
                gamStm.readChar();
                int edad=gamStm.readInt();
                gamStm.skipBytes(12);
                if(code== codigo){
                return edad;
            }
                
        }
        return -1;
                
    }
     //searchSO
     private boolean searchSO(int code,char so)throws IOException{
         gamStm.seek(0);
        while(gamStm.getFilePointer()<gamStm.length()){
            int codigo=gamStm.readInt();
                gamStm.readUTF();
                char letra=gamStm.readChar();
                gamStm.skipBytes(20);
                if(code== codigo && letra==so){
                return true;
            }
                
        }
        return false;
     }
     
}
