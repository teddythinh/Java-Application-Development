import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class loginForm extends JFrame implements ActionListener {
    // implement all components
    private final JLabel titleLabel, usernameLabel, passwordLabel, notificationLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton submitButton;

    // create a login form
    public loginForm() {
        super("Login Form");
        // choose the BoxLayout for the form
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(new Dimension(250, 200));
        // add text and configure fields and button
        titleLabel = new JLabel("LOGIN FORM");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        submitButton = new JButton("Submit");
        notificationLabel = new JLabel(" ");

        // add components to the form
        add(titleLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(notificationLabel);
        add(submitButton);

        // set the exit program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the event listeners to the button
        submitButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = passwordField.getText();
        String line;
        try {
            // read the username and password separated by spaces
            FileReader fileReader = new FileReader("src/Week7/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (username.equals(parts[0]) && password.equals(parts[1])) {
                    notificationLabel.setText("Login Successful");
                    break;
                } else {
                    notificationLabel.setText("Login Failed");
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file");
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    public static void main(String[] args) {
        new loginForm();
    }
}