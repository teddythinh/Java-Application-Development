import java.io.*;
import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        // Write a program that counts the number of lines of an input file.
        FileInputStream file = null;
        Scanner sc = null;
        int count = 0;
        try {
            file = new FileInputStream("src/Week5/input.txt");
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            System.out.println("Number of lines in the file: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}