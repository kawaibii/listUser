/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kinn007
 */
public class sever {
   private ServerSocket server;
   private int port;
   public static ArrayList<users> listuser;
   public static ArrayList<Socket> listsocket;
   public sever(int port){
       this.port=port;
   }
   public void svrun() throws IOException{
        listuser=new ArrayList<>();
        listsocket=new ArrayList<>();
        server=new ServerSocket(port);
          writeClientThread write=new writeClientThread();
            write.start();
        while(true){
           Socket socket=server.accept();
            System.out.println("da ket noi voi "+socket);
            listsocket.add(socket);
            readClientThread read=new readClientThread(socket);
            read.start();
        }
   }
}

class readClientThread extends Thread{
    private Socket socket;
    public readClientThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
            users user=(users) input.readObject();
            // luu cong ket noi cua client
            user.setPort(socket.getPort());
            System.out.println(user.toString());
            sever.listuser.add(user);
        } catch (IOException ex) {
            Logger.getLogger(readClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
// gui cho client phai nhan send
class writeClientThread extends Thread{

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        String temp=sc.nextLine();
        if(temp.equals("send")){
            for(Socket temps :sever.listsocket){
                try {
                    ObjectOutputStream output=new ObjectOutputStream(temps.getOutputStream());
                    for(users userc:sever.listuser){
                        output.writeObject(userc);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(writeClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

       
}