package by.htp.dao.imple;
import static by.htp.dao.util.MySqlPropretyManager.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.dao.BookDao;
import by.htp.entity.Autor;
import by.htp.entity.Book;

public class BookDaoImple implements BookDao{
private static final String SELECT_BOOK_BYID="SELECT * FROM book WHERE id=?";
private static final String INSERT_BOOK="INSERT INTO book (title, autor) VALUES(?,?)";
private static final String DELETE_BOOK="DELETE FROM book WHERE title=?";
private PreparedStatement ps;
ConnectionBD conDB= new ConnectionBD();



private Book buildBook(ResultSet rs ) throws SQLException {
	Book book=new Book();
	book.setTitle(rs.getString(2));
	book.setId(rs.getInt(1));
	//book.setAutor(rs.getString(3));
	return book;
}



	@Override
	public Book read(int id) {
		Book book=null;
		try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
			
		PreparedStatement ps=conn.prepareStatement(SELECT_BOOK_BYID);	
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			book=buildBook(rs);
			
			
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public List<Book> list() {
		List<Book> listBook=new ArrayList<>();
		
		try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
			int id=1;
			int cheak=getMaxId("book");
			do {
			Book book=null;
			
			PreparedStatement ps=conn.prepareStatement(SELECT_BOOK_BYID);	
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				book=buildBook(rs);
				listBook.add(book);
				
			}
			id++;
			}while(id<=cheak);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		
		return listBook;
	}

	@Override
	public int add(Book book) {
		try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
			
			PreparedStatement ps=conn.prepareStatement(INSERT_BOOK);	
			ps.setString(1, book.getTitle());
			ps.setInt(2, 1);
			ps.executeUpdate();
			
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		
		return 0;
	}

	@Override
	public void delete(Book book) {
		
			try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
				
				PreparedStatement ps=conn.prepareStatement(DELETE_BOOK);	
				ps.setString(1, book.getTitle());
			
				ps.executeUpdate();
				
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
	}

	@Override
	public void update(Book book) {
		try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
			
			PreparedStatement ps=conn.prepareStatement(DELETE_BOOK);	
			ps.setString(1, book.getTitle());
		
			ps.executeUpdate();
			
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}

	public int getMaxId(String table) {
		int i=0;
		
		
		
		try(Connection conn= DriverManager.getConnection(getUrl(), getLogin(), getPass() )){
			String url="SELECT max(id) FROM " +table;
			PreparedStatement ps=conn.prepareStatement(url);	
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i=rs.getInt(1);
				
			
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		
		
		
		
		return i;
	}
	
}
