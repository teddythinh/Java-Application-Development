import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server2 {
    public static void main(String []args) {
        ServerSocket server = null;
        try {
            int serverPort = 5000;
            server = new ServerSocket(serverPort);
            System.out.println("Server started");
            while (true) {
                System.out.println("Waiting for a client...");
                Socket client = server.accept();
                Thread t = new Thread(() -> {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                        String name = reader.readLine();
                        System.out.println(name + " has joined");

                        while(true) {
                            String line = reader.readLine();
                            System.out.println(name + ": " + line);

                            // broadcast to all clients
                            writer.write(name + ": " + line);
                            writer.newLine();
                            writer.flush();

                            if(line.compareToIgnoreCase("Good bye") == 0) {
                                System.out.println(name + " has left");
                                break;
                            }
                        }
                        client.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                t.start();
                System.out.println("Client localhost:" + serverPort + " connected");

            }
        } catch (Exception ex) {
            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(server != null) try {
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

