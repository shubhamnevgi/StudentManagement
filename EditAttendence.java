import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Attendence
        extends JFrame
        implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel subjectn;
    private JComboBox subject;
    private JComboBox year;
    private JLabel yearn;
    private JLabel bname;
    private JComboBox branch;
    private JLabel studentn;
    private JButton search;
    private JComboBox student;

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
    Integer no;
    Vector students = new Vector();
    Vector subjects = new Vector();

    private String mid[] = { "Select Month", "Jan-1", "Feb-2", "Mar-3", "Apr-4", "May-5", "June-6",
            "July-7", "Aug-8", "Sep-9", "Oct-10", "Nov-11", "Dec-12" };
    private JComboBox months;
    private JLabel monthsn;
    private JLabel present;
    private JLabel absent;
    private JLabel total;
    private JTextField pdays;
    private JTextField adays;
    private JTextField tdays;
    private JButton update;

    public Attendence() {
        setTitle("Attendance");
        setBounds(500, 100, 650, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Update Attendance");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        c.add(title);

        bname = new JLabel("Branch : ");
        bname.setFont(new Font("Arial", Font.PLAIN, 20));
        bname.setSize(150, 20);
        bname.setLocation(20, 100);
        c.add(bname);

        branch = new JComboBox(branches);
        branch.setFont(new Font("Arial", Font.PLAIN, 15));
        branch.setSize(200, 20);
        branch.setLocation(100, 100);
        c.add(branch);

        yearn = new JLabel("Year : ");
        yearn.setFont(new Font("Arial", Font.PLAIN, 20));
        yearn.setSize(150, 20);
        yearn.setLocation(310, 100);
        c.add(yearn);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(200, 20);
        year.setLocation(380, 100);
        c.add(year);

        Icon icon = new ImageIcon("search.png");
        search = new JButton(icon);
        search.setSize(35, 20);
        search.setLocation(600, 100);
        c.add(search);
        search.addActionListener(this);

        monthsn = new JLabel("Month : ");
        monthsn.setFont(new Font("Arial", Font.PLAIN, 18));
        monthsn.setSize(150, 20);
        monthsn.setLocation(20, 250);
        c.add(monthsn);

        months = new JComboBox(mid);
        months.setFont(new Font("Arial", Font.PLAIN, 16));
        months.setSize(300, 20);
        months.setLocation(100, 250);
        c.add(months);

        present = new JLabel("Present");
        present.setFont(new Font("Arial", Font.PLAIN, 20));
        present.setSize(150, 20);
        present.setLocation(400, 320);
        c.add(present);

        pdays = new JTextField("0");
        pdays.setFont(new Font("Arial", Font.PLAIN, 20));
        pdays.setSize(100, 50);
        pdays.setLocation(400, 350);
        c.add(pdays);

        absent = new JLabel("Absent");
        absent.setFont(new Font("Arial", Font.PLAIN, 20));
        absent.setSize(150, 20);
        absent.setLocation(250, 320);
        c.add(absent);

        adays = new JTextField("0");
        adays.setFont(new Font("Arial", Font.PLAIN, 20));
        adays.setSize(100, 50);
        adays.setLocation(250, 350);
        adays.addActionListener(this);
        c.add(adays);

        total = new JLabel("Total");
        total.setFont(new Font("Arial", Font.PLAIN, 20));
        total.setSize(150, 20);
        total.setLocation(100, 320);
        c.add(total);

        tdays = new JTextField("0");
        tdays.setFont(new Font("Arial", Font.PLAIN, 20));
        tdays.setSize(100, 50);
        tdays.setLocation(100, 350);
        tdays.addActionListener(this);
        c.add(tdays);

        update = new JButton("Update Attendance");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setSize(200, 30);
        update.setLocation(100, 450);
        update.addActionListener(this);
        c.add(update);

        students.add("Select Student");
        final DefaultComboBoxModel model = new DefaultComboBoxModel(students);
        student = new JComboBox(model);
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSize(300, 20);
        student.setLocation(100, 150);
        // student.setEnabled(false);
        c.add(student);
        setVisible(true);

        studentn = new JLabel("Student : ");
        studentn.setFont(new Font("Arial", Font.PLAIN, 18));
        studentn.setSize(250, 20);
        studentn.setLocation(20, 150);
        c.add(studentn);

        subjects.add("Select Subject");
        final DefaultComboBoxModel model2 = new DefaultComboBoxModel(subjects);
        subject = new JComboBox(model2);
        subject.setFont(new Font("Arial", Font.PLAIN, 15));
        subject.setSize(300, 20);
        subject.setLocation(100, 200);
        // subject.setEnabled(false);
        c.add(subject);
        setVisible(true);

        subjectn = new JLabel("Subject : ");
        subjectn.setFont(new Font("Arial", Font.PLAIN, 18));
        subjectn.setSize(150, 20);
        subjectn.setLocation(20, 200);
        c.add(subjectn);

    }

    private void getStudents() {
        Connection connection = null;

        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://sql6.freesqldatabase.com/sql6525508",
                    "sql6525508", "fhR7ggvEgj");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
            students.clear();
            students.add("Select Student");
            student.setSelectedIndex(0);
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            String query = "select * from Students";
            String yr, br, stat;
            Integer rn;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                br = resultSet.getString("Branch").trim();
                yr = resultSet.getString("Year").trim();
                rn = resultSet.getInt("RollNo");
                stat = resultSet.getString("Verified").trim();
                String Stu = resultSet.getString("Name").trim() + ":" + resultSet.getString("RegNo").trim();
                if (br.equals(branch.getSelectedItem()) && yr.equals(year.getSelectedItem()) && stat.equals("Y")) {
                    students.add(Stu);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    private void getSubjects() {

        Connection connection2 = null;

        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection2 = DriverManager.getConnection(
                    "jdbc:mysql://sql6.freesqldatabase.com/sql6525508",
                    "sql6525508", "fhR7ggvEgj");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
            subjects.clear();
            subjects.add("Select Subject");
            subject.setSelectedIndex(0);
            Statement statement2;
            statement2 = connection2.createStatement();
            ResultSet resultSet2;
            String query2 = "select * from Subjects";
            String yr2, br2;
            resultSet2 = statement2.executeQuery(query2);
            while (resultSet2.next()) {
                br2 = resultSet2.getString("Branch").trim();
                yr2 = resultSet2.getString("Year").trim();
                String Sub = resultSet2.getString("SCode").trim() + ":" + resultSet2.getString("SName").trim();
                if (br2.equals(branch.getSelectedItem()) && yr2.equals(year.getSelectedItem())) {
                    subjects.add(Sub);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public void actionPerformed(ActionEvent e) {
        Integer valid = 1;
        if (e.getSource() == search) {
            student.setEnabled(true);
            subject.setEnabled(true);
            getStudents();
            getSubjects();
        } else if (e.getSource() == adays || e.getSource() == tdays) {
            Integer t = Integer.parseInt(tdays.getText());
            Integer a = Integer.parseInt(adays.getText());
            Integer p = t - a;
            pdays.setText(p.toString());
        } else if (e.getSource() == update) {
            if (student.getSelectedItem().toString() == "Select Student") {
                JOptionPane.showMessageDialog(student, "Select Student");
                valid = 0;
            } else if (subject.getSelectedItem().toString() == "Select Subject") {
                JOptionPane.showMessageDialog(subject, "Select Subject");
                valid = 0;
            } else if (months.getSelectedItem().toString() == "Select Month") {
                JOptionPane.showMessageDialog(months, "Select Month");
                valid = 0;
            }
            if (valid == 1) {
                Connection con = null;
                PreparedStatement ps = null;
                try {
                    String v2 = (String) branch.getSelectedItem();
                    String v1 = (String) year.getSelectedItem();
                    String st[] = ((String) student.getSelectedItem()).split(":");
                    String v3 = st[1];
                    String su[] = ((String) subject.getSelectedItem()).split(":");
                    String v4 = su[0];
                    String mo[] = ((String) months.getSelectedItem()).split("-");
                    Integer v5 = Integer.parseInt(mo[1]);
                    Integer v6 = Integer.parseInt(tdays.getText());
                    Integer v7 = Integer.parseInt(adays.getText());
                    Integer v8 = v6 - v7;

                    System.out.println(v1);
                    System.out.println(v2);
                    System.out.println(v3);
                    System.out.println(v4);
                    System.out.println(v5);
                    System.out.println(v6);
                    System.out.println(v7);
                    System.out.println(v8);

                    con = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6525508",
                            "sql6525508", "fhR7ggvEgj");
                    String query = "";
                    query = "insert into Attendance (Year, Branch, RegNo, SCode, Mid, PresentD, AbsentD, Total)"
                            + " values (?, ?, ?, ?, ?, ?, ?, ?)";

                    ps = con.prepareStatement(query);
                    ps.setString(1, v1);
                    ps.setString(2, v2);
                    ps.setString(3, v3);
                    ps.setString(4, v4);
                    ps.setInt(5, v5);
                    ps.setInt(6, v6);
                    ps.setInt(7, v7);
                    ps.setInt(8, v8);

                    ps.executeUpdate();
                    System.out.println("Record is updated successfully......");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }

    }


}

class EditAttendence {

    public static void main(String[] args) throws Exception {
        Attendence A = new Attendence();
    }
}
