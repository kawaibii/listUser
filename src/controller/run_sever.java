/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.sever;

/**
 *
 * @author kinn007
 */
public class run_sever {
    public static void main(String[] args) {
        try {
            sever server=new sever(6655);
            server.svrun();
        } catch (IOException ex) {
            Logger.getLogger(run_sever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
