import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

class ViewAttendance
		extends JFrame
		implements ActionListener {

	private Container c;
	private JLabel title;
	private JLabel regno;
	private JComboBox month;
	private JLabel monthn;
	private JButton search;
	private JButton home;
	private JButton fees;
	private JButton iamarks;
	private JButton project;
	private String mid[] = { "Select Month", "Jan-1", "Feb-2", "Mar-3", "Apr-4", "May-5", "June-6",
			"July-7", "Aug-8", "Sep-9", "Oct-10", "Nov-11", "Dec-12" };
	String stat;
	String reg;
	String yr;
	String br;
	JPanel panel = new JPanel();
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane(table);
	JFrame SBFrameDisplay;

	String[] columnNames = { "Year", "Branch", "RegNo", "SCode", "Mid", "PresentD", "AbsentD", "Total" };

	public ViewAttendance() {
		setTitle("Student home");
		setBounds(300, 0, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Student home - ");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(600, 30);
		title.setLocation(200, 30);
		c.add(title);

		regno = new JLabel();
		regno.setFont(new Font("Arial", Font.PLAIN, 30));
		regno.setSize(300, 30);
		regno.setLocation(460, 30);
		c.add(regno);

		monthn = new JLabel("Month : ");
		monthn.setFont(new Font("Arial", Font.PLAIN, 20));
		monthn.setSize(100, 20);
		monthn.setLocation(100, 100);
		c.add(monthn);

		month = new JComboBox(mid);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(190, 20);
		month.setLocation(200, 100);
		c.add(month);

		Icon icon = new ImageIcon("search.png");
		search = new JButton(" View");
		search.setIcon(icon);
		search.setSize(110, 20);
		search.setLocation(410, 100);
		c.add(search);
		search.addActionListener(this);

		home = new JButton("Home");
		home.setFont(new Font("Arial", Font.PLAIN, 18));
		home.setSize(200, 20);
		home.setLocation(600, 100);
		home.addActionListener(this);
		c.add(home);

		iamarks = new JButton("IA Marks");
		iamarks.setFont(new Font("Arial", Font.PLAIN, 18));
		iamarks.setSize(200, 20);
		iamarks.setLocation(600, 150);
		iamarks.addActionListener(this);
		iamarks.setEnabled(false);
		c.add(iamarks);

		project = new JButton("Project");
		project.setFont(new Font("Arial", Font.PLAIN, 18));
		project.setSize(200, 20);
		project.setLocation(600, 200);
		project.addActionListener(this);
		project.setEnabled(false);
		c.add(project);

		fees = new JButton("Fees");
		fees.setFont(new Font("Arial", Font.PLAIN, 18));
		fees.setSize(200, 20);
		fees.setLocation(600, 250);
		fees.addActionListener(this);
		fees.setEnabled(false);
		c.add(fees);

		if (stat == "Y") {
			fees.setEnabled(true);
			iamarks.setEnabled(true);
			project.setEnabled(true);
		}

		setVisible(true);
	}

	public void update(String s1, String s2, String s3, String s4) {
		regno.setText(s1);
		reg = s1;
		stat = s2;
		yr = s4;
		br = s3;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost/sql6525508",
						"root", "root");

				String query = "select * from Attendance where RegNo = ? and Year = ? and Branch = ? and Mid = ? ";
				Integer mn = month.getSelectedIndex();
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, reg);
				System.out.println(reg);
				statement.setString(2, yr);
				System.out.println(br);
				statement.setString(3, br);
				System.out.println(yr);
				statement.setInt(4, mn);
				System.out.println(mn);

				ResultSet resultSet = statement.executeQuery();

				SBFrameDisplay = new JFrame("Database Search Result");
				SBFrameDisplay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				SBFrameDisplay.setLayout(new BorderLayout());
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table = new JTable();
				table.setModel(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

				while (resultSet.next()) {
					String r1 = resultSet.getString("Year");
					String r2 = resultSet.getString("Branch");
					String r3 = resultSet.getString("RegNo");
					String r4 = resultSet.getString("SCode");
					String r5 = resultSet.getString("Mid");
					String r6 = resultSet.getString("PresentD");
					String r7 = resultSet.getString("AbsentD");
					String r8 = resultSet.getString("Total");
					model.addRow(new Object[] { r1, r2, r3, r4, r5, r6, r7, r8 });
				}

				SBFrameDisplay.add(scroll);
				SBFrameDisplay.setVisible(true);
				SBFrameDisplay.setSize(900, 450);
				SBFrameDisplay.setLocation(300, 200);

			} catch (Exception exception) {
				System.out.println(exception);
			}
		} else if (e.getSource() == home) {
			this.dispose();
		}
	}

}

// Driver Code
class Attendance {

	public static void main(String[] args) throws Exception {
		ViewAttendance VA = new ViewAttendance();
	}
}
