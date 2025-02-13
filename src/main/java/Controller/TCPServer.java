package Controller;

import Model.User;
import Model.LoginResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TCPServer {
    private ServerSocket serverSocket;
       
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serveur démarré sur le port " + port);
        while (true) {
            new TcpClientHandler(serverSocket.accept()).start();
        }
    }
    
    public void stop() throws IOException {
        serverSocket.close();
    }
    
    private static class TcpClientHandler extends Thread {
        private Socket clientSocket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;

        public TcpClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ois = new ObjectInputStream(clientSocket.getInputStream());
                System.out.println("Connexion acceptée pour : " + clientSocket.getRemoteSocketAddress());

                // Lecture des informations d'identification
                User credentials = (User) ois.readObject();
                System.out.println("Tentative de connexion : " + credentials.getUsername());

                String username = credentials.getUsername();
                String passwd = credentials.getPassword();

                // Vérification des informations
                UserController userController = new UserController();
                User res = userController.loginUser(username, passwd);

                if (res != null) {
                    System.out.println("Connexion réussie pour : " + res.getUsername());

                    // Récupérer la liste des utilisateurs
                    List<User> userList = userController.getAllUser();

                    // Créer l'objet de réponse et l'envoyer
                    LoginResponse response = new LoginResponse(res, userList);
                    oos.writeObject(response);
                } else {
                    // Envoyer une réponse négative (utilisateur non authentifié)
                    oos.writeObject(null);
                }

                stopClient();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void stopClient() throws IOException {
            oos.close();
            ois.close();
            clientSocket.close();
        }
    }
}
