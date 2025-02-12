/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mike
 */
public class TCPServer {
    private ServerSocket ServerSocket;
       
    public void start(int port) throws IOException {
        ServerSocket = new ServerSocket(port);
        System.out.println("Serveur demarre sur le port" + port);
        while(true){
            new TcpClientHandler(ServerSocket.accept()).start();
        }
        
    }
    
    public void stop() throws IOException{
        ServerSocket.close();
    }
    
    private static class TcpClientHandler extends Thread{
        private Socket clientSocket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;
        
        public TcpClientHandler(Socket socket){
            this.clientSocket = socket;
        }
        
        @Override
        public void run(){
            try {
                oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ois = new ObjectInputStream(clientSocket.getInputStream());
                System.out.println("Connexion acceptée pour : " + clientSocket.getRemoteSocketAddress());
                
                //Lecture des informations d'identifications
                User credentials = (User) ois.readObject();
                System.out.println("Tentative de connexion : " + credentials);
                
                String username = credentials.getUsername();
                String passwd = credentials.getPassword();
                
                //Verification des informations
                UserController check = new UserController();
                User res = check.loginUser(username, passwd);
                
                //Renvoie des informations au client
                oos.writeObject(res);
                
                stopClient();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        public void stopClient() throws IOException{
            oos.close();
            ois.close();
            clientSocket.close();
        }
        
    }
    
}
