package by.htp.dao.imple;

import static by.htp.dao.util.MySqlPropretyManager.getLogin;
import static by.htp.dao.util.MySqlPropretyManager.getPass;
import static by.htp.dao.util.MySqlPropretyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.entity.Book;

public class ConnectionBD {

 private	 PreparedStatement ps;
	public  PreparedStatement read(String url) {
	
		try{
			Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() );	
	 ps=conn.prepareStatement(url);	
		
	
		}
		 catch (SQLException e) {
			
			e.printStackTrace();
			e.getMessage();
		}
		
		return ps;	
	}
}

