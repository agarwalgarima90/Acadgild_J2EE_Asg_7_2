package study;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class JDBCExample {

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection con = null;
        //Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

		try {

			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/calendarDetails", "postgres","postgres");
			//pst = con.prepareStatement("SELECT * from employee where \"memberName\" = \'Afrin\'");
			pst = con.prepareStatement("SELECT * from employee");
			rs = pst.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(": ");
                System.out.print(rs.getString(2));
                System.out.print(" - ");
                System.out.println(rs.getString(3));
            }
            
            pst = con.prepareStatement("UPDATE employee set \"memberName\" = \'Afrin_C\' where \"memberName\" = \'Afrin\'");
            pst.executeUpdate();
            

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

//		if (con != null) {
//			System.out.println("You made it, take control your database now!");
//		}
	}

}
