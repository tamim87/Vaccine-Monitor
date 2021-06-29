package org.openjfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection connect() {
		Connection con = null ;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:vaccineMonitorDatabase.db");
			System.out.println("Database Connected");
		}catch(ClassNotFoundException | SQLException e){
			
			System.out.println(e + "");
		}
		return con ;
	}
}
