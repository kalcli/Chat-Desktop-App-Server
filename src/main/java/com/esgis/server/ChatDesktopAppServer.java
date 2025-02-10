/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.esgis.server;

import Database.DbConnection;
import java.sql.Connection;

/**
 *
 * @author mike
 */
public class ChatDesktopAppServer {

    public static void main(String[] args) {
        System.out.println("🔗 Tentative de connexion à la base de données...");
        
        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Connexion réussie !");
        } else {
            System.out.println("❌ Échec de la connexion.");
        }
    }
}
