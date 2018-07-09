package by.htp.dao;

import java.util.List;

import by.htp.entity.Book;

public interface BookDao {

		Book read(int id);
		List<Book> list();
		int add(Book book);
		void delete(Book book);
		void update(Book book);
}
