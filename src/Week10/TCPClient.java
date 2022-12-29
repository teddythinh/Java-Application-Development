import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {
    public static void main(String []args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = null;
        try {
            String serverIP = "localhost";
            int serverPort = 2000;

            socket = new Socket(serverIP, serverPort);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true) {
                System.out.print("Input a message: ");
                String line = sc.nextLine();

                writer.write(line);
                writer.newLine();
                writer.flush();

                String line2 = reader.readLine();
                System.out.println("Server: " + line2);

                if (line.compareToIgnoreCase("Good bye") == 0) {
                    break;
                }
            }
        } catch (IOException e) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            try {
                assert socket != null;
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
