/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.esgis.server;

import Database.DbConnection;

import Controller.UserController;
import Model.User;
import java.util.List;

/**
 *
 * @author mike
 */
public class ChatDesktopAppServer {

    public static void main(String[] args) {
        System.out.println("🔗 Tentative de connexion à la base de données...");
        DbConnection con = new DbConnection();
        UserController userC = new UserController();
        User user = userC.getUserById(1);
        user.display();
        
        
    }
}
