import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class news
        extends JFrame
        implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel title2;
    private JLabel title3;
    private JButton launch;
    

    public news() {
        setTitle("Home");
        setBounds(500, 100, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // title = new JLabel("Finolex Academy of ");
        // title.setFont(new Font("Arial", Font.PLAIN, 25));
        // title.setSize(300, 30);
        // title.setLocation(180, 30);
        // c.add(title);

        // title2 = new JLabel("Management and Technology");
        // title2.setFont(new Font("Arial", Font.PLAIN, 25));
        // title2.setSize(350, 30);
        // title2.setLocation(130, 80);
        // c.add(title2);

        // title3 = new JLabel("Ratnagiri");
        // title3.setFont(new Font("Arial", Font.PLAIN, 25));
        // title3.setSize(350, 30);
        // title3.setLocation(230, 130);
        // c.add(title3);

        title3 = new JLabel("'Student Management System'");
        title3.setFont(new Font("Arial", Font.PLAIN, 30));
        title3.setSize(500, 30);
        title3.setLocation(100, 100);
        c.add(title3);


        Icon icon = new ImageIcon("famt.png");
        title3 = new JLabel(icon);
        title3.setSize(350, 100);
        title3.setLocation(115, 150);
        c.add(title3);
       

        launch = new JButton("Launch");
        launch.setBounds(190, 300, 200, 50);
        add(launch);
        launch.addActionListener(this);
       
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == launch) {
            Login L = new Login();
        }

    }

}

class Home {

    public static void main(String[] args) throws Exception {
        news L = new news();
    }
}

