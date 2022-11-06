import java.sql.*;

public class Test{
	public static void main(String arg[])
	{
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

			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery(
				"select * from Students");
			int rollno;
			String regno;
			while (resultSet.next()) {
				rollno = resultSet.getInt("RollNo");
				regno = resultSet.getString("RegNo").trim();
				System.out.println("RollNo : " + rollno + " | "
								+ "RegNo : " + regno);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
	} // function ends
} // class ends
