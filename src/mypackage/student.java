package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class student {
	public void createDatabases() {
		try {
			String url = "jdbc:mysql://localhost:3306";
			String username = "root";
			String passwd = "passwd12";
			
			Connection conn = DriverManager.getConnection(url, username, passwd);
			
			Statement stm = conn.createStatement();
			String query = "create database java";
			stm.execute(query);

			System.out.println("Conneted Successful ");
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/java";
			String username = "root";
			String passwd = "passwd12";
			
			Connection conn = DriverManager.getConnection(url, username, passwd);
			
			Statement stm = conn.createStatement();
//			String query = "create table student(roll int(3), Name varchar(255), Email varchar(255))";
//			String query="insert into student values(?,'?','?')";
			String query="select * from student";
			var name = stm.execute(query);

			System.out.println("Table Successful"+name);
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createData() {
		try {
			String url = "jdbc:mysql://localhost:3306/java";
			String username = "root";
			String passwd = "passwd12";
			
			Connection conn = DriverManager.getConnection(url, username, passwd);
			
			Statement stm = conn.createStatement();
			String query="insert into student (roll, Name, Email) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setInt(1,2);
			pstm.setString(2, "Rahul");
			pstm.setString(3, "rahul@gmail.com");
			
			pstm.execute();
			System.out.print("Data Add");
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
