import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer {
    public static void main(String []args) {
        try {
            int serverPort = 2000;
            ServerSocket socket1;
            socket1 = new ServerSocket(serverPort);
            System.out.println("Waiting for client...");

            Socket socket = socket1.accept();
            System.out.println("A client is connected.");

            // read dữ liệu thông qua Reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true) {
                String s = reader.readLine();
                System.out.println("Client1: " + s);

                writer.write("Hello");
                writer.newLine();
                writer.flush(); // đảm bảo gửi luôn chứ không đợi buffer

                if(s.compareToIgnoreCase("exit") == 0) {
                    break;
                }
            }
            System.out.println("Client1 is disconnected");
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
