import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            byte data[] = new byte[10];
            System.out.print("Enter something: ");
            System.in.read(data);
            for(int i = 0; i < data.length; i++) {
                System.out.println(data[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
