import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

class ViewIAMarks
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
	private String ia[] = { "1", "2"};
	String stat;
	String reg;
	String yr;
	String br;
	JPanel panel = new JPanel();
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane(table);
	JFrame SBFrameDisplay;

	String[] columnNames = { "Year", "Branch", "RegNo", "SCode", "IA", "Obtained", "Total" };

	public ViewIAMarks() {
		setTitle("IA Marks");
		setBounds(300, 0, 900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("IA Marks - ");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(600, 30);
		title.setLocation(200, 30);
		c.add(title);

		regno = new JLabel();
		regno.setFont(new Font("Arial", Font.PLAIN, 30));
		regno.setSize(300, 30);
		regno.setLocation(460, 30);
		c.add(regno);

		monthn = new JLabel("IA : ");
		monthn.setFont(new Font("Arial", Font.PLAIN, 20));
		monthn.setSize(100, 20);
		monthn.setLocation(100, 100);
		c.add(monthn);

		month = new JComboBox(ia);
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

		// iamarks = new JButton("Attendance");
		// iamarks.setFont(new Font("Arial", Font.PLAIN, 18));
		// iamarks.setSize(200, 20);
		// iamarks.setLocation(600, 150);
		// iamarks.addActionListener(this);
		// // iamarks.setEnabled(false);
		// c.add(iamarks);

		// project = new JButton("Project");
		// project.setFont(new Font("Arial", Font.PLAIN, 18));
		// project.setSize(200, 20);
		// project.setLocation(600, 200);
		// project.addActionListener(this);
		// project.setEnabled(false);
		// c.add(project);

		// fees = new JButton("Fees");
		// fees.setFont(new Font("Arial", Font.PLAIN, 18));
		// fees.setSize(200, 20);
		// fees.setLocation(600, 250);
		// fees.addActionListener(this);
		// fees.setEnabled(false);
		// c.add(fees);


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

				String query = "select * from iamarks where RegNo = ? and Year = ? and Branch = ? and IA = ? ";
				//String query = "select * from attendance where RegNo = 'T-21-0470'";
				Integer mn = month.getSelectedIndex() + 1;
				PreparedStatement statement = connection.prepareStatement(query);
				System.out.println(statement);
				statement.setString(1, reg);
				System.out.println(reg);
				statement.setString(2, yr);
				System.out.println(br);
				statement.setString(3, br);
				System.out.println(yr);
				statement.setInt(4, mn);
				System.out.println(mn);

				ResultSet resultSet = statement.executeQuery();
				System.out.println(statement);
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
				SBFrameDisplay.add(scroll);
				SBFrameDisplay.setVisible(true);
				SBFrameDisplay.setSize(900, 450);
				SBFrameDisplay.setLocation(300, 200);

				while (resultSet.next()) {
					String r1 = resultSet.getString("Year");
					String r2 = resultSet.getString("Branch");
					String r3 = resultSet.getString("RegNo");
					String r4 = resultSet.getString("SCode");
					Integer r5 = resultSet.getInt("IA");
					String r6 = resultSet.getString("Obtained");
					String r7 = resultSet.getString("Total");
					model.addRow(new Object[] { r2, r1, r3, r4, r5, r6, r7 });
				}

			} catch (Exception exception) {
				System.out.println(exception);
			}
		} else if (e.getSource() == home) {
			this.dispose();
		}
	}

}

// Driver Code
class Marks {

	public static void main(String[] args) throws Exception {
		ViewIAMarks VA = new ViewIAMarks();
	}
}
