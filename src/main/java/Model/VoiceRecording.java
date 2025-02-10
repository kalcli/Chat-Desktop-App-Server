/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mike
 */
public class VoiceRecording {
    
    private int id_enregistrement;
    private String register_file_path;
    private int id_message;
    
    // Constructeur par défaut
    public VoiceRecording() {}

    // Constructeur avec tous les attributs
    public VoiceRecording(int id_enregistrement, String register_file_path, int id_message) {
        this.id_enregistrement = id_enregistrement;
        this.register_file_path = register_file_path;
        this.id_message = id_message;
    }

    // Constructeur sans ID (pour insertion en base de données)
    public VoiceRecording(String register_file_path, int id_message) {
        this.register_file_path = register_file_path;
        this.id_message = id_message;
    }
    
    // Getters
    public int getId_enregistrement() {
        return id_enregistrement;
    }

    public String getRegister_file_path() {
        return register_file_path;
    }

    public int getId_message() {
        return id_message;
    }
    
    // Setters
    public void setId_enregistrement(int id_enregistrement) {
        this.id_enregistrement = id_enregistrement;
    }

    public void setRegister_file_path(String register_file_path) {
        this.register_file_path = register_file_path;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
    
    // Méthode d'affichage
    public void display() {
        System.out.println("ID Enregistrement: " + id_enregistrement);
        System.out.println("Chemin du fichier d'enregistrement: " + register_file_path);
        System.out.println("ID Message associé: " + (id_message != 0 ? id_message : "Aucun"));
        System.out.println("------------------------------");
    }
    
}
