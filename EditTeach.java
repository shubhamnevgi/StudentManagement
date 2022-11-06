import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EditTeach
		extends JFrame
		implements ActionListener {

	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel rollno;
	private JTextField trollno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JComboBox year;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JLabel yearn;
	private JButton sub;
	private JButton reset;
	private JLabel res;
	private JTextArea resadd;
	private JLabel bname;
	private JComboBox branch;
	Integer Fg;
	String s8 = "N";
	private JLabel regn;
	private JTextField regno;

	public EditTeach() {
		setTitle("Teacher Information");
		setBounds(300, 0, 900, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Teacher Information");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		regn = new JLabel("Teacher Id");
		regn.setFont(new Font("Arial", Font.PLAIN, 20));
		regn.setSize(100, 20);
		regn.setLocation(100, 150);
		c.add(regn);

		regno = new JTextField();
		regno.setFont(new Font("Arial", Font.PLAIN, 15));
		regno.setSize(150, 20);
		regno.setLocation(200, 150);
		c.add(regno);

		gender = new JLabel("Gender");
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		gender.setSize(100, 20);
		gender.setLocation(100, 200);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(75, 20);
		male.setLocation(200, 200);
		c.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(275, 200);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		add = new JLabel("Address");
		add.setFont(new Font("Arial", Font.PLAIN, 20));
		add.setSize(100, 20);
		add.setLocation(100, 250);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(200, 75);
		tadd.setLocation(200, 250);
		tadd.setLineWrap(true);
		c.add(tadd);

		term = new JCheckBox("I declare that the information provided by me on the above");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setSize(400, 20);
		term.setLocation(75, 350);
		c.add(term);

		add = new JLabel("form is true and correct to the best of my knowledge and belif.");
		add.setFont(new Font("Arial", Font.PLAIN, 15));
		add.setSize(400, 20);
		add.setLocation(90, 370);
		c.add(add);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 420);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(270, 420);
		reset.addActionListener(this);
		c.add(reset);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(400, 25);
		res.setLocation(100, 460);
		c.add(res);

		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {

			if (term.isSelected()) {
				Connection con = null;
				PreparedStatement ps = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1/sql6525508",
                        "root", "root");
						// con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sql6525508");
					String query = "";
						query = "insert into teacher (Name, Gender, Address, Admin, RegNo)"
								+ " values (?, ?, ?, ?, ?)";

                        System.out.println(query);

					String s2;
					String s1 = tname.getText();
					if (male.isSelected())
						s2 = "Male";
					else
						s2 = "Female";

					String s3 = tadd.getText();
                    String s4 = "Y";
					String s5 = regno.getText();

                    System.out.println(s1);
                    System.out.println(s2);
                    System.out.println(s3);
                    System.out.println(s4);

						ps = con.prepareStatement(query);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
                        System.out.println(ps);
						ps.executeUpdate();
						System.out.println("Record is updated successfully......");
					if (s1.length() == 0 || s2.length() == 0) {
						res.setForeground(Color.red);
						res.setText("Please fill all fields..");
					} else {
						ViewTeach f = new ViewTeach();
						f.update(s1, s2, s3, s4);
						f.setVisible(true);
						dispose();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} else {
				res.setForeground(Color.red);
				res.setText("Please accept the"
						+ " terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tadd.setText(def);
			trollno.setText(def);
			res.setText(def);
			term.setSelected(false);
			branch.setSelectedIndex(0);
			resadd.setText(def);
		}
	}
}

// Driver Code
class Registration2 {

	public static void main(String[] args) throws Exception {
		EditTeach f = new EditTeach();
	}
}
