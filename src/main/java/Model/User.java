/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author mike
 */
public class User implements Serializable {
    private int id_user;
    private String username;
    private String passwd;
    private String fullname;
    private String fonction;
    private boolean status;
    
    // Constructeur par défaut
    public User() {}

    // Constructeur avec tous les attributs
    public User(int id_user, String username, String password, String fullname, String fonction, boolean status) {
        this.id_user = id_user;
        this.username = username;
        this.passwd = password;
        this.fullname = fullname;
        this.fonction = fonction;
        this.status = status;
    }

    // Constructeur utilise pour envoyer les informations d'identification
    public User(String username, String password) {
        this.username = username;
        this.passwd = password;
    }

    // Constructeur sans mot de passe (sécurité, si on ne veut pas exposer le password)
    public User(int id_user, String username, String fullname, String fonction, boolean status) {
        this.id_user = id_user;
        this.username = username;
        this.fullname = fullname;
        this.fonction = fonction;
        this.status = status;
    }
    
    // Getters
    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return passwd;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFonction() {
        return fonction;
    }

    public boolean isStatus() {
        return status;
    }
    
    // Setters
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    // Méthode d'affichage
    public void display() {
        System.out.println("ID: " + id_user);
        System.out.println("Nom d'utilisateur: " + username);
        System.out.println("Nom complet: " + fullname);
        System.out.println("Fonction: " + fonction);
        System.out.println("Statut: " + (status ? "Actif" : "Inactif"));
        System.out.println("------------------------------");
    }
    
    
    
}
