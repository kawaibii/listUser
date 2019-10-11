/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kinn007
 */
public class client {
    private Socket socket;
    private InetAddress host;
    private int port;
    public static ArrayList<users> listuser;
   public client(InetAddress host, int port){
       this.host=host;
       this.port=port;
   }
   public void runClient() throws IOException{
       socket=new Socket(host, port);
       WriteThread write=new WriteThread(socket);
       write.start();
       readThread read=new readThread(socket);
       read.start();
   }
   
}
class WriteThread extends Thread{
    private Socket socket;
    private Scanner sc;
    public WriteThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        sc=new Scanner(System.in);
        System.out.println("tai khoan: ");
        String name=sc.nextLine();
        System.out.println("mat khau");
        String password=sc.nextLine();
        users user=new users(name, password);
        try {
            ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(user);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(WriteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
class readThread extends Thread{
    private Socket socket;
    public readThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
            while(true){
                users user=(users)input.readObject();
                System.out.println(user.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(readThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}