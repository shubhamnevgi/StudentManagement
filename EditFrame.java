import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EditFrame
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

	private String years[] = {
			"First Year (FE)", "Second Year (SE)",
			"Third Year (TE)", "Last Year (BE)"
	};
	private String branches[] = {
			"Information Technology", "Computer Science",
			"Mechanical Engineering", "Electrical Engineering",
			"Electronics & Telecomm. Engineering",
			"Chemical Engineering"
	};

	public EditFrame() {
		setTitle("Student Information");
		setBounds(300, 0, 900, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Student Information");
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

		regn = new JLabel("Reg No");
		regn.setFont(new Font("Arial", Font.PLAIN, 20));
		regn.setSize(100, 20);
		regn.setLocation(100, 150);
		c.add(regn);

		regno = new JTextField();
		regno.setFont(new Font("Arial", Font.PLAIN, 15));
		regno.setSize(150, 20);
		regno.setLocation(200, 150);
		c.add(regno);

		rollno = new JLabel("Roll No");
		rollno.setFont(new Font("Arial", Font.PLAIN, 20));
		rollno.setSize(100, 20);
		rollno.setLocation(100, 200);
		c.add(rollno);

		trollno = new JTextField();
		trollno.setFont(new Font("Arial", Font.PLAIN, 15));
		trollno.setSize(150, 20);
		trollno.setLocation(200, 200);
		c.add(trollno);

		gender = new JLabel("Gender");
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		gender.setSize(100, 20);
		gender.setLocation(100, 250);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(75, 20);
		male.setLocation(200, 250);
		c.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(275, 250);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		bname = new JLabel("Branch");
		bname.setFont(new Font("Arial", Font.PLAIN, 20));
		bname.setSize(250, 20);
		bname.setLocation(100, 300);
		c.add(bname);

		branch = new JComboBox(branches);
		branch.setFont(new Font("Arial", Font.PLAIN, 15));
		branch.setSize(250, 20);
		branch.setLocation(200, 300);
		c.add(branch);

		yearn = new JLabel("Year");
		yearn.setFont(new Font("Arial", Font.PLAIN, 20));
		yearn.setSize(250, 20);
		yearn.setLocation(100, 350);
		c.add(yearn);

		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(250, 20);
		year.setLocation(200, 350);
		c.add(year);

		add = new JLabel("Address");
		add.setFont(new Font("Arial", Font.PLAIN, 20));
		add.setSize(100, 20);
		add.setLocation(100, 400);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(200, 75);
		tadd.setLocation(200, 400);
		tadd.setLineWrap(true);
		c.add(tadd);

		term = new JCheckBox("I declare that the information provided by me on the above");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setSize(400, 20);
		term.setLocation(75, 500);
		c.add(term);

		add = new JLabel("form is true and correct to the best of my knowledge and belif.");
		add.setFont(new Font("Arial", Font.PLAIN, 15));
		add.setSize(400, 20);
		add.setLocation(90, 520);
		c.add(add);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 570);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(270, 570);
		reset.addActionListener(this);
		c.add(reset);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(400, 25);
		res.setLocation(100, 610);
		c.add(res);

		setVisible(true);
	}

	public void update(String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, Integer Flag) {
		tname.setText(d1);
		trollno.setText(d2);
		if (d3 == "Male") {
			male.setSelected(true);
		} else if (d3 == "Female") {
			female.setSelected(true);
		}
		branch.setSelectedItem(d4);
		year.setSelectedItem(d5);

		tadd.setText(d6);
		if (d7.toString().equals("Y")) {
			tname.setEditable(false);
			regno.setEditable(false);
			reset.setEnabled(false);
			s8 = "Y";
		}
		Fg = Flag;
		regno.setText(d8);

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
					if (Fg == 1) {
						query = "insert into Students (Name, RollNo, Gender, Branch, Year, Address, Verified, RegNo, Pass)"
								+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					} else if (Fg == 2) {
						query = "update Students set Name=?, RollNo=?, Gender=?, Branch=?, Year=?, Address=? where RegNo=? ";
					}
					String s3;
					String s1 = tname.getText();
					if (male.isSelected())
						s3 = "Male";
					else
						s3 = "Female";
					String s2 = trollno.getText();

					String s4 = (String) branch.getSelectedItem();
					String s5 = (String) year.getSelectedItem();
					String s6 = tadd.getText();
					String s7 = regno.getText();

					if (Fg == 1) {
						ps = con.prepareStatement(query);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
						ps.setString(6, s6);
						ps.setString(7, s8);
						ps.setString(8, s7);
						ps.setString(9, s7);
						ps.executeUpdate();
						System.out.println("Record is updated successfully......");
					} else if (Fg == 2) {
						ps = con.prepareStatement(query);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
						ps.setString(6, s6);
						ps.setString(7, s7);

						ps.executeUpdate();
						System.out.println("Record is updated successfully......");
					}
					if (s1.length() == 0 || s2.length() == 0) {
						res.setForeground(Color.red);
						res.setText("Please fill all fields..");
					} else {
						ViewFrame f = new ViewFrame();
						f.update(s1, s2, s3, s4, s5, s6, s7, s8);
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
class Registration {

	public static void main(String[] args) throws Exception {
		EditFrame f = new EditFrame();
	}
}
