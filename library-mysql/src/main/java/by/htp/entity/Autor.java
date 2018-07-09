package by.htp.entity;

import java.util.Calendar;

public class Autor {
private int id;
private String name;
private String surname;
private Calendar bithDate;



public Autor(int id, String name, String surname, Calendar bithDate) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.bithDate = bithDate;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Autor() {
	super();
	// TODO Auto-generated constructor stub
}


public Autor(String name, String surname, Calendar bithDate) {
	super();
	this.name = name;
	this.surname = surname;
	this.bithDate = bithDate;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public Calendar getBithDate() {
	return bithDate;
}
public void setBithDate(Calendar bithDate) {
	this.bithDate = bithDate;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bithDate == null) ? 0 : bithDate.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
	Autor other = (Autor) obj;
	if (bithDate == null) {
		if (other.bithDate != null)
			return false;
	} else if (!bithDate.equals(other.bithDate))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	return true;
}
@Override
public String toString() {
	return "Autor [id=" + id + ", name=" + name + ", surname=" + surname + ", bithDate=" + bithDate + "]";
}



}
