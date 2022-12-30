import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client2 {
    public static void main(String []args) {
        Socket client = null;
        try {
            String serverIP = "localhost";
            int serverPort = 5000;

            Scanner scanner = new Scanner(System.in);
            client = new Socket(serverIP, serverPort);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            // Send name to server
            writer.write(name);
            writer.newLine();
            writer.flush();



            while(true) {
                System.out.print(name + ": ");
                String line = scanner.nextLine();

                writer.write(line);
                writer.newLine();
                writer.flush();

                String line2 = reader.readLine();
                System.out.println(line2);

                if (line.compareToIgnoreCase("Good bye") == 0) {
                    break;
                }
            }
            scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                assert client != null;
                client.close();
            } catch (IOException ex) {
                Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

