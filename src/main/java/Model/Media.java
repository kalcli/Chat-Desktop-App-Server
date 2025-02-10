/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mike
 */
public class Media {
    
    private int id_media;
    private String media_type;
    private String media_file_path;
    private int id_message;
    
    // Constructeur par défaut
    public Media() {}

    // Constructeur avec tous les attributs
    public Media(int id_media, String media_type, String media_file_path, int id_message) {
        this.id_media = id_media;
        this.media_type = media_type;
        this.media_file_path = media_file_path;
        this.id_message = id_message;
    }

    // Constructeur sans ID (pour insertion en base de données)
    public Media(String media_type, String media_file_path, int id_message) {
        this.media_type = media_type;
        this.media_file_path = media_file_path;
        this.id_message = id_message;
    }

    // Constructeur sans message associé (dans le cas d'un média indépendant)
    public Media(String media_type, String media_file_path) {
        this.media_type = media_type;
        this.media_file_path = media_file_path;
    }
    
    // Getters
    public int getId_media() {
        return id_media;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getMedia_file_path() {
        return media_file_path;
    }

    public int getId_message() {
        return id_message;
    }
    
    // Setters
    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public void setMedia_file_path(String media_file_path) {
        this.media_file_path = media_file_path;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
    
    // Méthode d'affichage
    public void display() {
        System.out.println("ID Média: " + id_media);
        System.out.println("Type: " + media_type);
        System.out.println("Chemin du fichier: " + media_file_path);
        System.out.println("ID Message associé: " + (id_message != 0 ? id_message : "Aucun"));
        System.out.println("------------------------------");
    }
    
}
