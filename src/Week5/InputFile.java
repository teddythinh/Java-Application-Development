import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputFile {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("src/Week5/input1.txt");
            int i;
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            }
            while (i != -1);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
