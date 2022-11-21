import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("src/Week5/input.txt");
            int count = 0;
            Scanner sc = new Scanner(fin);
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            System.out.println("Number of words: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
