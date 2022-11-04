import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login
        extends JFrame
        implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel user;
    private JLabel pass;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JButton reg;
    private JComboBox actype;
    private String actypes[] = {
            "Student",
            "Teacher",
            "HOD",
            "Principle",
            "Admin"
    };
    Integer close = 0;

    public Login() {
        setTitle("Login Form");
        setBounds(500, 100, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        c.add(title);

        user = new JLabel("Username :");
        user.setBounds(100, 100, 200, 30);
        add(user);

        username = new JTextField();
        username.setBounds(100, 150, 400, 30);
        add(username);

        pass = new JLabel("Password : ");
        pass.setBounds(100, 200, 200, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(100, 250, 400, 30);
        add(password);

        actype = new JComboBox(actypes);
        actype.setFont(new Font("Arial", Font.PLAIN, 15));
        actype.setSize(400, 30);
        actype.setLocation(100, 320);
        c.add(actype);

        login = new JButton("Login");
        login.setBounds(100, 400, 100, 30);
        add(login);
        login.addActionListener(this);

        reg = new JButton("Register");
        reg.setBounds(275, 400, 100, 30);
        add(reg);
        reg.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            
            Connection connection = null;
            try {
                // below two lines are used for connectivity.
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/sql6525508",
                        "root", "root");

                // mydb is database
                // mydbuser is name of database
                // mydbuser is password of database

                Statement statement;
                statement = connection.createStatement();
                ResultSet resultSet;
                Integer valid = 0;
                if (actype.getSelectedItem() == "Student") {
                    String query = "select * from students";
                    resultSet = statement.executeQuery(query);
                    String regno;
                    String USR;
                    String PSS;
                    USR = username.getText().trim();
                    PSS = password.getText();
                    while (resultSet.next()) {
                        regno = resultSet.getString("RegNo").trim();
                        if (regno.equals(username.getText()) && regno.contentEquals(password.getText())) {
                            valid = 1;
                            String r1 = resultSet.getString("Name");
                            String r2 = resultSet.getString("RollNo");
                            String r3 = resultSet.getString("Gender");
                            String r4 = resultSet.getString("Year");
                            String r5 = resultSet.getString("Branch");
                            String r6 = resultSet.getString("Address");
                            String r7 = resultSet.getString("Verified");
                            ViewFrame f = new ViewFrame();
                            f.update(r1, r2, r3, r4, r5, r6, regno, r7);
                            f.setVisible(true);
                            dispose();
                        }
                    }
                }
                else{
                    String query = "select * from teachers";
                    resultSet = statement.executeQuery(query);
                    String teachid;
                    String USR;
                    String PSS;
                    USR = username.getText().trim();
                    PSS = password.getText();
                    while (resultSet.next()) {
                        teachid = resultSet.getString("TeachId").trim();
                        if (teachid.equals(username.getText()) && teachid.contentEquals(password.getText())) {
                            valid = 1;
                            String r1 = resultSet.getString("Name");
                            String r2 = resultSet.getString("Gender");
                            String r3 = resultSet.getString("Address");
                            String r4 = resultSet.getString("RollNo");
                            ViewTeach f = new ViewTeach();
                            f.update(r1, r2, r3, r4);
                            f.setVisible(true);
                            dispose();
                        }
                    }
                }

                if (valid == 0) {
                    JOptionPane.showMessageDialog(login, "Wrong Username or Password");
                }

            } catch (Exception exception) {
                System.out.println(exception);
            }

        } else if (e.getSource() == reg) {
            EditFrame f = new EditFrame();
            f.update("", "", "", "", "", "", "", "", 1);
            f.setVisible(true);
        }

    }

}

class SignIn {

    public static void main(String[] args) throws Exception {
        Login L = new Login();
    }
}
