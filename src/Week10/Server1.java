import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server1 {
    public static void main(String[] args) {
        try {
            int serverPort = 5000;
            ServerSocket server = new ServerSocket(serverPort);
            System.out.println("Server started");
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Client localhost:" + serverPort + " connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            while (true) {
                String line = reader.readLine();
                System.out.println("Client: " + line);

                if (line.compareToIgnoreCase("Hello, my name is NAME") == 0) {
                    writer.write("Hello, NAME");
                    writer.newLine();
                    writer.flush();
                } else if (line.compareToIgnoreCase("Good bye") == 0) {
                    writer.write("Good bye");
                    writer.newLine();
                    writer.flush();
                    break;
                } else {
                    writer.write("I've received this message from you: " + "..[" + line + "]...");
                    writer.newLine();
                    writer.flush();
                }
            }
            client.close();
            server.close();

        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
