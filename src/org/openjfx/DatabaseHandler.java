package org.openjfx;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

public final class DatabaseHandler
{
	private static DatabaseHandler handler = null ;
	private static final String db_url = "jdbc:derby:database;create=true";
	private static Connection con = null;
	private static Statement stmt = null; 
	
	private DatabaseHandler()
	{
		createConnection();
		setupUserTable(); 
	}
	
	public static DatabaseHandler getInstance()
	{
		if(handler == null )
		{
			handler = new DatabaseHandler();
		}
		return handler;
	}
	
	private static void createConnection()
	{
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			con = DriverManager.getConnection(db_url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setupUserTable()
	{
		String TABLE_NAME = "USER" ;
		try 
		{
			stmt = con.createStatement();
			
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null , TABLE_NAME.toUpperCase() , null);
			
			if(tables.next())
			{
				System.out.println("Table " + TABLE_NAME + " Table already exists");
			}
			else
			{
				stmt.execute("CREATE TABLE " + TABLE_NAME + "("
						+ "		username varchar(200) primary key,\n"
						+ "		email varchar(200),\n"
						+ "		phone varchar(200),\n"
						+ "		password varchar(200)"
						+ " )");		
			}
		} 
		catch (SQLException e) 
		{
			// TODO: handle exception
//			System.err.println("Exception: (toLoginPage)" + exception);
//			System.out.println("Exception: (database Error)" + e);
			System.err.println(e.getMessage() + " ---setupDatabase");
			e.printStackTrace();
			e.getCause();
		}
		finally {
			
		}
	}
	
	
	public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }

    public boolean execAction(String qu) {
        try {
            stmt = con.createStatement();
            stmt.execute(qu);
            return true;
        }
        catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        }
        finally {
        }
    }
	
	
	
	
	
	
}
