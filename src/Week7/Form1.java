import javax.swing.*;
import java.awt.*;

public class Form1 extends JFrame {
    public Form1() {
        this.setSize(new Dimension(275, 100));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng cửa sổ thì chương trình kết thúc

        JLabel label1 = new JLabel("Hello World!");
        this.add(label1); // add label vào thì mới hiển thị
        // this.getContentPane().add(label1); // cách khác để add label
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Form1 form1 = new Form1();
                form1.setVisible(true); // show lên màn hình
            }
        });
    }
}
