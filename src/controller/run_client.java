/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.InetAddress;

import java.net.UnknownHostException;
import model.client;

/**
 *
 * @author kinn007
 */
public class run_client {
    public static void main(String[] args) throws UnknownHostException, IOException  {
        client clients=new client(InetAddress.getLocalHost(), 6655);
        clients.runClient();
    }
  
}
