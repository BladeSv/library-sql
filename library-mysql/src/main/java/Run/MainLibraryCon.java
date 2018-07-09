package Run;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import by.htp.dao.BookDao;
import  by.htp.dao.imple.BookDaoImple;
import by.htp.entity.Autor;
import by.htp.entity.Book;

public class MainLibraryCon {

	public static void main(String[] args) {
		BookDaoImple dao =new BookDaoImple();
Book book= dao.read(2);
System.out.println(book);
System.out.println();
List <Book> listBook=dao.list();

for(Book b: listBook ) {
	System.out.println(b);
	
}

Autor au =new Autor();
Book newB =new Book("BestBook", au);
int z=  dao.getMaxId("book");
System.out.println(z);



GregorianCalendar gc =new GregorianCalendar(1230,03,03);
Date t=new Date( gc.getTimeInMillis());

System.out.println(t);










//dao.delete(newB);


	}

}
