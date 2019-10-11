/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author kinn007
 */
public class users implements Serializable{
    private String username;
     private String password;
     private Socket socket;
    // cong cua user
    private int port;
    private int status;
    public users(String name,String password){
        this.username=name;
        this.password=password;
        socket=null;
        port=0;
        status=0;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    // trang thai user;
   
 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String toString(){
        return username+" "+password+"da ket noi voi client voi cong"+port;
    }
}
