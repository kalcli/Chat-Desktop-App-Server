/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.esgis.server;

import Controller.TCPServer;
import Database.DbConnection;
import java.io.IOException;



/**
 *
 * @author mike
 */
public class ChatDesktopAppServer {
    
    private static int port = 4444;

    public static void main(String[] args) throws IOException {
        System.out.println("🔗 Tentative de connexion à la base de données...");
        DbConnection con = new DbConnection();
        TCPServer server = new TCPServer();
        server.start(port);
    }
}
