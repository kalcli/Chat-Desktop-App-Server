/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author mike
 */
public class Message {
    
    private int id_message;
    private String text_content;
    private LocalDateTime sending_date;
    private int sender_user_id;
    private int recipient_user_id;
    
    // Constructeur par défaut
    public Message() {}

    // Constructeur avec tous les attributs
    public Message(int id_message, String text_content, LocalDateTime sending_date, int sender_user_id, int recipient_user_id) {
        this.id_message = id_message;
        this.text_content = text_content;
        this.sending_date = sending_date;
        this.sender_user_id = sender_user_id;
        this.recipient_user_id = recipient_user_id;
    }

    // Constructeur sans ID (pour insertion en base de données)
    public Message(String text_content, LocalDateTime sending_date, int sender_user_id, int recipient_user_id) {
        this.text_content = text_content;
        this.sending_date = sending_date;
        this.sender_user_id = sender_user_id;
        this.recipient_user_id = recipient_user_id;
    }

    // Constructeur sans date d'envoi (la base de données gère la date automatiquement)
    public Message(String text_content, int sender_user_id, int recipient_user_id) {
        this.text_content = text_content;
        this.sender_user_id = sender_user_id;
        this.recipient_user_id = recipient_user_id;
        this.sending_date = LocalDateTime.now(); // Définit la date actuelle
    }
    
    // Getters
    public int getId_message() {
        return id_message;
    }

    public String getText_content() {
        return text_content;
    }

    public LocalDateTime getSending_date() {
        return sending_date;
    }

    public int getSender_user_id() {
        return sender_user_id;
    }

    public int getRecipient_user_id() {
        return recipient_user_id;
    }
    
    // Setters
    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public void setSending_date(LocalDateTime sending_date) {
        this.sending_date = sending_date;
    }

    public void setSender_user_id(int sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public void setRecipient_user_id(int recipient_user_id) {
        this.recipient_user_id = recipient_user_id;
    }
    
    // Méthode d'affichage
    public void display() {
        System.out.println("ID Message: " + id_message);
        System.out.println("Contenu: " + text_content);
        System.out.println("Date d'envoi: " + sending_date);
        System.out.println("Expéditeur ID: " + sender_user_id);
        System.out.println("Destinataire ID: " + recipient_user_id);
        System.out.println("------------------------------");
    }
    
}
