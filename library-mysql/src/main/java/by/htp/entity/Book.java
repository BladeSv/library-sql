package by.htp.entity;

public class Book {
 private String title;
 private Autor autor;
 private int id;
 
 
 
 
public Book() {
	super();
	// TODO Auto-generated constructor stub
}





public int getId() {
	return id;
}





public Book(String title, Autor autor, int id) {
	super();
	this.title = title;
	this.autor = autor;
	this.id = id;
}





public void setId(int id) {
	this.id = id;
}





public Book(String title, Autor autor) {
	super();
	this.title = title;
	this.autor = autor;
}





public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Autor getAutor() {
	return autor;
}
public void setAutor(Autor autor) {
	this.autor = autor;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((autor == null) ? 0 : autor.hashCode());
	result = prime * result + id;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (autor == null) {
		if (other.autor != null)
			return false;
	} else if (!autor.equals(other.autor))
		return false;
	if (id != other.id)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
@Override
public String toString() {
	return "Book [title=" + title + ", autor=" + autor + ", id=" + id + "]";
}
 
}
