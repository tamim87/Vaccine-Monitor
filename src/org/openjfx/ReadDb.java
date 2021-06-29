package org.openjfx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDb
{
	public static void readtable()
	{
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "SELECT * FROM users";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			System.out.println("Complete Table:\n\n");
			while (rs.next())
			{
				String uname = rs.getString("username");
				String uemail = rs.getString(2);
				String uphone = rs.getString(3);
				String upass = rs.getString("password");
				
				System.out.println("User: "+uname);
				System.out.println("Email: "+uemail);
				System.out.println("Phone: "+uphone);
				System.out.println("Password: "+upass+"\n\n");
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.toString());
//			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) 
			{
				System.out.println(e.toString());
//				e.printStackTrace();
			}
		}
	}
	
	
	public static void readspecificrow()
	{
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "Select username from users where email = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, "wintersoldier@shield.com");
			rs = ps.executeQuery();
			
			String uname = rs.getString(1);
			
			System.out.println("Username: "+uname);
				
		}
		catch (SQLException e) 
		{
			System.out.println(e.toString());
//			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) 
			{
				System.out.println(e.toString());
//				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void getTotalNumberofUsers()
	{
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "Select count(username) from users ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int size = rs.getInt(1);		
			System.out.println("We have: "+size+ " users");
	
		}
		catch (SQLException e) 
		{
			System.out.println(e.toString());
//			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) 
			{
				System.out.println(e.toString());
//				e.printStackTrace();
			}
		}
	}
	
	
	
//
//	public static void getTotalNumberofUsers()
//	{
//		Connection con = DbConnection.connect();
//		PreparedStatement ps = null;
//		ResultSet rs = null ;
//		
//		try
//		{
//			String sql = "Select count(username) from users where email = ? ";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, "wintersoldier@shield.com");
//			rs = ps.executeQuery();
//			
//			String uname = rs.getString(1);
//			
//			System.out.println("Username: "+uname);
//				
//		}
//		catch (SQLException e) 
//		{
//			System.out.println(e.toString());
////			e.printStackTrace();
//		}
//		finally 
//		{
//			try 
//			{
//				rs.close();
//				ps.close();
//				con.close();
//			} catch (SQLException e) 
//			{
//				System.out.println(e.toString());
////				e.printStackTrace();
//			}
//		}
//	}
	
}
