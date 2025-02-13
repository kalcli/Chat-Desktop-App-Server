/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DbConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike
 */
public class UserController {
    private final DbConnection dbcon = new DbConnection();
    private final Connection con;
    private String query = "";
    private PreparedStatement ps;
    ResultSet set;
    User user;

    public UserController() {
        this.con = dbcon.con;

    }
    
    public List<User> getAllUser() {
        List<User> UserList = new ArrayList<>();
        query = "select * from User";
       
        
       
        try {
            ps = con.prepareStatement(query);
             set = ps.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId_user(set.getInt("id_user"));
                user.setUsername(set.getString("username"));
                user.setFullname(set.getString("fullname"));
                user.setFonction(set.getString("fonction"));
                user.setStatus(set.getBoolean("status"));
                UserList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UserList;
    }
    
    public User getUserById(int id_user) {
        User user = null;
        query = "SELECT * FROM User WHERE id_user = ?";

        try{
            ps = con.prepareStatement(query);
            ps.setInt(1, id_user);
            set = ps.executeQuery();
            if (set.next()) {
                user = new User();
                user.setId_user(set.getInt("id_user"));
                user.setUsername(set.getString("username"));
                user.setFullname(set.getString("fullname"));
                user.setFonction(set.getString("fonction"));
                user.setStatus(set.getBoolean("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public User loginUser(String username, String passwd) {
    User user = null;
    query = "SELECT * FROM User WHERE username = ? AND passwd = ?";

    try {
        ps = con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, passwd);
        set = ps.executeQuery();

        if (set.next()) {
            user = new User();
            user.setId_user(set.getInt("id_user"));
            user.setUsername(set.getString("username"));
            user.setFullname(set.getString("fullname"));
            user.setFonction(set.getString("fonction"));
            user.setStatus(set.getBoolean("status"));

            // Mettre à jour le statut de l'utilisateur à 1 (connecté)
            String updateQuery = "UPDATE User SET status = 1 WHERE id_user = ?";
            try (PreparedStatement updatePs = con.prepareStatement(updateQuery)) {
                updatePs.setInt(1, user.getId_user());
                updatePs.executeUpdate();
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    }
        return user;
    }
    
    public void logoutUser(int id_user) {
    query = "UPDATE User SET status = 0 WHERE id_user = ?";

    try {
        ps = con.prepareStatement(query);
        ps.setInt(1, id_user);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    
    

    
}
       
      
        

       
    
    
