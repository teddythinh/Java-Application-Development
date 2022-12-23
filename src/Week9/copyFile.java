import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class copyFile extends JFrame implements ActionListener {
    private final JTextField sourceFile, destinationDirectory;
    private final JButton button;

    public copyFile() {
        super("Copy File");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(new Dimension(250, 200));

        JLabel label1 = new JLabel("Source File");
        JLabel label2 = new JLabel("Destination Directory");
        sourceFile = new JTextField(200);
        destinationDirectory = new JTextField(200);
        button = new JButton("Copy");

        this.add(label1);
        this.add(sourceFile);
        this.add(label2);
        this.add(destinationDirectory);
        this.add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            File sourceFile = new File(this.sourceFile.getText());
            File destinationDirectory = new File(this.destinationDirectory.getText());
            copyFileToDirectory(sourceFile, destinationDirectory);
        }
    }

    public static void copyFileToDirectory(File sourceFile, File destinationDirectory) {
        try {
            File destinationFile = new File(destinationDirectory, sourceFile.getName());
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destinationFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new copyFile();
    }

}