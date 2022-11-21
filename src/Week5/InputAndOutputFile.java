import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutputFile {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream("src/Week5/input1.txt");
            fout = new FileOutputStream("src/Week5/output1.txt");

            int i;
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
