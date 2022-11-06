import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewTeach

		extends JFrame
		implements ActionListener {

	private Container c;
	private JLabel title;
	private JLabel name;
	private JLabel tname;
	private JLabel rollno;
	private JLabel trollno;
	private JLabel gendern;
	private JLabel gender;
	private JLabel year;
	private JLabel add;
	private JTextArea tadd;
	private JLabel yearn;
	private JLabel bname;
	private JLabel branch;
	private JLabel varified;
	private JLabel varstat;
	private JButton edit;
	private JButton logout;
	private JButton attendance;
	private JButton fees;
	private JButton iamarks;
	private JButton project;
	private JLabel regno;

	public ViewTeach() {
		setTitle("Teacher Profile");
		setBounds(300, 0, 900, 700);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Teacher Profile - ");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(600, 30);
		title.setLocation(200, 30);
		c.add(title);

		regno = new JLabel();
		regno.setFont(new Font("Arial", Font.PLAIN, 30));
		regno.setSize(300, 30);
		regno.setLocation(460, 30);
		c.add(regno);

		name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JLabel();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		gendern = new JLabel("Gender");
		gendern.setFont(new Font("Arial", Font.PLAIN, 20));
		gendern.setSize(100, 20);
		gendern.setLocation(100, 150);
		c.add(gendern);

		gender = new JLabel();
		gender.setFont(new Font("Arial", Font.PLAIN, 15));
		gender.setSize(75, 20);
		gender.setLocation(200, 150);
		c.add(gender);

		add = new JLabel("Address");
		add.setFont(new Font("Arial", Font.PLAIN, 20));
		add.setSize(100, 20);
		add.setLocation(100, 200);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(200, 75);
		tadd.setLocation(200, 200);
		tadd.setLineWrap(true);
		tadd.setEnabled(false);
		;
		c.add(tadd);

		varified = new JLabel("Admin : ");
		varified.setFont(new Font("Arial", Font.PLAIN, 20));
		varified.setSize(100, 50);
		varified.setLocation(600, 300);
		c.add(varified);

		varstat = new JLabel();
		varstat.setFont(new Font("Arial", Font.PLAIN, 15));
		varstat.setSize(100, 50);
		varstat.setLocation(600, 350);
		c.add(varstat);

		logout = new JButton("Logout");
		logout.setFont(new Font("Arial", Font.PLAIN, 15));
		logout.setSize(100, 20);
		logout.setLocation(300, 510);
		logout.addActionListener(this);
		c.add(logout);

		attendance = new JButton("Add Attendence");
		attendance.setFont(new Font("Arial", Font.PLAIN, 18));
		attendance.setSize(200, 20);
		attendance.setLocation(600, 100);
		attendance.addActionListener(this);
		c.add(attendance);

		iamarks = new JButton("Add IA Marks");
		iamarks.setFont(new Font("Arial", Font.PLAIN, 18));
		iamarks.setSize(200, 20);
		iamarks.setLocation(600, 150);
		iamarks.addActionListener(this);
		c.add(iamarks);


		setVisible(true);
	}

	public void update(String s1, String s2, String s3, String s4) {
		tname.setText(s1);
		gender.setText(s2);
		tadd.setText(s3);
		varstat.setText(s4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == edit) {
			String d1 = tname.getText();
			String d2 = trollno.getText();
			String d3 = gender.getText();
			String d4 = branch.getText();
			String d5 = year.getText();
			String d6 = tadd.getText();
			String d7 = varstat.getText().trim();
			String d8 = regno.getText();
			EditFrame f = new EditFrame();
			Integer fg = 2;
			f.setVisible(true);
			f.update(d1, d2, d3, d4, d5, d6, d7, d8, fg);
			dispose();
		}

		else if (e.getSource() == logout) {
			Login f = new Login();
			f.setVisible(true);
			dispose();
		}

		else if (e.getSource() == attendance) {
			Attendence A = new Attendence();
		}

		else if(e.getSource()== iamarks){
			IAMarks A = new IAMarks();
		}

		// else if (e.getSource() == ) {

		// }
	}
}

// Driver Code
class Teacher{

	public static void main(String[] args) throws Exception {
		ViewTeach f2 = new ViewTeach();
	}
}
