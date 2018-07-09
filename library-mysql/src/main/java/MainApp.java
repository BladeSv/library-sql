import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {

	public static void main(String[] args) {
		
		
		try(Connection connection= 	DriverManager.getConnection("jdbc:mysql://db4free.net:3306/bladesv_mytest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "bladesv", "12345678")) {
	
		
	System.out.println(connection);
	
	Statement st= connection.createStatement();
	//ResultSet rs=st.executeQuery("select * from book");
	ResultSet rs=st.executeQuery("select id_book,book.title, publisher.title from book inner join publisher where book.id_publisher =publisher.id_publisher");
	while(rs.next()) {
		System.out.println("Book id: "+rs.getInt("id_book")+", title: "+rs.getString("title")+", publishet ="+ rs.getString("publisher.title"));
		
	}
	PreparedStatement ps =connection.prepareStatement("select title from publisher where phone=?");
	ps.setString(1, "12345");
	ResultSet rs2 =ps.executeQuery();
	while (rs2.next()) {
		System.out.println("title="+rs2.getString("title"));
		
	}
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
